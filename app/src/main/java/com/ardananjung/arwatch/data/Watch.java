package com.ardananjung.arwatch.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "watch")
public class Watch {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @Expose
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "name")
    @Expose
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "price")
    @Expose
    @SerializedName("price")
    private String price;

    @ColumnInfo(name = "imgUrl")
    @Expose
    @SerializedName("imgUrl")
    private String imgUrl;

    @ColumnInfo(name = "desc")
    @Expose
    @SerializedName("desc")
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Watch(String name, String price, String imgUrl, String desc){
        this.name=name;
        this.price=price;
        this.imgUrl=imgUrl;
        this.desc=desc;
    }
}
