package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.Constant;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvDetailTitle, tvDetailDesc;
    TextView tv1, tv2;
    Button btnBanding, btnAjukan;
    Kta dataBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        btnAjukan = findViewById(R.id.btnAjukan);
        btnBanding = findViewById(R.id.btnBanding);
        btnBanding.setOnClickListener(this);
        btnAjukan.setOnClickListener(this);
        tv1 = findViewById(R.id.tv11);
        tv2 = findViewById(R.id.tv2);
        dataBarang = getIntent().getParcelableExtra(Constant.Extra.DATA);
        assert dataBarang != null;
        tvDetailTitle.setText(dataBarang.getTitle());
        tv1.setText(dataBarang.getShort_desc());


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBanding){
            Intent move = new Intent(DetailActivity.this, Kta2Activity.class);
            move.putExtra(Constant.Extra.DATA, dataBarang);
            startActivity(move);
        }else if(v.getId() == R.id.btnAjukan) {
            Intent move = new Intent(DetailActivity.this, AjukanActivity.class);
            startActivity(move);
        }else if(v.getId() == R.id.tv2){
            tv2.setVisibility(View.GONE);
            tv1.setMaxLines(Integer.MAX_VALUE);
        }
    }

}
