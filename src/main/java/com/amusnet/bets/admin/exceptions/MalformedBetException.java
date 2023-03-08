package com.amusnet.bets.admin.exceptions;

public class MalformedBetException extends Exception{
    public MalformedBetException(String message, String id) {
        super(message + " [ID: " + id + "]");
    }
}
