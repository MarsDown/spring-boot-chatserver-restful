# ChatServer


This project is an online chat server built using spring boot.
All requests in this project are transferred to the restfull bed.
In this project, Firebase Cloud Messaging (FCM) has been used to inform new changes, such as "Receive New Messages."
In this way, by registering each new message on the server by the FCM, a notification is sent to the rest of the clients and informs them of the new changes.

Spring data jpa is used to access the database.


android client project :https://github.com/MarsDown/chat-client-android-restful


