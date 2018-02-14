package com.example.demo.Model;

import com.example.demo.Entity.CoreUser;

/**
 * Created by mars on 2/10/2018.
 */
public class MessageModel {
    private int messageId;
    private String messageContext;
    private String messageDate;
    private String messagePath;
    private String messageType;

    private CoreUser user;
    private Integer chatRoom;

    public CoreUser getUser() {
        return user;
    }

    public void setUser(CoreUser user) {
        this.user = user;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessagePath() {
        return messagePath;
    }

    public void setMessagePath(String messagePath) {
        this.messagePath = messagePath;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Integer getChatRoom ( ) {
        return chatRoom;
    }

    public void setChatRoom ( Integer chatRoom ) {
        this.chatRoom = chatRoom;
    }
}
