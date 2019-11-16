package com.example.coyomobileapp.View.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.coyomobileapp.R;
import com.example.coyomobileapp.View.Fragment.ChatFragment;
import com.example.coyomobileapp.View.Fragment.HistoryFragment;
import com.example.coyomobileapp.View.Fragment.HomeFragment;
import com.example.coyomobileapp.View.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navView.setSelectedItemId(R.id.nav_home);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                Fragment fragment;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                                .commit();
                        return true;

                    case R.id.nav_chat:
                        Intent move = new Intent(MainActivity.this, DraftChatActivity.class);
                        startActivity(move);
                        return true;
                        case R.id.nav_history:
                        fragment = new HistoryFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                                .commit();
                        return true;

                        case R.id.nav_profile:
                        fragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                                .commit();
                        return true;
                }
                return false;
            };
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa kalian ingin Logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.signOut();
                    Intent login = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(login);
                    finish();
                })
                .setNegativeButton("No", null)
                .show();
    }

}
