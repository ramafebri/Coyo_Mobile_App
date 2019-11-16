package com.example.coyomobileapp.View.Interface;

import com.example.coyomobileapp.Model.Kta;

import java.util.List;

public interface HomeView {
    void successShowBarang(List<Kta> dataBarangs);
    void failedShowBarang(String message);
}
