package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

/**
 * Created by mars on 2/10/2018.
 */
@Entity
@Table(name = "core_message", schema = "dbo", catalog = "sainagram")
public class CoreMessage {
    private int messageId;
    private String messageContext;
    private String messageDate;
    private String messagePath;
    private String messageType;

    private CoreUser user;
    private CoreChatRoom chatRoom;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "message_context")
    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    @Basic
    @Column(name = "message_date")
    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    @Basic
    @Column(name = "message_path")
    public String getMessagePath() {
        return messagePath;
    }

    public void setMessagePath(String messagePath) {
        this.messagePath = messagePath;
    }

    @Basic
    @Column(name = "message_type")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreMessage that = (CoreMessage) o;

        if (messageId != that.messageId) return false;
        if (messageContext != null ? !messageContext.equals(that.messageContext) : that.messageContext != null)
            return false;
        if (messageDate != null ? !messageDate.equals(that.messageDate) : that.messageDate != null) return false;
        if (messagePath != null ? !messagePath.equals(that.messagePath) : that.messagePath != null) return false;
        if (messageType != null ? !messageType.equals(that.messageType) : that.messageType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + (messageContext != null ? messageContext.hashCode() : 0);
        result = 31 * result + (messageDate != null ? messageDate.hashCode() : 0);
        result = 31 * result + (messagePath != null ? messagePath.hashCode() : 0);
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "meesage_user_id", referencedColumnName = "user_id", nullable = false)
    public CoreUser getUser() {
        return user;
    }

    public void setUser(CoreUser user) {
        this.user = user;
    }

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "message_chat_id", referencedColumnName = "chat_id")
    public CoreChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(CoreChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
