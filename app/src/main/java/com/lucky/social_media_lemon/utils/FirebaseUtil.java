package com.lucky.social_media_lemon.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtil {

    public static String currentUserId(){

        return FirebaseAuth.getInstance().getUid();
    }

    public static boolean isLoggedIn(){
        if (currentUserId()!=null){
            return true;
        }
        return false;
    }

    public static DocumentReference currentUserDetails(){
        return FirebaseFirestore.getInstance().collection("users").document(currentUserId());
    }

    public static CollectionReference allUserCollectionReference(){
        return FirebaseFirestore.getInstance().collection("users");
    }

    public static DocumentReference getChatRoomReference(String chatRoomId){
        return FirebaseFirestore.getInstance().collection("chatrooms").document(chatRoomId);
    }

    // Tham chiếu Collection posts chứa tất cả bài đăng
    public static CollectionReference allPostCollectionReference(String chatroomId){
        return FirebaseFirestore.getInstance().collection("posts");
    }

    // Tham chiếu Collection chats chứa các đoạn chat trong phòng chat
    public static CollectionReference getChatroomMessageReference(String chatroomId){
        return getChatRoomReference(chatroomId).collection("chats");
    }

    public static String getChatroomId(String userId1, String userId2){
        if (userId1.hashCode()<userId2.hashCode()){
            return userId1+"_"+userId2;
        } else {
            return userId2+"_"+userId1;
        }
    }



}
