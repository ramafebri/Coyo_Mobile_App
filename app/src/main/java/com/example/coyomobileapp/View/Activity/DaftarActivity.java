package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.databinding.ActivityDaftarBinding;

public class DaftarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDaftarBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_daftar);
    }

    public static Intent fillDetail(Context context) {
        return new Intent(context, DaftarActivity.class);
    }
}
