package com.example.coyomobileapp.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.Constant;
import com.example.coyomobileapp.View.Adapter.KtaAdapter1;
import com.example.coyomobileapp.View.Adapter.KtaListener;
import com.example.coyomobileapp.View.Interface.HomeView;
import com.example.coyomobileapp.ViewModel.KtaViewModel;

import java.util.List;

public class KtaActivity extends AppCompatActivity implements HomeView, KtaListener {
    KtaAdapter1 ktaAdapter1;
    RecyclerView recyclerView;
    KtaViewModel ktaViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kta);

        recyclerView = findViewById(R.id.rv_category);
        initViewModel();
    }

    @Override
    public void successShowBarang(List<Kta> dataBarangs) {
        ktaAdapter1 = new KtaAdapter1(dataBarangs);
        ktaAdapter1.setAdapterListener((KtaListener) this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ktaAdapter1);
    }

    @Override
    public void failedShowBarang(String message) {
        Toast.makeText(this, "Maaf terjadi kesalahan", Toast.LENGTH_SHORT).show();
    }

    private void initViewModel() {
        ktaViewModel = new KtaViewModel(this);
        ktaViewModel.getAllBarang();
    }

    @Override
    public void onBarangClick(Kta dataBarang) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Constant.Extra.DATA, dataBarang);
        startActivity(intent);
    }
}
