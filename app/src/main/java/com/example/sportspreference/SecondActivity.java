package com.example.sportspreference;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity implements View.OnClickListener {

    TextView tvName,tvSport;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.activity_second);
        initialized();
    }

    private void initialized() {

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        tvName = findViewById(R.id.lblName);
        tvSport = findViewById(R.id.lblSport);
        String name = getIntent().getStringExtra("name");
        String label1 = tvName.getText().toString();
        tvName.setText(label1 + name);


        int idSport = getIntent().getIntExtra("sport", -100);

        String sport = "No sport! you Gonna Die";

        switch (idSport) {

            case R.id.rbSoccer:
                sport = " Soccer";
                break;

            case R.id.rbHandball:
                sport = " Handball";
                break;

            case R.id.rbHockey:
                sport = "Hockey";
                break;

            }
        tvSport.append(sport);
        }


    @Override
    public void onClick(View v) {
        finish();
    }
}


