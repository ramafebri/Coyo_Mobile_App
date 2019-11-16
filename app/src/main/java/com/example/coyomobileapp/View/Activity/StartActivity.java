package com.example.coyomobileapp.View.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStartBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_start);

    }
}
