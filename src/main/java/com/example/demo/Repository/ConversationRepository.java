package com.example.demo.Repository;

import com.example.demo.Entity.CoreConversation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mars on 2/10/2018.
 */
public interface ConversationRepository extends JpaRepository<CoreConversation,Integer> {
}
