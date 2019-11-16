package com.example.coyomobileapp.View.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.UserDetails;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DraftChatActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> al = new ArrayList<>();
    int totalUsers = 0;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draft_chat);

        CardView asuransi = findViewById(R.id.btn_chat_asuransi);
        CardView kredit = findViewById(R.id.btn_chat_kredit);

        asuransi.setOnClickListener(this);
        kredit.setOnClickListener(this);

        pd = new ProgressDialog(DraftChatActivity.this);
        pd.setMessage("Loading...");
        pd.show();

        String url = "https://chatapp-ed4df.firebaseio.com/users.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                doOnSuccess(s);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError);
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(DraftChatActivity.this);
        rQueue.add(request);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_chat_asuransi){
            UserDetails.chatWith = al.get(1);
            startActivity(new Intent(DraftChatActivity.this, ChatActivity.class));
        }
        else if (v.getId() == R.id.btn_chat_kredit){
            UserDetails.chatWith = al.get(3);
            startActivity(new Intent(DraftChatActivity.this, ChatActivity.class));
        }
    }

    public void doOnSuccess(String s) {
        try {
            JSONObject obj = new JSONObject(s);

            Iterator i = obj.keys();
            String key;

            while (i.hasNext()) {
                key = i.next().toString();

                if (!key.equals(UserDetails.username)) {
                    al.add(key);
                }

                totalUsers++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        pd.dismiss();
    }
}
