package com.alan.pluginhost.google.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Referrer implements Parcelable {

    private String referrer;
    private String appInstallTime;
    private boolean googlePlayInstant;

    public Referrer(String referrer, String appInstallTime, boolean googlePlayInstant) {
        this.referrer = referrer;
        this.appInstallTime = appInstallTime;
        this.googlePlayInstant = googlePlayInstant;
    }

    protected Referrer(Parcel in) {
        referrer = in.readString();
        appInstallTime = in.readString();
        googlePlayInstant = in.readByte() != 0;
    }

    public static final Creator<Referrer> CREATOR = new Creator<Referrer>() {
        @Override
        public Referrer createFromParcel(Parcel in) {
            return new Referrer(in);
        }

        @Override
        public Referrer[] newArray(int size) {
            return new Referrer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(referrer);
        dest.writeString(appInstallTime);
        dest.writeByte((byte) (googlePlayInstant ? 1 : 0));
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getAppInstallTime() {
        return appInstallTime;
    }

    public void setAppInstallTime(String appInstallTime) {
        this.appInstallTime = appInstallTime;
    }

    public boolean isGooglePlayInstant() {
        return googlePlayInstant;
    }

    public void setGooglePlayInstant(boolean googlePlayInstant) {
        this.googlePlayInstant = googlePlayInstant;
    }

    @Override
    public String toString() {
        return "Referrer{" +
                "referrer='" + referrer + '\'' +
                ", appInstallTime='" + appInstallTime + '\'' +
                ", googlePlayInstant=" + googlePlayInstant +
                '}';
    }
}
