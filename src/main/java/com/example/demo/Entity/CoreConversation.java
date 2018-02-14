package com.example.demo.Entity;

import javax.persistence.*;

/**
 * Created by mars on 2/10/2018.
 */
@Entity
@Table(name = "core_conversation", schema = "dbo", catalog = "sainagram")
public class CoreConversation {
    private int id;
    private CoreUser user;
    private CoreChatRoom chatRoom;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public CoreUser getUser() {
        return user;
    }
    public void setUser(CoreUser user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    public CoreChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(CoreChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreConversation that = (CoreConversation) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
