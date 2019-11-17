package com.example.coyomobileapp.Network;

import android.graphics.Movie;

import com.example.coyomobileapp.Model.Ajuan;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @Headers("Content-Type: application/json")

    @GET("all")
    Call<JsonObject> getBarang();

    @GET("pengajuan/history")
    Call<JsonObject> getHistory();

    @GET("Food")
    Call<JsonObject> getBarangById(
            @Query("id") int id
    );

    @FormUrlEncoded
    @POST("pengajuan/add")
    Call<Ajuan> addPengajuan(
            @Field("nama") String nama,
            @Field("telepon") String telepon,
            @Field("tempat_lahir") String tempat_lahir,
            @Field("tanggal_lahir") String tanggal_lahir,
            @Field("kota_domisili") String kota_domisili,
            @Field("ajuan_kta") String ajuan_kta,
            @Field("penghasilan") String penghasilan,
            @Field("jumlah_pinjaman") String jumlah_pinjaman

    );

    @FormUrlEncoded
    @POST("Foods")
    Call<JSONObject> updateBarang(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("harga") String harga,
            @Field("stok") String stok
    );

    @FormUrlEncoded
    @POST("Foods")
    Call<JSONObject> deleteBarang(
            @Field("id") String id
    );
}
