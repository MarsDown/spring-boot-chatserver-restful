package com.example.demo.Controller;

import com.example.demo.Repository.ConversationRepository;
import com.example.demo.Entity.CoreConversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mars on 2/10/2018.
 */
@RestController
public class ChatController {

    @Autowired
    ConversationRepository conversationRepository;

    @PostMapping("/getConversation")
    public List<CoreConversation> get(@RequestParam("chatId") Integer chatId) {
        if (chatId != null && chatId >= 0) {
           return conversationRepository.findAll();
        }

        return null;
    }
}
