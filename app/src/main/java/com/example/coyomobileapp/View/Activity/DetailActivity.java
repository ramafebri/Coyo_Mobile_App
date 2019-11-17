package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.Constant;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvDetailTitle, getTvDetailTitle;
    TextView tv1, tv2;
    Button btnBanding, btnAjukan, btn14Back;
    ImageView imageView;
    Kta dataBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        btnAjukan = findViewById(R.id.btnAjukan);
        btn14Back = findViewById(R.id.button14Back);
        btnBanding = findViewById(R.id.btnBanding);
        imageView = findViewById(R.id.imageView33);

        btn14Back.setOnClickListener(this);
        btnBanding.setOnClickListener(this);
        btnAjukan.setOnClickListener(this);
        tv1 = findViewById(R.id.tv11);
        dataBarang = getIntent().getParcelableExtra(Constant.Extra.DATA);
        assert dataBarang != null;
        tvDetailTitle.setText(dataBarang.getTitle());
        tv1.setText(dataBarang.getShort_desc());

        Glide.with(this)
                .load(dataBarang.getIcon())
                .fitCenter()
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBanding){
            Intent move = new Intent(DetailActivity.this, Kta2Activity.class);
            move.putExtra(Constant.Extra.DATA, dataBarang);
            startActivity(move);
        }else if(v.getId() == R.id.btnAjukan) {
            Intent move = new Intent(DetailActivity.this, AjukanActivity.class);
            move.putExtra("title", dataBarang.getTitle());
            startActivity(move);
        }
        else if(v.getId() == R.id.button14Back){
            Intent move = new Intent(DetailActivity.this, KtaActivity.class);
            startActivity(move);
            finish();
        }
    }

}
