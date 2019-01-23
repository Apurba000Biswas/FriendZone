package com.example.apurba.friendzone;

public class DataModel {

    private String name;
    private int imgId;

    public DataModel(String name, int imgId){
        this.name = name;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }
}
