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
    TextView tvDetailTitle, tvDetailDesc, tvSKB, tvPembiayaian;
    Button btnBanding, btnAjukan, btnBalik;
    Kta dataBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailDesc = findViewById(R.id.tv1);
        tvSKB = findViewById(R.id.tvDetailSkb);
        tvPembiayaian = findViewById(R.id.tvPembiayaan);

        btnAjukan = findViewById(R.id.btnAjukan);
        btnBanding = findViewById(R.id.btnBanding);
        btnBalik = findViewById(R.id.button14);
        btnBalik.setOnClickListener(this);
        btnBanding.setOnClickListener(this);
        btnAjukan.setOnClickListener(this);

        dataBarang = getIntent().getParcelableExtra(Constant.Extra.DATA);
        assert dataBarang != null;
        tvDetailTitle.setText(dataBarang.getTitle());
        tvDetailDesc.setText(dataBarang.getShort_desc());
        tvSKB.setText(dataBarang.getSuku_bunga());
        tvPembiayaian.setText(dataBarang.getPembiayaan());
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
        }else if (v.getId() == R.id.button14){
            Intent move = new Intent(DetailActivity.this, KtaActivity.class);
            startActivity(move);
        }
    }
}
