package com.example.demo.Entity;

import javax.persistence.*;

/**
 * Created by mars on 2/10/2018.
 */
@Entity
@Table(name = "core_chat_room", schema = "dbo", catalog = "sainagram")
public class CoreChatRoom {
    private int chatId;
    private String chatName;
    private String chatDescription;
    private String chatType;
    private String chatImageProfile;

    @Id
    @Column(name = "chat_id")
    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    @Basic
    @Column(name = "chat_name")
    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    @Basic
    @Column(name = "chat_description")
    public String getChatDescription() {
        return chatDescription;
    }

    public void setChatDescription(String chatDescription) {
        this.chatDescription = chatDescription;
    }

    @Basic
    @Column(name = "chat_type")
    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    @Basic
    @Column(name = "chat_image_profile")
    public String getChatImageProfile() {
        return chatImageProfile;
    }

    public void setChatImageProfile(String chatImageProfile) {
        this.chatImageProfile = chatImageProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreChatRoom that = (CoreChatRoom) o;

        if (chatId != that.chatId) return false;

        if (chatName != null ? !chatName.equals(that.chatName) : that.chatName != null) return false;
        if (chatImageProfile!= null ? !chatImageProfile.equals(that.chatImageProfile) : that.chatImageProfile!= null) return false;


        if (chatDescription != null ? !chatDescription.equals(that.chatDescription) : that.chatDescription != null)
            return false;
        if (chatType != null ? !chatType.equals(that.chatType) : that.chatType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chatId;
        result = 31 * result + (chatName != null ? chatName.hashCode() : 0);
        result = 31 * result + (chatDescription != null ? chatDescription.hashCode() : 0);
        result = 31 * result + (chatImageProfile != null ? chatImageProfile.hashCode() : 0);
        result = 31 * result + (chatType != null ? chatType.hashCode() : 0);
        return result;
    }
}
