package com.example.coyomobileapp.View.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.View.Activity.KtaActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    ImageButton imgKTA;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        imgKTA = rootView.findViewById(R.id.imagebtnKTA);

        imgKTA.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Intent move = new Intent(getContext(), KtaActivity.class);
        startActivity(move);
    }
}
