package com.example.p;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

public class PatientList implements  Serializable{// File name for serialization
    private ArrayList<Patient> patients;

    public PatientList() {
        patients = new ArrayList<>();
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void deletePatient(String fname) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getFirstName().equals(fname)) {
                patients.remove(i);
                return;
            }
        }
    }

    // Method to check if a patient exists in the list
    public boolean isValidPatient(String firstName, String lastName, LocalDate dateOfBirth) {
        for (Patient patient : patients) {
            if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                    patient.getLastName().equalsIgnoreCase(lastName) &&
                    patient.getDateOfBirth().equals(dateOfBirth)) {
                return true; // Patient found
            }
        }
        return false; // Patient not found
    }

    // Serialize the patient list into the file


    // Deserialize the patient list from the file


    public Patient returnPatient(String firstName, String lastName, LocalDate dateOfBirth) {
        for (Patient patient : patients) {
            if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                    patient.getLastName().equalsIgnoreCase(lastName) &&
                    patient.getDateOfBirth().equals(dateOfBirth)) {
                return patient; // Patient found
            }
        }
        return null; //
    }
}
