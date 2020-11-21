package com.example.fastmenu.adapter.companyList;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class Company {

    private String image;
    private String text;

    public Company(){}

    public Company(String image, String text){
        this.image = image;
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
