package com.example.sportspreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edName;
    RadioGroup rgSport;
    Button btnClear, btnNext, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        edName = findViewById(R.id.editName);
        rgSport = findViewById(R.id.rgSport);
        btnClear = findViewById(R.id.btnClear);
        btnNext = findViewById(R.id.btnNext);
        btnQuit = findViewById(R.id.btnQuit);

        btnClear.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnClear:
                clearWidgets();
                break;

            case R.id.btnQuit:
                quitApp();
                break;

            case R.id.btnNext:
                goToSecondActivity();
                break;
        }

    }

    private void goToSecondActivity() {
        String name = edName.getText().toString();
        int idSport = rgSport.getCheckedRadioButtonId();

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("sport", idSport);
        startActivity(intent);

    }

    private void quitApp() {
        System.exit(0);
    }

    private void clearWidgets() {

        edName.setText(null);
        rgSport.clearCheck();

    }
}