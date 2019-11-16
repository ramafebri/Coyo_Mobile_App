package com.example.coyomobileapp.View.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.UserDetails;
import com.example.coyomobileapp.View.Activity.ChatActivity;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment implements View.OnClickListener {
    public static String KEY_ACTIVITY = "msg_activity";
    public static String KEY_ACTIVITY1 = "msg_activity1";

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
            assert getArguments() != null;
            UserDetails.chatWith = getArguments().getString(KEY_ACTIVITY);
            startActivity(new Intent(getContext(), ChatActivity.class));
        }
        else if (v.getId() == R.id.btn_chat_kredit){
            assert getArguments() != null;
            UserDetails.chatWith = getArguments().getString(KEY_ACTIVITY1);
            startActivity(new Intent(getContext(), ChatActivity.class));
        }
    }
}
