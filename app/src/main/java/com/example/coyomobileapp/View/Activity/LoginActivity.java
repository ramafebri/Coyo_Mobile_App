package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.databinding.ActivityDaftarBinding;
import com.example.coyomobileapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    public static Intent fillDetail(Context context) {
        return new Intent(context, LoginActivity.class);
    }
}
