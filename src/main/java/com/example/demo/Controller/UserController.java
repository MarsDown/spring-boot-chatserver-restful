package com.example.demo.Controller;

import com.example.demo.Repository.UserRepo;
import com.example.demo.Entity.CoreUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mars on 2/9/2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public CoreUser saveUser(@RequestBody CoreUser coreUser) {
        userRepo.save(coreUser);

//        CoreChatRoom chatRoom = new CoreChatRoom();
//        chatRoom.setChatId(4);
//
//        CoreUser user = new CoreUser();
//        user.setUserId(16);
//
//        CoreMessage message = new CoreMessage();
//        message.setChatRoom(chatRoom);
//        message.setUser(user);
//        message.setMessageType("text");
//        message.setMessageContext("oppssssss");
//        messageController.saveMessage(message);

        return coreUser;
    }

    @PostMapping("/getUser")
    public CoreUser get(@RequestParam("userId") Integer userId) {
        CoreUser user = userRepo.findOne(userId);
        return user;
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public CoreUser updateUser(@RequestBody CoreUser coreUser) {

        userRepo.save(coreUser);

        return coreUser;
    }


}
