package com.example.demo.Controller;

import com.example.demo.Entity.CoreChatRoom;
import com.example.demo.Entity.CoreUser;
import com.example.demo.Repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mars on 2/12/2018.
 */
@RestController
public class ChatRoomController {

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @PostMapping("/getChatRoomInfo")
    public CoreChatRoom get(@RequestParam("chatId") Integer chatId) {
        CoreChatRoom chatRoom = chatRoomRepository.findOne(chatId);
        return chatRoom;
    }
}
