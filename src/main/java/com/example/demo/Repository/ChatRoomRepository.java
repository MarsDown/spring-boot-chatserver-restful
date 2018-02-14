package com.example.demo.Repository;

import com.example.demo.Entity.CoreChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mars on 2/12/2018.
 */
public interface ChatRoomRepository extends JpaRepository<CoreChatRoom,Integer> {
}
