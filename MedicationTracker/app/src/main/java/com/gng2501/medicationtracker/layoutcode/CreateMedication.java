package com.gng2501.medicationtracker.layoutcode;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gng2501.medicationtracker.R;
import com.gng2501.medicationtracker.database.AppDatabase;
import com.gng2501.medicationtracker.database.Medication;
import com.gng2501.medicationtracker.database.MedicationDAO;

public class CreateMedication extends AppCompatActivity {

    //Layout elements
    EditText etxtMedName;
    EditText etxtDoses;
    EditText etxtWaitTime;
    EditText etxtPrescriptionSize;
    EditText etxtCurrentTotal;

    Button btnCancel;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_medication);

        //get the elements from the layout
        etxtMedName = findViewById(R.id.etxtMedName);
        etxtDoses = findViewById(R.id.etxtDoses);
        etxtWaitTime = findViewById(R.id.etxtWaitTime);
        etxtPrescriptionSize = findViewById(R.id.etxtPrescriptionSize);
        etxtCurrentTotal = findViewById(R.id.etxtCurrentTotal);

        btnCancel = findViewById(R.id.btnNewMedCancel);
        btnCreate = findViewById(R.id.btnCreateNewMed);

        btnCancel.setOnClickListener(view -> {
            //close the layout
            finish();
        });

        btnCreate.setOnClickListener(view -> {

            //determine if any of the field was left empty
            boolean hasError = false;
            if (TextUtils.isEmpty(etxtMedName.getText().toString())) {
                Toast.makeText(CreateMedication.this,"Medication name required",
                        Toast.LENGTH_SHORT).show();
                hasError = true;
            }
            else if (TextUtils.isEmpty(etxtDoses.getText().toString())) {
                Toast.makeText(CreateMedication.this, "Dose size required",
                        Toast.LENGTH_SHORT).show();
                hasError = true;
            }
            else if (TextUtils.isEmpty(etxtWaitTime.getText().toString())) {
                Toast.makeText(CreateMedication.this,
                        "Days between ordering and receiving new prescriptions required",
                        Toast.LENGTH_SHORT).show();
                hasError = true;
            }
            else if (TextUtils.isEmpty(etxtPrescriptionSize.getText().toString())) {
                Toast.makeText(CreateMedication.this,
                        "Quantity in a new prescription required",
                        Toast.LENGTH_SHORT).show();
                hasError = true;
            }
            else if (TextUtils.isEmpty(etxtCurrentTotal.getText().toString())) {
                Toast.makeText(CreateMedication.this, "Current Total required",
                        Toast.LENGTH_SHORT).show();
                hasError = true;
            }


            if (!hasError) {
                //get the database and the DAO
                AppDatabase appDatabase = AppDatabase.getDatabase(getApplicationContext());
                MedicationDAO medicationDAO = appDatabase.medicationDAO();

                //determine if there is already a medication with the same name
                Medication medicationCheck = medicationDAO.loadMedication(etxtMedName
                        .getText().toString());
                if (medicationCheck != null) {
                    Toast.makeText(CreateMedication.this,
                            "Medication already exist.  Please change name.", Toast.LENGTH_LONG)
                            .show();
                }
                else {
                    //create a medication object with the inputs from the edit text
                    Medication newMed = new Medication(
                            etxtMedName.getText().toString(),
                            Short.parseShort(etxtDoses.getText().toString()),
                            Short.parseShort(etxtWaitTime.getText().toString()),
                            Short.parseShort(etxtPrescriptionSize.getText().toString()),
                            Integer.parseInt(etxtCurrentTotal.getText().toString())
                    );

                    //add the medication to the database and close the page
                    medicationDAO.insertMedication(newMed);
                    Toast.makeText(CreateMedication.this, "Medication Created",
                            Toast.LENGTH_LONG).show();
                    finish();
                }

            }

        });
    }
}
