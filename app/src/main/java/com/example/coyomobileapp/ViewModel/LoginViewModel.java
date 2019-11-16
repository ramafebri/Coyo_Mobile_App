package com.example.coyomobileapp.ViewModel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.coyomobileapp.View.Activity.MainActivity;

public class LoginViewModel {

    private Context context;
    public LoginViewModel(){

    }
    public void onLoginClicked() {
        context.startActivity(MainActivity.fillDetail(context));

    }
}
