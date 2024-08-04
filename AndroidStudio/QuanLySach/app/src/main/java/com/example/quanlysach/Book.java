package com.example.quanlysach;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Book implements Parcelable {
    private String MaSach;
    private String TenSach;
    private String NgayXB;
    private String author_MaTG;

    public Book(String maSach, String tenSach, String ngayXB, String author_MaTG) {
        MaSach = maSach;
        TenSach = tenSach;
        NgayXB = ngayXB;
        this.author_MaTG = author_MaTG;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String maSach) {
        MaSach = maSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getNgayXB() {
        return NgayXB;
    }

    public void setNgayXB(String ngayXB) {
        NgayXB = ngayXB;
    }

    public String getAuthor_MaTG() {
        return author_MaTG;
    }

    public void setAuthor_MaTG(String author_MaTG) {
        this.author_MaTG = author_MaTG;
    }

    protected Book(Parcel in) {
        MaSach = in.readString();
        TenSach = in.readString();
        NgayXB = in.readString();
        author_MaTG = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(MaSach);
        parcel.writeString(TenSach);
        parcel.writeString(NgayXB);
        parcel.writeString(author_MaTG);
    }
}
