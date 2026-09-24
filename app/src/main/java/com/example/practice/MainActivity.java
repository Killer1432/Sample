package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etPrelim, etMidterm, etPrefinal, etFinal;

    Button btnCalculate, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etPrelim = findViewById(R.id.etPrelim);
        etMidterm = findViewById(R.id.etMidterm);
        etPrefinal = findViewById(R.id.etPrefinal);
        etFinal = findViewById(R.id.etFinal);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override

            // function to calculate grade
            public void onClick(View view) {
                // Get user input

                String prelimText = etPrelim.getText().toString();
                String midtermText = etMidterm.getText().toString();
                String prefinalText = etPrefinal.getText().toString();
                String finalText = etFinal.getText().toString();
                    // checkiong is the user is entering empty fields if she not inserts she said please enter all grades
                if (prelimText.isEmpty() ||
                        midtermText.isEmpty() ||
                        prefinalText.isEmpty() ||
                        finalText.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please enter all grades",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }
                // Convert input to double
                double prelim = Double.parseDouble(prelimText);
                double midterm = Double.parseDouble(midtermText);
                double prefinal = Double.parseDouble(prefinalText);
                double finalGrade = Double.parseDouble(finalText);

                // Calculate average
                double average =
                        (prelim * 0.20)  +
                                (midterm * 0.20)  +
                                (prefinal * 0.20)  +
                                (finalGrade * 0.40) ;
                // Check if average is valid
                // Determine remark
                String remark;

                if (average >= 75) {
                    remark = "PASSED";
                } else {
                    remark = "FAILED";
                }

                // Save computation to in-memory history
                CalculationHistory.addCalculation(
                        prelim, midterm, prefinal, finalGrade, average, remark
                );

                // Transfer result to SecondActivity
                Intent intent = new Intent(
                        MainActivity.this,
                        Seconds_activity.class
                );

                intent.putExtra("AVERAGE", average);
                intent.putExtra("REMARK", remark);

                startActivity(intent);
            }
        });
            // clear button
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etPrelim.setText("");
                etMidterm.setText("");
                etPrefinal.setText("");
                etFinal.setText("");
            }
        });
    }
}