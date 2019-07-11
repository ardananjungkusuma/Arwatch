package com.blogspot.ardananjungkusuma.arwatch.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Watch implements Parcelable {
    private String name,desc,detail,imageUrl;

    public Watch(String name,String desc,String imageUrl,String detail){
        this.name=name;
        this.desc=desc;
        this.imageUrl=imageUrl;
        this.detail=detail;
    }

    protected Watch(Parcel in) {
        name = in.readString();
        desc = in.readString();
        imageUrl = in.readString();
        detail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(imageUrl);
        dest.writeString(detail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Watch> CREATOR = new Creator<Watch>() {
        @Override
        public Watch createFromParcel(Parcel in) {
            return new Watch(in);
        }

        @Override
        public Watch[] newArray(int size) {
            return new Watch[size];
        }
    };

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }
    public  String getDetail(){
        return detail;
    }
    public void setDetail(String detail){
        this.detail=detail;
    }
}
