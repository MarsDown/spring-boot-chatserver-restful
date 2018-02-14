package com.example.demo.Controller;

import com.example.demo.Entity.CoreChatRoom;
import com.example.demo.Entity.CoreUser;
import com.example.demo.Model.MessageModel;
import com.example.demo.Repository.ConversationRepository;
import com.example.demo.Repository.MessageRepository;
import com.example.demo.Repository.UserRepo;
import com.example.demo.StorageService;
import com.example.demo.fcm.FcmNotificationSender;
import com.example.demo.Entity.CoreMessage;
import javafx.scene.control.Pagination;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mars on 2/8/2018.
 */
@RestController
public class MessageController {

    @Autowired
    StorageService storageService;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ConversationRepository conversationRepository;

    FcmNotificationSender notificationSender;

    List<String> files = new ArrayList<>();

    @PostMapping("/getMessages")
    public List<CoreMessage> getMessage(@RequestParam("chatId") Integer chatId,@RequestParam("take") Integer take,@RequestParam("skip") Integer skip) {
        Page<CoreMessage> pages = messageRepository.findByChatId(chatId, new PageRequest(skip, take, Sort.Direction.DESC, "messageId"));
        return pages.getContent();
    }

    @PostMapping("/loadLastMessage")
    public CoreMessage loadLastMessage(@RequestParam("messageId") Integer messageId) {
       return messageRepository.findOne(messageId);
    }

    @RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
    public CoreMessage saveMessage(@RequestBody CoreMessage message) {
        FcmNotificationSender notifi = new FcmNotificationSender();
        CoreMessage save = messageRepository.save(message);

        List<CoreUser> users = userRepo.findAllWithou(message.getUser().getUserId());

        String[] listuserst = new String[users.size()];

        int index = 0;
        for (CoreUser item : users) {
            listuserst[index] = item.getToken();
            index++;
        }

        notifi.NewMessage(listuserst, save.getMessageId());
        return message;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String messages(@RequestParam("filename") MultipartFile file, @RequestParam("chatId") Integer chatId, @RequestParam("userId") Integer userId) {

        CoreChatRoom chatRoom = new CoreChatRoom();
        chatRoom.setChatId(chatId);

        CoreUser user = new CoreUser();
        user.setUserId(userId);

        CoreMessage message = new CoreMessage();
        String typeFile = "";
        if (file.getContentType() != null) {
            String[] split = file.getContentType().split("/");
            typeFile = split[0];
            String formatFile = split[1];
        }

        message.setMessageType(typeFile);

        message.setUser(user);
        message.setChatRoom(chatRoom);

        System.out.println("on Message");

        try {
            storageService.store(file);

            files.add(file.getOriginalFilename());

            message.setMessagePath("http://10.0.2.2:8080/files/" + file.getOriginalFilename());
            messageRepository.save(message);
        } catch (Exception e) {
        }

        return "{}";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
