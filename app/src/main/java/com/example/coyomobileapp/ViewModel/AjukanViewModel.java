package com.example.coyomobileapp.ViewModel;

import android.util.Log;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.Network.RetrofitClient;
import com.example.coyomobileapp.View.Interface.AjukanView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AjukanViewModel {
    private AjukanView ajukanView;

     public void addPeganjuan(){
        final String tag = "Home-Ajukan";
        String nama = ajukanView.getNamaNasabah();
        String tglLahir = ajukanView.getTanggalLahir();
        String kotaLahir = ajukanView.getTanggalLahir();
        String domisili = ajukanView.getDomisili();
        Integer nasabahID = ajukanView.getNasabahID();
        String ajuanKTA = ajukanView.getAjuanKTA();
        String jumlahPinjaman = ajukanView.getJumlahPinjaman();

        RetrofitClient.getInstance()
                .getApi()
                .addPengajuan(nama,tglLahir,kotaLahir,domisili,nasabahID,ajuanKTA,jumlahPinjaman)
                .enqueue(new Callback<JSONObject>() {
                    @Override
                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                        if(response.isSuccessful()){
                            ajukanView.successAddPeganjuan();
                            Log.e(tag, response.body().toString());
                        } else {
                            ajukanView.failedAddPengajuan();
                            Log.e(tag, response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JSONObject> call, Throwable t) {
                        ajukanView.failedAddPengajuan();

                    }
                });

    }
}
