package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/21 19:40
 * @description: 线程共享数据
 */
public class Person {

    private String name;

    private String sex;

    private boolean onlyRead = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isOnlyRead() {
        return onlyRead;
    }

    public void setOnlyRead(boolean onlyRead) {
        this.onlyRead = onlyRead;
    }
}
