package com.example.demo.fcm;

import com.example.demo.Entity.CoreUser;
import com.example.demo.Repository.UserRepo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mars on 8/19/2017.
 */

public class FcmNotificationSender {


    public void Send(String name) {
//                singleUser(name);
    }

    public void NewMessage(String[] users, Integer messageId) {
        singleUser(users, messageId);
    }

    private void singleUser(String[] users, Integer messageId) {
        try {
//            CoreNotificationsApps app = getInfoApp(notifiConfig);
//            FcmNotificationMessage fcmNotificationMessage = setFcmNotificationMessage(notifiConfig);
            JsonObject data = getData(messageId);
//            String[] listuserst = new String[]{"eBNNyExliRE:APA91bH6BA2ftoi-9_8vsysPY1Uh_IgxLrymiA5qACc-WZ3QMphPcA4v5CnckDY-sdUBzMJQVjkHP8eeZiPhbKsVv9TphnGhgTdSnnNx1pSJGPppJDLw4zrrpo-QHQ4GZAWAiIQh9pv4"};

            FcmNotification fcmNotification = new FcmNotification();
            fcmNotification.setTo(null);
            fcmNotification.setRegistration_ids(users);
//            fcmNotification.setNotification(fcmNotificationMessage);
            fcmNotification.setData(data);

            Gson gson = new Gson();
            String strJsonBody = gson.toJson(fcmNotification);

//            SendToServerFcm(strJsonBody, app.getAppTokenId());
            SendToServerFcm(strJsonBody, "AAAATPjlDu8:APA91bHjJ1NmFlXoofzLGMKVOclxYvUCdospNWr730-MMYg26_ZtysbV-0Y3LqiEz2Oyq4wj5ve_iDLQ9CGjcSCe0cjQGuLbWAjZtxll_-QDerPDLt-jA8yG57WTylqN8EZ5aTlBJi6j");

//            changeStatusNotification(notifiConfig);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    public JsonObject getData(Integer messageId) {
        JsonObject data = new JsonObject();
        data.addProperty("type", "con");
        data.addProperty("body", messageId);

        return data;
    }


    public void SendToServerFcm(String strJsonBody, String token) {
        URL url = null;
        try {
            String jsonResponse;

            url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("Authorization", "Key=" + token);
            con.setRequestMethod("POST");

            System.out.println("strJsonBody:\n"
                    + strJsonBody);

            byte[] sendBytes = strJsonBody.getBytes("UTF-8");
            con.setFixedLengthStreamingMode(sendBytes.length);

            OutputStream outputStream = con.getOutputStream();
            outputStream.write(sendBytes);

            int httpResponse = con.getResponseCode();
            System.out.println("httpResponse: " + httpResponse);

            if (httpResponse >= HttpURLConnection.HTTP_OK
                    && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                scanner.close();

                System.out.println("jsonResponse:\n" + jsonResponse);
            } else {
                if (con != null) {
                    System.out.println(con.getErrorStream());

                    Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                    jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                    scanner.close();

                    System.out.println("jsonResponse:\n" + jsonResponse);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
