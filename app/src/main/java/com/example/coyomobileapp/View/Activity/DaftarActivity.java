package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.databinding.ActivityDaftarBinding;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnkeLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btnkeLogin = findViewById(R.id.buttonKeLogin);
        btnkeLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent move = new Intent(DaftarActivity.this, LoginActivity.class);
        startActivity(move);
    }
}
