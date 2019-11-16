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

    @SerializedName("pencairan")
    @Expose
    private String pencairan;

    @SerializedName("suku_bunga")
    @Expose
    private String suku_bunga;

    @SerializedName("biaya_proses")
    @Expose
    private String biaya_proses;

    @SerializedName("biaya_admin")
    @Expose
    private String biaya_admin;


    @SerializedName("biaya_asuransi")
    @Expose
    private String biaya_asuransi;

    @SerializedName("biaya_provisi")
    @Expose
    private String biaya_provisi;

    @SerializedName("bea_materai")
    @Expose
    private String bea_materai;

    @SerializedName("biaya_pelunasan")
    @Expose
    private String biaya_pelunasan;

    @SerializedName("biaya_keterlambatan")
    @Expose
    private String biaya_keterlambatan;

    @SerializedName("minimum_pedapatan")
    @Expose
    private float minimum_pedapatan;

    @SerializedName("usia_minimum")
    @Expose
    private int usia_minimum;

    @SerializedName("usia_maksimum")
    @Expose
    private int usia_maksimum;

    @SerializedName("pendaftar")
    @Expose
    private String pendaftar;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;


    protected Kta(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        icon = in.readString();
        short_desc = in.readString();
        pembiayaan = in.readString();
        tenor = in.readString();
        pencairan = in.readString();
        suku_bunga = in.readString();
        biaya_proses = in.readString();
        biaya_admin = in.readString();
        biaya_asuransi = in.readString();
        biaya_provisi = in.readString();
        bea_materai = in.readString();
        biaya_pelunasan = in.readString();
        biaya_keterlambatan = in.readString();
        minimum_pedapatan = in.readFloat();
        usia_minimum = in.readInt();
        usia_maksimum = in.readInt();
        pendaftar = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
        dest.writeString(icon);
        dest.writeString(short_desc);
        dest.writeString(pembiayaan);
        dest.writeString(tenor);
        dest.writeString(pencairan);
        dest.writeString(suku_bunga);
        dest.writeString(biaya_proses);
        dest.writeString(biaya_admin);
        dest.writeString(biaya_asuransi);
        dest.writeString(biaya_provisi);
        dest.writeString(bea_materai);
        dest.writeString(biaya_pelunasan);
        dest.writeString(biaya_keterlambatan);
        dest.writeFloat(minimum_pedapatan);
        dest.writeInt(usia_minimum);
        dest.writeInt(usia_maksimum);
        dest.writeString(pendaftar);
        dest.writeString(created_at);
        dest.writeString(updated_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Kta> CREATOR = new Creator<Kta>() {
        @Override
        public Kta createFromParcel(Parcel in) {
            return new Kta(in);
        }

        @Override
        public Kta[] newArray(int size) {
            return new Kta[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getPembiayaan() {
        return pembiayaan;
    }

    public void setPembiayaan(String pembiayaan) {
        this.pembiayaan = pembiayaan;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public String getPencairan() {
        return pencairan;
    }

    public void setPencairan(String pencairan) {
        this.pencairan = pencairan;
    }

    public String getSuku_bunga() {
        return suku_bunga;
    }

    public void setSuku_bunga(String suku_bunga) {
        this.suku_bunga = suku_bunga;
    }

    public String getBiaya_proses() {
        return biaya_proses;
    }

    public void setBiaya_proses(String biaya_proses) {
        this.biaya_proses = biaya_proses;
    }

    public String getBiaya_admin() {
        return biaya_admin;
    }

    public void setBiaya_admin(String biaya_admin) {
        this.biaya_admin = biaya_admin;
    }

    public String getBiaya_asuransi() {
        return biaya_asuransi;
    }

    public void setBiaya_asuransi(String biaya_asuransi) {
        this.biaya_asuransi = biaya_asuransi;
    }

    public String getBiaya_provisi() {
        return biaya_provisi;
    }

    public void setBiaya_provisi(String biaya_provisi) {
        this.biaya_provisi = biaya_provisi;
    }

    public String getBea_materai() {
        return bea_materai;
    }

    public void setBea_materai(String bea_materai) {
        this.bea_materai = bea_materai;
    }

    public String getBiaya_pelunasan() {
        return biaya_pelunasan;
    }

    public void setBiaya_pelunasan(String biaya_pelunasan) {
        this.biaya_pelunasan = biaya_pelunasan;
    }

    public String getBiaya_keterlambatan() {
        return biaya_keterlambatan;
    }

    public void setBiaya_keterlambatan(String biaya_keterlambatan) {
        this.biaya_keterlambatan = biaya_keterlambatan;
    }

    public float getMinimum_pedapatan() {
        return minimum_pedapatan;
    }

    public void setMinimum_pedapatan(float minimum_pedapatan) {
        this.minimum_pedapatan = minimum_pedapatan;
    }

    public int getUsia_minimum() {
        return usia_minimum;
    }

    public void setUsia_minimum(int usia_minimum) {
        this.usia_minimum = usia_minimum;
    }

    public int getUsia_maksimum() {
        return usia_maksimum;
    }

    public void setUsia_maksimum(int usia_maksimum) {
        this.usia_maksimum = usia_maksimum;
    }

    public String getPendaftar() {
        return pendaftar;
    }

    public void setPendaftar(String pendaftar) {
        this.pendaftar = pendaftar;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}










