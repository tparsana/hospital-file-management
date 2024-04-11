//patient.java
package com.example.p;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;

public class Patient implements Serializable {
    // Variables
    private static String firstName;
    private static String lastName;
    private LocalDate dateOfBirth;
    private Vitals vitals;
    private int contactNumber;
    private ArrayList<Visit_Summary> visitSummary;
    private static String allergy;
    private String medicalHistory;
    private String pharmacy;
    private String prescription;

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, int contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters

    public static String getAllergy(){
        return allergy;
    }

    public void setAllergy(String s){
        allergy = s;
    }

    public static String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public ArrayList<Visit_Summary> getVisitSummary() {
        return visitSummary;
    }

    public void setVisitSummary(ArrayList<Visit_Summary> visitSummary) {
        this.visitSummary = visitSummary;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public void printVisit() {
        // Implementation for printing visit summary
    }

    public void sendMessage() {
        // Implementation for sending a message
    }
}
