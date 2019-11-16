package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.TimeZoneFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.Constant;

public class CompareActivity extends AppCompatActivity implements View.OnClickListener {
    TextView kta1title, kta2title, skb1, skb2;
    TextView biayaproses1, biayaproses2, biayaadmin1, biayaadmin2;
    TextView biayaasuransi1, biayaasuransi2, biayaprovosi1, biayaprovosi2;
    TextView beamaterai1, beamaterai2, lunasAwal1, lunasAwal2;
    TextView keterlambatan1, keterlambatan2, minimumpendapatan1, minimumpendapatan2;
    TextView usiamin1, usiamin2, usiamax1, usiamax2, pendaftar1, pendaftar2;

    ImageView imageView2, imageView3;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        initView();
        setData1();
        setData2();

        btnBack.setOnClickListener(this);
    }

    private void initView(){
        btnBack = findViewById(R.id.button11);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        kta1title = findViewById(R.id.kta1Title);
        kta2title = findViewById(R.id.kta2Title);
        skb1 = findViewById(R.id.kta1skb);
        skb2 = findViewById(R.id.kta2skb);

        biayaproses1 = findViewById(R.id.biayaproses1);
        biayaproses2 = findViewById(R.id.biayaproses2);
        biayaadmin1 = findViewById(R.id.biayaadmin1);
        biayaadmin2 = findViewById(R.id.biayaadmin2);

        biayaasuransi1 = findViewById(R.id.biayaasuransi1);
        biayaasuransi2 = findViewById(R.id.biayaasuransi2);
        biayaprovosi1 = findViewById(R.id.biayaprovosi1);
        biayaprovosi2 = findViewById(R.id.biayaprovosi2);

        beamaterai1 = findViewById(R.id.beamaterai1);
        beamaterai2 = findViewById(R.id.beamaterai2);
        lunasAwal1 = findViewById(R.id.lunasAwal1);
        lunasAwal2 = findViewById(R.id.lunasAwal2);

        keterlambatan1 = findViewById(R.id.keterlambatan1);
        keterlambatan2 = findViewById(R.id.keterlambatan2);
        minimumpendapatan1 = findViewById(R.id.minimumpendapatan1);
        minimumpendapatan2 = findViewById(R.id.minimumpendapatan2);

        usiamin1 = findViewById(R.id.usiamin1);
        usiamin2 = findViewById(R.id.usiamin2);
        usiamax1 = findViewById(R.id.usiamax1);
        usiamax2 = findViewById(R.id.usiamax2);

        pendaftar1 = findViewById(R.id.pendaftar1);
        pendaftar2 = findViewById(R.id.pendaftar2);
    }

    public void setData1(){
        Kta data1 = getIntent().getParcelableExtra(Constant.Extra.DATA1);
        assert data1 != null;
        Glide.with(this)
                .load(data1.getIcon())
                .apply(new RequestOptions().override(30, 30))
                .into(imageView2);
        kta1title.setText(data1.getTitle());
        skb1.setText(data1.getSuku_bunga());
        biayaproses1.setText(data1.getBiaya_proses());
        biayaadmin1.setText(data1.getBiaya_admin());
        biayaasuransi1.setText(data1.getBiaya_asuransi());
        biayaprovosi1.setText(data1.getBiaya_provisi());

        beamaterai1.setText(data1.getBea_materai());
        lunasAwal1.setText(data1.getBiaya_pelunasan());
        keterlambatan1.setText(data1.getBiaya_keterlambatan());
        minimumpendapatan1.setText(String.valueOf(data1.getMinimum_pedapatan()));

        usiamin1.setText(String.valueOf(data1.getUsia_minimum()));
        usiamax1.setText(String.valueOf(data1.getUsia_maksimum()));
        pendaftar1.setText(data1.getPendaftar());
    }

    private void setData2(){
        Kta data2 = getIntent().getParcelableExtra(Constant.Extra.DATA);
        assert data2 != null;
        Glide.with(this)
                .load(data2.getIcon())
                .apply(new RequestOptions().override(30, 30))
                .into(imageView3);
        kta2title.setText(data2.getTitle());
        skb2.setText(data2.getSuku_bunga());
        biayaproses2.setText(data2.getBiaya_proses());
        biayaadmin2.setText(data2.getBiaya_admin());
        biayaasuransi2.setText(data2.getBiaya_asuransi());
        biayaprovosi2.setText(data2.getBiaya_provisi());

        beamaterai2.setText(data2.getBea_materai());
        lunasAwal2.setText(data2.getBiaya_pelunasan());
        keterlambatan2.setText(data2.getBiaya_keterlambatan());
        minimumpendapatan2.setText(String.valueOf(data2.getMinimum_pedapatan()));

        usiamin2.setText(String.valueOf(data2.getUsia_minimum()));
        usiamax2.setText(String.valueOf(data2.getUsia_maksimum()));
        pendaftar2.setText(data2.getPendaftar());
    }

    @Override
    public void onClick(View v) {
        Intent move = new Intent(CompareActivity.this, Kta2Activity.class);
        startActivity(move);
    }
}
