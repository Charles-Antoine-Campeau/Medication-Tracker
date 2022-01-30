package com.gng2501.medicationtracker.layoutcode;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gng2501.medicationtracker.R;

public class MedicationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medication_list);

        Button btnNewMedication = findViewById(R.id.btnAddNewMedication);

        btnNewMedication.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), CreateMedication.class));
        });
    }
}
