package com.example.coyomobileapp.Network;

import android.graphics.Movie;

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

    @GET("Food")
    Call<JsonObject> getBarangById(
            @Query("id") int id
    );

    @FormUrlEncoded
    @POST("pengajuan/add")
    Call<JSONObject> addPengajuan(
            @Field("nama") String nama,
            @Field("tempat_lahir") String tempatLahir,
            @Field("tanggal_lahir") String tglLahir,
            @Field("kota_domisili") String domisili,
            @Field("id_nasabah") Integer id_nasabah,
            @Field("ajuan_kta") String ajuanKta,
            @Field("jumlah_pinjaman") String jumlahPinjaman

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
