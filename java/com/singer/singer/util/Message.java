package com.singer.singer.util;

public class Message {

    private String type;
    private String message;

    public Message(String type, String message){
        this.type = type;
        this.message = message;
    }

    // create getter for type and message
    public String getType(){
        return type;
    }

    public String getMessage(){
        return message;
    }
}