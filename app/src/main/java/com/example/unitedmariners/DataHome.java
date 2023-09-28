package com.example.unitedmariners;

import android.widget.ImageView;

public class DataHome {
    private int img;
    String nameData;
    String dataabout;

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

    public String getDataabout() {
        return dataabout;
    }

    public void setDataabout(String dataabout) {
        this.dataabout = dataabout;
    }

    public DataHome(int img, String nameData, String dataabout) {
        this.img = img;
        this.nameData = nameData;
        this.dataabout = dataabout;
    }
}
