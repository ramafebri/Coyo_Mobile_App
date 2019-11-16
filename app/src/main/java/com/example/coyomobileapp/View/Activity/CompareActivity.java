package com.example.coyomobileapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;
import com.example.coyomobileapp.Utils.Constant;

public class CompareActivity extends AppCompatActivity {
    TextView kta1title, kta2title, skb1, skb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        kta1title = findViewById(R.id.kta1Title);
        kta2title = findViewById(R.id.kta2Title);
        skb1 = findViewById(R.id.kta1skb);
        skb2 = findViewById(R.id.kta2skb);

        Kta data1 = getIntent().getParcelableExtra(Constant.Extra.DATA1);
        assert data1 != null;
        kta1title.setText(data1.getTitle());
        skb1.setText(data1.getShort_desc());

        Kta data2 = getIntent().getParcelableExtra(Constant.Extra.DATA);
        kta2title.setText(data2.getTitle());
        skb2.setText(data2.getShort_desc());
    }
}
