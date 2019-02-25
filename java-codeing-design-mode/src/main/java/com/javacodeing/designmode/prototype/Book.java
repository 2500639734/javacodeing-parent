package com.javacodeing.designmode.prototype;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Book implements Cloneable {

    private String title;

    private ArrayList<String> imageList = new ArrayList<>();

    public void add (String image) {
        this.imageList.add(image);
    }

    public Book clone () throws CloneNotSupportedException {
        Book book = (Book) super.clone();
        return book;
    }

}
