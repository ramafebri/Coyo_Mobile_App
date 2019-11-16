package com.example.coyomobileapp.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coyomobileapp.R;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnkeLogin, btnLangsungkeLogin, btnKembali;
    EditText email, pass, confirmPass;
    String user, password, confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        Firebase.setAndroidContext(this);
        initView();
        click();
    }

    public void initView(){
        email = findViewById(R.id.edtEmail);
        pass = findViewById(R.id.edtPass);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonKeLogin){
            if (validation()){
                String url = "https://coyomobileapp.firebaseio.com/users.json";

                StringRequest request = new StringRequest(Request.Method.GET, url, s -> {
                    Firebase reference = new Firebase("https://coyomobileapp.firebaseio.com/users");

                    if(s.equals("null")) {
                        reference.child(user).child("password").setValue(pass);
                        Toast.makeText(DaftarActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                        Intent move = new Intent(DaftarActivity.this, LoginActivity.class);
                        startActivity(move);
                    }
                    else {
                        try {
                            JSONObject obj = new JSONObject(s);

                            if (!obj.has(user)) {
                                reference.child(user).child("password").setValue(pass);
                                Toast.makeText(DaftarActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                Intent move = new Intent(DaftarActivity.this, LoginActivity.class);
                                startActivity(move);
                            } else {
                                Toast.makeText(DaftarActivity.this, "username already exists", Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, volleyError -> System.out.println("" + volleyError ));

                RequestQueue rQueue = Volley.newRequestQueue(DaftarActivity.this);
                rQueue.add(request);
            }

        }
        else if (v.getId() == R.id.buttonKeLogin1){
            Intent move = new Intent(DaftarActivity.this, LoginActivity.class);
            startActivity(move);
        }
        else if (v.getId() == R.id.buttonKembali){
            Intent move = new Intent(DaftarActivity.this,StartActivity.class);
            startActivity(move);
        }
    }

    private Boolean validation(){
        user = email.getText().toString();
        password = pass.getText().toString();
        confirmPassword = confirmPass.getText().toString();

        if(user.equals("")){
            email.setError("can't be blank");
            return false;
        }
        else if(password.equals("")){
            pass.setError("can't be blank");
            return false;
        }
        else if(user.length()<5){
            email.setError("at least 5 characters long");
            return false;
        }
        else if(password.length()<5){
            pass.setError("at least 5 characters long");
            return false;
        }
        else if (!confirmPassword.equals(password)){
            confirmPass.setError("Password konfirmasi harus sama");
            return false;
        }
        return true;
    }


}
