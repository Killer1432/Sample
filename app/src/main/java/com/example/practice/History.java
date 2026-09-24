package com.example.practice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

public class History extends AppCompatActivity {

    TextView tvHistory;
    Button btnBacks, btnClearHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tvHistory = findViewById(R.id.tvHistory);
        btnBacks = findViewById(R.id.btnBacks);
        btnClearHistory = findViewById(R.id.btnClearHistory);

        btnBacks.setOnClickListener(v -> finish());

        // Clear history button
        btnClearHistory.setOnClickListener(v -> {
            CalculationHistory.clearHistory();
            displayHistory();
            Toast.makeText(this, "History cleared", Toast.LENGTH_SHORT).show();
        });

        displayHistory();
    }

    // Display history
    private void displayHistory() {

        // Get history list
        List<CalculationHistory.CalculationItem> list = CalculationHistory.getHistoryList();

        // Check if history is empty and if you clear history
        if (list.isEmpty()) {
            tvHistory.setText("No computation history available.");
            return;
        }

        // Build history string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            CalculationHistory.CalculationItem item = list.get(i);
            sb.append(String.format(
                    Locale.getDefault(),
                    "Computation #%d\n" +
                    "Prelim: %.2f | Midterm: %.2f\n" +
                    "Prefinal: %.2f | Final: %.2f\n" +
                    "Final Grade: %.2f\n" +
                    "Remark: %s\n" +
                    "-----------------------------------\n\n",
                    (i + 1),
                    item.getPrelim(),
                    item.getMidterm(),
                    item.getPrefinal(),
                    item.getFinalGrade(),
                    item.getAverage(),
                    item.getRemark()
            ));
        }

        // Display history
        tvHistory.setText(sb.toString().trim());
    }
}
