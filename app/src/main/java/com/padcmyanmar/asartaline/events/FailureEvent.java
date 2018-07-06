package com.padcmyanmar.asartaline.events;

public class FailureEvent {

    private String message;

    public String getMessage() {
        return message;
    }

    public FailureEvent(String message) {
        this.message = message;
    }
}
