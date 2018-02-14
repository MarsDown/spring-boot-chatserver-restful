package com.example.demo.Repository;

import com.example.demo.Entity.CoreMessage;
import com.example.demo.Entity.CoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mars on 2/9/2018.
 */
public interface UserRepo extends JpaRepository<CoreUser,Integer> {

    @Query("select u from CoreUser u where u.userId != :userId")
    List<CoreUser> findAllWithou(@Param("userId") Integer userId);

}
