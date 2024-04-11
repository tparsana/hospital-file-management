package com.example.p;
import java.io.Serializable;


public class Visit_Summary implements  Serializable{
    private String date;
    private Vitals vitals;
    private String prescription;
    private String findings;

    public Visit_Summary(String date, Vitals vitals, String prescription, String findings){
        this.date = date;
        this.vitals = vitals;
        this.prescription = prescription;
        this.findings = findings;
    }

    public String printSummary() {
        String s = "Visit Summary: \n";

        s += "Date: " + date + "\n";
        s += "Vitals:{\n " + vitals.writeVitals() + "\n}\n";
        s += "Prescription: " + prescription + "\n";
        s += "Findings: " + findings + "\n";

        return s;
    }
}
