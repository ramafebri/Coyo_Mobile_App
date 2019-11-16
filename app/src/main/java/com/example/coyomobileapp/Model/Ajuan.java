package com.example.coyomobileapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ajuan implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("telepon")
    @Expose
    private String telepon;
    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("kota_domisili")
    @Expose
    private String kotaDomisili;
    @SerializedName("ajuan_kta")
    @Expose
    private String ajuanKta;
    @SerializedName("penghasilan")
    @Expose
    private String penghasilan;
    @SerializedName("jumlah_pinjaman")
    @Expose
    private String jumlahPinjaman;

    protected Ajuan(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nama = in.readString();
        telepon = in.readString();
        tempatLahir = in.readString();
        tanggalLahir = in.readString();
        kotaDomisili = in.readString();
        ajuanKta = in.readString();
        penghasilan = in.readString();
        jumlahPinjaman = in.readString();
    }

    public static final Creator<Ajuan> CREATOR = new Creator<Ajuan>() {
        @Override
        public Ajuan createFromParcel(Parcel in) {
            return new Ajuan(in);
        }

        @Override
        public Ajuan[] newArray(int size) {
            return new Ajuan[size];
        }
    };

    @Override
    public String toString() {
        return "Ajuan{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", telepon='" + telepon + '\'' +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                ", kotaDomisili='" + kotaDomisili + '\'' +
                ", ajuanKta='" + ajuanKta + '\'' +
                ", penghasilan='" + penghasilan + '\'' +
                ", jumlahPinjaman='" + jumlahPinjaman + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getKotaDomisili() {
        return kotaDomisili;
    }

    public void setKotaDomisili(String kotaDomisili) {
        this.kotaDomisili = kotaDomisili;
    }

    public String getAjuanKta() {
        return ajuanKta;
    }

    public void setAjuanKta(String ajuanKta) {
        this.ajuanKta = ajuanKta;
    }

    public String getPenghasilan() {
        return penghasilan;
    }

    public void setPenghasilan(String penghasilan) {
        this.penghasilan = penghasilan;
    }

    public String getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void setJumlahPinjaman(String jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(nama);
        parcel.writeString(telepon);
        parcel.writeString(tempatLahir);
        parcel.writeString(tanggalLahir);
        parcel.writeString(kotaDomisili);
        parcel.writeString(ajuanKta);
        parcel.writeString(penghasilan);
        parcel.writeString(jumlahPinjaman);
    }
}