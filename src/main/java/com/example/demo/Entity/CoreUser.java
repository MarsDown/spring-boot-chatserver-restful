package com.example.demo.Entity;

import javax.persistence.*;

/**
 * Created by mars on 2/10/2018.
 */
@Entity
@Table(name = "core_user", schema = "dbo", catalog = "sainagram")
public class CoreUser {
    private int userId;
    private String name;
    private String username;
    private String phone;
    private String image;
    private Boolean state;
    private String token;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "state")
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreUser coreUser = (CoreUser) o;

        if (userId != coreUser.userId) return false;
        if (name != null ? !name.equals(coreUser.name) : coreUser.name != null) return false;
        if (username != null ? !username.equals(coreUser.username) : coreUser.username != null) return false;
        if (phone != null ? !phone.equals(coreUser.phone) : coreUser.phone != null) return false;
        if (image != null ? !image.equals(coreUser.image) : coreUser.image != null) return false;
        if (state != null ? !state.equals(coreUser.state) : coreUser.state != null) return false;
        if (token != null ? !token.equals(coreUser.token) : coreUser.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
