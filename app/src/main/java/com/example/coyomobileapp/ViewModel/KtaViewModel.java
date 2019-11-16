package com.example.coyomobileapp.ViewModel;

import android.util.Log;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.Network.RetrofitClient;
import com.example.coyomobileapp.View.Interface.HomeView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KtaViewModel {
    private HomeView homeView;

    public KtaViewModel(HomeView homeView) {
        this.homeView = homeView;
    }

    public void getAllBarang(){
        final String tag = "Home-getBarang";
        RetrofitClient.getInstance()
                .getApi()
                .getBarang()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        if (response.isSuccessful()){
                            JsonObject body = response.body();
                            System.out.println(body);
                            assert body != null;
                            JsonArray array = body.get("data").getAsJsonArray();
                            Type type = new TypeToken<List<Kta>>(){}.getType();
                            List<Kta> dataBarangs = new Gson().fromJson(array   , type);
                            homeView.successShowBarang(dataBarangs);
                            assert response.body() != null;
                            Log.e(tag, response.body().toString());
                        } else {
                            homeView.failedShowBarang("Maaf terjadi kesalahan");
                            Log.e(tag, response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        homeView.failedShowBarang("Maaf terjadi kesalahan");
                        Log.d(tag, Objects.requireNonNull(t.getMessage()));
                    }
                });
    }
}
