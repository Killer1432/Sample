package com.example.practice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Seconds_activity extends AppCompatActivity {

    TextView tvResult, tvRemark;
    Button btnBacks, btnHistory;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);

        tvResult = findViewById(R.id.tvResult);
        tvRemark = findViewById(R.id.tvRemark);
        btnBacks = findViewById(R.id.btnBacks);
        btnHistory = findViewById(R.id.btnHistory);


        // Receive data from MainActivity
        double average = getIntent().getDoubleExtra("AVERAGE", 0);
        String remark = getIntent().getStringExtra("REMARK");

        // Display result
        tvResult.setText(
                String.format(
                        Locale.getDefault(),
                        "Final Grade: %.2f",
                        average
                )
        );

        tvRemark.setText("Remark: " + remark);

        // Back button
        btnBacks.setOnClickListener(v -> {
            finish();
        });
        // History button
        btnHistory.setOnClickListener(v -> {

            // Transfer result to HistoryActivity
            Intent intent = new Intent(
                    Seconds_activity.this,
                    History.class
            );

            // Pass data to HistoryActivity
            intent.putExtra("AVERAGE",
                    getIntent().getDoubleExtra("AVERAGE", 0));

            intent.putExtra("REMARK",
                    getIntent().getStringExtra("REMARK"));

            startActivity(intent);
        });

    }
}