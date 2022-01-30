package com.gng2501.medicationtracker.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MedicationDAO {

    @Insert
    void insertMedication(Medication medication);

    @Update
    void updateMedication(Medication medication);

    @Delete
    void deleteMedication(Medication medication);

    @Query("SELECT * FROM Medication")
    List<Medication> loadAllMedication();

    @Query("SELECT names FROM Medication")
    List<String> loadAllNames();

    @Query("SELECT * FROM Medication WHERE names LIKE :name")
    public Medication loadMedication(String name);
}
