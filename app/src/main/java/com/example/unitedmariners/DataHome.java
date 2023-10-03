package com.example.unitedmariners;

import android.widget.ImageView;

public class DataHome {
    private int img;
    String nameData;
    int dataabout;

    public int getDataabout() {
        return dataabout;
    }

    public void setDataabout(int dataabout) {
        this.dataabout = dataabout;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNameData() {
        return nameData;
    }

    public void setNameData(String nameData) {
        this.nameData = nameData;
    }

    public DataHome(int img, String nameData, int dataabout) {
        this.img = img;
        this.nameData = nameData;
        this.dataabout = dataabout;
    }
}
