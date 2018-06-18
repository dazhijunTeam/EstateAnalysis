package com.dazhijunteam.estate.exception;

public class CommNullPointerException extends RuntimeException{
    String msg;

    public CommNullPointerException(String msg){
        this.msg=msg;
    }
}
