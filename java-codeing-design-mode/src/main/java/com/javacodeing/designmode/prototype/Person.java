package com.javacodeing.designmode.prototype;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Person implements Cloneable {

    private int age;

    private ArrayList<String> childList = new ArrayList<>();

    public void add(String childName) {
        this.childList.add(childName);
    }

    public Person clone () throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.childList = (ArrayList<String>) this.childList.clone();
        return person;
    }

}
