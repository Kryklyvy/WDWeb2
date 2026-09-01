package com.example.demo;

import java.util.List;

public class UserData {

    private boolean attending;
    private List<String> attendees;

    private String messageName;
    private String loveMessage;

    public boolean isAttending() {
        return attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getLoveMessage() {
        return loveMessage;
    }

    public void setLoveMessage(String loveMessage) {
        this.loveMessage = loveMessage;
    }
}