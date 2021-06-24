package com.example.firstproject;

public class Festival {
    int image;
    String name, origin;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Festival() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Festival(String name, String origin) {
        this.image = R.drawable.festivals_common;
        this.name = name;
        this.origin = origin;
    }

    public Festival(int image, String name, String origin) {
        this.image = image;
        this.name = name;
        this.origin = origin;
    }
}
