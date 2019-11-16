package com.example.coyomobileapp.View.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coyomobileapp.R;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnkeLogin, btnLangsungkeLogin, btnKembali;
    EditText emails, passs, confirmPass;
    String email, pass, konfirmasiPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        initView();
        Firebase.setAndroidContext(this);
        click();
    }

    public void initView(){
        emails = findViewById(R.id.edtEmail);
        passs = findViewById(R.id.edtPass);
        confirmPass = findViewById(R.id.edtConPass);
        btnLangsungkeLogin = findViewById(R.id.buttonKeLogin1);
        btnKembali = findViewById(R.id.buttonKembali);
        btnkeLogin = findViewById(R.id.buttonKeLogin);
    }

    public void click(){
        btnLangsungkeLogin.setOnClickListener(this);
        btnKembali.setOnClickListener(this);
        btnkeLogin.setOnClickListener(this);
    }
    private Boolean validation(){
        email = emails.getText().toString();
        pass = passs.getText().toString();
        konfirmasiPass = confirmPass.getText().toString();

        if(email.equals("")){
            emails.setError("can't be blank");
            return false;
        }
        else if(pass.equals("")){
            passs.setError("can't be blank");
            return false;
        }
        else if (!konfirmasiPass.equals(pass)){
            confirmPass.setError("Harus sama dengan password");
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.buttonKembali) {
            Intent move = new Intent(DaftarActivity.this, StartActivity.class);
            startActivity(move);
            finish();
        } else if (i == R.id.buttonKeLogin) {
            if (validation()){
                final ProgressDialog pd = new ProgressDialog(DaftarActivity.this);
                pd.setMessage("Loading...");
                pd.show();

                String url = "https://coyomobileapp.firebaseio.com/users.json";

                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        Firebase reference = new Firebase("https://coyomobileapp.firebaseio.com/users");

                        if(s.equals("null")) {
                            reference.child(email).child("password").setValue(pass);
                            Toast.makeText(DaftarActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                        }
                        else {
                            try {
                                JSONObject obj = new JSONObject(s);

                                if (!obj.has(email)) {
                                    reference.child(email).child("password").setValue(pass);
                                    Toast.makeText(DaftarActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(DaftarActivity.this, "username already exists", Toast.LENGTH_LONG).show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        pd.dismiss();
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        System.out.println("" + volleyError );
                        pd.dismiss();
                    }
                });
                RequestQueue rQueue = Volley.newRequestQueue(DaftarActivity.this);
                rQueue.add(request);
            }

        }
        else if (i == R.id.buttonKeLogin1){
            Intent move = new Intent(DaftarActivity.this, LoginActivity.class);
            startActivity(move);
            finish();
        }
    }
}
