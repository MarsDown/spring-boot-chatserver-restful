package com.example.demo.Repository;

import com.example.demo.Entity.CoreMessage;
import javafx.scene.control.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mars on 2/9/2018.
 */
public interface MessageRepository extends JpaRepository<CoreMessage,Integer> {

//    ORDER BY [message_id] desc
//    OFFSET 10 ROWS -- skip 10 rows0000000
//    FETCH NEXT 10 ROWS ONLY -- take 10 rows
//order by ms.messageId desc

//    @Query("select ms from CoreMessage ms where ms.chatRoom.chatId = :chatId order by ms.messageId desc ")
//    List<CoreMessage> findByChatId(@Param("chatId") Integer chatId);

    @Query("select ms from CoreMessage ms where ms.chatRoom.chatId = :chatId")
    Page<CoreMessage> findByChatId(@Param("chatId") Integer chatId, Pageable pageRequest);

    @Query("select  ms from CoreMessage ms where ms.messageId = :messageId")
    List<CoreMessage> findByMessageId(@Param("messageId") Integer messageId);


}
