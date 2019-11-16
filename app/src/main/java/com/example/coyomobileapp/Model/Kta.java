package com.example.coyomobileapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kta implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("short_description")
    @Expose
    private String short_desc;

    @SerializedName("pembiayaan")
    @Expose
    private String pembiayaan;

    @SerializedName("tenor")
    @Expose
    private String tenor;

    @SerializedName("short_description")
    @Expose
    private String short_desc;



