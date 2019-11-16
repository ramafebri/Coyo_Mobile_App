package com.example.coyomobileapp.ViewModel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.coyomobileapp.View.Activity.DaftarActivity;
import com.example.coyomobileapp.View.Activity.LoginActivity;

public class StartActivityVM extends BaseObservable {
    private Context context;
    public StartActivityVM(){

    }
    public void onLoginClicked() {
        context.startActivity(LoginActivity.fillDetail(context));

    }

    public void onRegisClicked(){
        context.startActivity(DaftarActivity.fillDetail(context));

    }
}
