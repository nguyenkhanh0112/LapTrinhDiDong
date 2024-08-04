package com.example.quanlysach;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Author implements Parcelable {
     private String MaTG;
     private String TenTG;

    public Author(String maTG, String tenTG) {
        MaTG = maTG;
        TenTG = tenTG;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String maTG) {
        MaTG = maTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String tenTG) {
        TenTG = tenTG;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(MaTG);
        parcel.writeString(TenTG);
    }
    protected Author(Parcel in) {
        MaTG = in.readString();
        TenTG = in.readString();
    }
    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };
}
