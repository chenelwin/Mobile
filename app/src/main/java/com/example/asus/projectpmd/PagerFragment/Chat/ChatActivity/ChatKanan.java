package com.example.asus.projectpmd.PagerFragment.Chat.ChatActivity;

/**
 * Created by Asus on 2018-01-08.
 */

public class ChatKanan {
    private String time;
    private String text;
    private String read;

    public ChatKanan(String text, String time, String read){
        this.text = text;
        this.time = time;
        this.read = read;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
}
