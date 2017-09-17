package com.leo.eventbus.sample;

/**
 * Created by Leo on 2017/9/17.
 */

public class ReadBookEvent {

    private String book;

    ReadBookEvent(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }
}
