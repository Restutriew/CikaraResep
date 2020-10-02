package com.cikarastudio.cikararesep.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelDataKategori implements Parcelable {
    String id;
    String nama;
    String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ModelDataKategori(String id, String nama, String icon) {
        this.id = id;
        this.nama = nama;
        this.icon = icon;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nama);
        dest.writeString(icon);
    }

    protected ModelDataKategori(Parcel in) {
        id = in.readString();
        nama = in.readString();
        icon = in.readString();
    }

    public static final Creator<ModelDataKategori> CREATOR = new Creator<ModelDataKategori>() {
        @Override
        public ModelDataKategori createFromParcel(Parcel in) {
            return new ModelDataKategori(in);
        }

        @Override
        public ModelDataKategori[] newArray(int size) {
            return new ModelDataKategori[size];
        }
    };
}
