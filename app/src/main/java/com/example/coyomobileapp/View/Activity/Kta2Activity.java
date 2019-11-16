package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.Constant;
import com.example.coyomobileapp.View.Adapter.KtaAdapter1;
import com.example.coyomobileapp.View.Adapter.KtaAdapter2;
import com.example.coyomobileapp.View.Adapter.KtaListener;
import com.example.coyomobileapp.View.Interface.HomeView;
import com.example.coyomobileapp.ViewModel.KtaViewModel;

import java.util.List;

public class Kta2Activity extends AppCompatActivity implements HomeView, KtaListener {
    KtaAdapter2 ktaAdapter2;
    RecyclerView recyclerView;
    KtaViewModel ktaViewModel;
    Kta dataKta1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kta2);

        recyclerView = findViewById(R.id.rv_category2);
        dataKta1 = getIntent().getParcelableExtra(Constant.Extra.DATA);
        initViewModel();

    }

    @Override
    public void onBarangClick(Kta dataBarang) {
        Intent intent = new Intent(this, CompareActivity.class);
        intent.putExtra(Constant.Extra.DATA, dataBarang);
        intent.putExtra(Constant.Extra.DATA1, dataKta1);
        startActivity(intent);
    }

    private void initViewModel() {
        ktaViewModel = new KtaViewModel(this);
        ktaViewModel.getAllBarang();
    }

    @Override
    public void successShowBarang(List<Kta> dataBarangs) {
        ktaAdapter2 = new KtaAdapter2(dataBarangs);
        ktaAdapter2.setAdapterListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ktaAdapter2);
    }

    @Override
    public void failedShowBarang(String message) {
        Toast.makeText(this, "Maaf terjadi kesalahan", Toast.LENGTH_SHORT).show();
    }
}
