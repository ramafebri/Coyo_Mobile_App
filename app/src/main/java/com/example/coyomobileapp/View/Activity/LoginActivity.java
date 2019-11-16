package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.databinding.ActivityDaftarBinding;
import com.example.coyomobileapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnkeMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnkeMain = findViewById(R.id.buttonLogin);
        btnkeMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent move = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(move);
    }
}
