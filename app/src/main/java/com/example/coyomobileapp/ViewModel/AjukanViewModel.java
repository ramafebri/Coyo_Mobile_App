package com.example.coyomobileapp.ViewModel;

import android.util.Log;

import com.example.coyomobileapp.Model.Ajuan;
import com.example.coyomobileapp.Network.RetrofitClient;
import com.example.coyomobileapp.View.Interface.AjukanView;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AjukanViewModel {
    public AjukanViewModel(AjukanView ajukanView) {
        this.ajukanView = ajukanView;
    }

    private AjukanView ajukanView;

     public void addPeganjuan(){
        final String tag = "Home-Ajuan";
        String nama = ajukanView.getNamaNasabah();
        String telepon = ajukanView.getTelepon();
        String tglLahir = ajukanView.getTanggalLahir();
        String kotaLahir = ajukanView.getTempatLahir();
        String domisili = ajukanView.getDomisili();
        String ajuanKTA = ajukanView.getAjuanKTA();
        String jumlahPenghasilan = ajukanView.getJumlahPenghasilan();
        String jumlahPinjaman = ajukanView.getJumlahPinjaman();


         RetrofitClient.getInstance()
                 .getApi()
                 .addPengajuan(nama,telepon,kotaLahir,tglLahir,domisili,ajuanKTA,jumlahPenghasilan,jumlahPinjaman)
                 .enqueue(new Callback<Ajuan>() {
                     @Override
                     public void onResponse(Call<Ajuan> call, Response<Ajuan> response) {
                         System.out.println(response);
                         System.out.println(call);
                         if(response.isSuccessful()){
                             ajukanView.successAddPengajuan();
                             Log.e(tag, response.body().toString());
                         } else {
                             ajukanView.failedAddPengajuan();
                             Log.e(tag, response.errorBody().toString());
                         }
                     }

                     @Override
                     public void onFailure(Call<Ajuan> call, Throwable t) {
                         ajukanView.failedAddPengajuan();
                         Log.e(tag, t.getMessage());
                     }
                 });

    }
}
