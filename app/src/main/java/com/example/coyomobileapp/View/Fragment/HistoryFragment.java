package com.example.coyomobileapp.View.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coyomobileapp.Model.Ajuan;
import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.View.Activity.MainActivity;
import com.example.coyomobileapp.View.Adapter.HistoryAdapter;
import com.example.coyomobileapp.View.Interface.HistoryView;
import com.example.coyomobileapp.View.Interface.HomeView;
import com.example.coyomobileapp.ViewModel.HistoryViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment  {

    HistoryAdapter historyAdapter;
    RecyclerView recyclerView;
    HistoryViewModel historyViewModel;
//    HistoryView historyView;
    TextView tvNamaKTA;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = rootview.findViewById(R.id.rv_category);
        HistoryView historyView = new HistoryView() {
            @Override
            public String getNamaKTA() {
                return tvNamaKTA.getText().toString();
            }

            @Override
            public void successGetHistory(List<Ajuan> ajuanList) {
                historyAdapter = new HistoryAdapter(ajuanList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(historyAdapter);

            }

            @Override
            public void failedGetHistory(String message) {

            }
        };
        historyViewModel = new HistoryViewModel(historyView);
        historyViewModel.getAllHistory();
        tvNamaKTA = rootview.findViewById(R.id.tvHistory);

        return rootview;
    }

//    private void initViewModel(){
//        historyViewModel = new HistoryViewModel(getParentFragment);
//        historyViewModel.getAllHistory();
//    }

//
//    @Override
//    public String getNamaKTA() {
//        return tvNamaKTA.getText().toString();
//    }
//
//    @Override
//    public void successGetHistory(List<Ajuan> ajuanList) {
//        historyAdapter = new HistoryAdapter(ajuanList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(historyAdapter);
//    }
//
//    @Override
//    public void failedGetHistory(String message) {
//
//    }
}
