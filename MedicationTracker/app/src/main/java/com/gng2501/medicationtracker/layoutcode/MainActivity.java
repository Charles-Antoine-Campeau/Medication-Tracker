package com.gng2501.medicationtracker.layoutcode;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gng2501.medicationtracker.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        Button btnAlarms = findViewById(R.id.btnAlarms);
        Button btnMedicationList = findViewById(R.id.btnMedicationList);
        Button btnSettings = findViewById(R.id.btnSettings);

        btnAlarms.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Alarms.class));
        });

        btnMedicationList.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MedicationList.class));
        });

        btnSettings.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Settings.class));
        });
    }


}
