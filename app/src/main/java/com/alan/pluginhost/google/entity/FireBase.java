package com.alan.pluginhost.google.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class FireBase implements Parcelable {
    private String token;
    private String appInstanceId;

    public FireBase(String token, String appInstanceId) {
        this.token = token;
        this.appInstanceId = appInstanceId;
    }

    protected FireBase(Parcel in) {
        token = in.readString();
        appInstanceId = in.readString();
    }

    public static final Creator<FireBase> CREATOR = new Creator<FireBase>() {
        @Override
        public FireBase createFromParcel(Parcel in) {
            return new FireBase(in);
        }

        @Override
        public FireBase[] newArray(int size) {
            return new FireBase[size];
        }
    };

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppInstanceId() {
        return appInstanceId;
    }

    public void setAppInstanceId(String appInstanceId) {
        this.appInstanceId = appInstanceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(token);
        parcel.writeString(appInstanceId);
    }

    @Override
    public String toString() {
        return "FireBase{" +
                "token='" + token + '\'' +
                ", appInstanceId='" + appInstanceId + '\'' +
                '}';
    }
}
