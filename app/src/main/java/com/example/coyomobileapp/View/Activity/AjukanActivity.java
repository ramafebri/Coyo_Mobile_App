package com.example.coyomobileapp.View.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.View.Adapter.AjukanAdapter;
import com.example.coyomobileapp.View.Interface.AjukanView;
import com.example.coyomobileapp.ViewModel.AjukanViewModel;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class AjukanActivity extends AppCompatActivity implements View.OnClickListener, AjukanView {
    Button btnpengajuan, btnkembali;
    AjukanAdapter ajukanAdapter;
    AjukanViewModel ajukanViewModel;
    EditText etNama, etTempatLahir,etTelepon, etTanggalLahir, etDomisili, etAjuanKta, etJumlahPinjam, etPenghasilan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajukan);
        initView();
        initViewModel();
        initSlider();
        initView();


    }

    private void initView(){
        etNama = findViewById(R.id.nama_ajukan);
        etTelepon = findViewById(R.id.nomor_ajukan);
        etTempatLahir = findViewById(R.id.tempat_ajukan);
        etTanggalLahir = findViewById(R.id.ttl_ajukan);
        etDomisili = findViewById(R.id.kota_ajukan);
        etAjuanKta = findViewById(R.id.nama_ajukan);
        etJumlahPinjam = findViewById(R.id.jmlpinjaman_ajukan);
        etPenghasilan = findViewById(R.id.penghasilan_ajukan);

        btnkembali = findViewById(R.id.buttonBack);
        btnpengajuan = findViewById(R.id.buttonPengajuan);
        btnkembali.setOnClickListener(this);
        btnpengajuan.setOnClickListener(this);
    }

    private void initSlider(){
        SliderView sliderView = findViewById(R.id.sliderViewAjukan);
        AjukanAdapter adapter = new AjukanAdapter(this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

    private void initViewModel(){
        ajukanViewModel = new AjukanViewModel(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonBack:
                Intent move = new Intent(AjukanActivity.this, DetailActivity.class);
                startActivity(move);
                break;
            case R.id.buttonPengajuan:
                ajukanViewModel.addPeganjuan();
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    @Override
    public String getNamaNasabah() {
        return etNama.getText().toString();
    }

    @Override
    public String getTempatLahir() {
        return etTempatLahir.getText().toString();
    }

    @Override
    public String getTelepon() {
        return etTelepon.getText().toString();
    }

    @Override
    public String getTanggalLahir() {
        return etTanggalLahir.getText().toString();
    }

    @Override
    public String getDomisili() {
        return etDomisili.getText().toString();
    }

    @Override
    public String getAjuanKTA() {
        return etDomisili.getText().toString();
    }

    @Override
    public String getJumlahPinjaman() {
        return etJumlahPinjam.getText().toString();
    }

    @Override
    public String getJumlahPenghasilan() {
        return etPenghasilan.getText().toString();

    }

    @Override
    public void successAddPengajuan() {
        Toast.makeText(this, "Berhasil Menambahkan Data Barang", Toast.LENGTH_SHORT).show();
        Intent home = new Intent(AjukanActivity.this, MainActivity.class);
        startActivity(home);
        finish();

    }

    @Override
    public void failedAddPengajuan() {
        Toast.makeText(this, "Gagal input data, mohon coba lagi", Toast.LENGTH_SHORT).show();
    }
}
