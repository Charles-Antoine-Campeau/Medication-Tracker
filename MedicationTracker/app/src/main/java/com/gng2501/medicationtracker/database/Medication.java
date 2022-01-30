package com.gng2501.medicationtracker.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Medication {

    //**********************************************************************************************
    //VARIABLES
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "names")
    private String name;

    @ColumnInfo(name = "doses")
    private short dose;

    @ColumnInfo(name = "waiting_time")
    private short waitingTimeBeforeNewStockDays;

    @ColumnInfo(name = "prescription_size")
    private short prescriptionSize;

    @ColumnInfo(name = "total_of_medication")
    private int totalOfMedication;
    //END OF VARIABLES
    //**********************************************************************************************

    //**********************************************************************************************
    //CONSTRUCTORS
    /**
     * Complete constructor for Medication
     * @param name name of Medication
     * @param dose preset quantity to be taken
     * @param waitingTimeBeforeNewStockDays necessary time before new order to pharmacy
     * @param prescriptionSize given quantity by pharmacy
     * @param totalOfMedication current total of Medication
     */
    public Medication(@NonNull String name, short dose, short waitingTimeBeforeNewStockDays,
                      short prescriptionSize, int totalOfMedication) {
        this.name = name;
        this.dose = dose;
        this.waitingTimeBeforeNewStockDays = waitingTimeBeforeNewStockDays;
        this.prescriptionSize = prescriptionSize;
        this.totalOfMedication = totalOfMedication;

    }
    //END OF CONSTRUCTORS
    //**********************************************************************************************

    //**********************************************************************************************
    //GETTERS
    public String getName() {return name;}
    public short getDose() {return dose;}
    public short getWaitingTimeBeforeNewStockDays() {return waitingTimeBeforeNewStockDays;}
    public short getPrescriptionSize() {return prescriptionSize;}
    public int getTotalOfMedication() {return totalOfMedication;}
    //END OF GETTERS
    //**********************************************************************************************

    //**********************************************************************************************
    //SETTERS
    public void setName(String name) {this.name = name;}
    public void setDose(short dose) {this.dose = dose;}
    public void setWaitingTimeBeforeNewStockDays(short waitingTimeBeforeNewStockDays) {
        this.waitingTimeBeforeNewStockDays = waitingTimeBeforeNewStockDays;
    }
    public void setPrescriptionSize(short prescriptionSize) {this.prescriptionSize = prescriptionSize;}
    public void setTotalOfMedication(int totalOfMedication) {this.totalOfMedication = totalOfMedication;}
    //END OF SETTERS
    //**********************************************************************************************

}
