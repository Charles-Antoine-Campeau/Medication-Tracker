package com.gng2501.medicationtracker.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Medication.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    /**
     * Expose the MedicationDAO
     * @return an instance of MedicationDAO
     */
    public abstract MedicationDAO medicationDAO();

    //Instance for singleton
    private static volatile AppDatabase INSTANCE;

    /**
     * get the singleton instance of AppDatabase
     * @param context
     * @return the instance
     */
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if(INSTANCE == null) {
                    //*****IMPORTANT*****
                    //Currently gets the data on main thread.  This could cause the app to freeze
                    //or stop working.  It could be run on background with the Executor defined over
                    //but I'm too lazy and not enough a programmer maniac ot care.  Although, I
                    // might change it if I have time or if the app crashes too often.
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "medication_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
