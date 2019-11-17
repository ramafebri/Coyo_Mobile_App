package com.example.coyomobileapp.View.Interface;

import com.example.coyomobileapp.Model.Ajuan;

import java.util.List;

public interface HistoryView {

    String getNamaKTA();

    void successGetHistory(List<Ajuan> ajuanList);

    void failedGetHistory(String message);
}
