package com.example.demo.fcm;

import com.google.gson.JsonObject;

/**
 * Created by mars on 8/19/2017.
 */
public class FcmNotification {

    private String to;
    private JsonObject data;
//    private FcmNotificationMessage notification;
    private String[] registration_ids;

    public String[] getRegistration_ids() {
        return registration_ids;
    }

    public void setRegistration_ids(String[] registration_ids) {
        this.registration_ids = registration_ids;
    }

//    public FcmNotificationMessage getNotification() {
//        return notification;
//    }
//
//    public void setNotification(FcmNotificationMessage notification) {
//        this.notification = notification;
//    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }
}
