package com.example.uiwidgetdemo.bean;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/4 10:03
 */
public class FruitBean {

    private String name;
    private int imgId;

    public FruitBean(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
