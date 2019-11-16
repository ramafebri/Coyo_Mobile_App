package com.example.coyomobileapp.View.Fragment;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coyomobileapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment implements View.OnClickListener {
    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        CardView asuransi = rootView.findViewById(R.id.btn_chat_asuransi);
        CardView kredit = rootView.findViewById(R.id.btn_chat_kredit);

        asuransi.setOnClickListener(this);
        kredit.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_chat_asuransi){

        }else if (v.getId() == R.id.btn_chat_kredit){

        }
    }
}
