package com.book.book_web.entity;

public class Book {
    private String name;
    private int uid;
    public Book(){}
    public Book( int uid,String name){
        this.name = name;
        this.uid = uid;
    }
    public String getName(){return name;}
    public int getUid(){return uid;}
    public void setName(String name){this.name = name;}
    public void setUid(int uid){this.uid = uid;}
}
