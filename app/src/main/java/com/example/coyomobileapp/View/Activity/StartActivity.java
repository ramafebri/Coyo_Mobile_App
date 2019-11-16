package com.example.coyomobileapp.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coyomobileapp.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn1 = findViewById(R.id.buttonMasuk);
        btn2 = findViewById(R.id.buttonRegis);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonMasuk){
            Intent move = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(move);
        }else if(v.getId() == R.id.buttonRegis) {
            Intent move = new Intent(StartActivity.this, DaftarActivity.class);
            startActivity(move);
        }
    }
}
