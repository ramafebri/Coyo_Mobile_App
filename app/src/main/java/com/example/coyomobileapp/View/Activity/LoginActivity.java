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
import com.example.coyomobileapp.Utils.UserDetails;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnkeMain, btnRegis, btnBack;
    EditText edtLogin, edtPass;
    String email, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniView();
        click();
    }

    private void iniView(){
        edtLogin = findViewById(R.id.edtEmailLogin);
        edtPass = findViewById(R.id.edtPassLogin);
        btnRegis = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnKembali);
        btnkeMain = findViewById(R.id.buttonLogin);
    }

    private void click(){
        btnkeMain.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnRegis.setOnClickListener(this);
    }

    private Boolean validation(){
        email = edtLogin.getText().toString();
        pass = edtPass.getText().toString();

        if(email.equals("")){
            edtLogin.setError("can't be blank");
            return false;
        }
        else if(pass.equals("")){
            edtPass.setError("can't be blank");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonLogin) {
            if (validation()) {
                String url = "https://coyomobileapp.firebaseio.com/users.json";
                final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                pd.setMessage("Loading...");
                pd.show();

                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        if(s.equals("null")){
                            Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                        }
                        else{
                            try {
                                JSONObject obj = new JSONObject(s);

                                if(!obj.has(email)){
                                    Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                                }
                                else if(obj.getJSONObject(email).getString("password").equals(pass)){
                                    UserDetails.username = email;
                                    UserDetails.password = pass;
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
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
                        System.out.println("" + volleyError);
                        pd.dismiss();
                    }
                });
                RequestQueue rQueue = Volley.newRequestQueue(LoginActivity.this);
                rQueue.add(request);
            }
        }
        else if (v.getId() == R.id.btnKembali){
            Intent move = new Intent(LoginActivity.this, StartActivity.class);
            startActivity(move);
            finish();
        }
        else if (v.getId() == R.id.btnRegister){
            Intent move = new Intent(LoginActivity.this, DaftarActivity.class);
            startActivity(move);
            finish();
        }
    }
}
