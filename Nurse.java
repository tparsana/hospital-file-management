package com.example.hospitalsystem;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import java.io.*;

public class Nurse implements Serializable{

    private String firstName;
    private String lastName;
    private String DOB;
    private String number;

    public Nurse(String firstname, String lastname, String dob, String number){
        this.firstName = firstname;
        this.lastName = lastname;
        this.DOB = dob;
        this.number = number;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getDOB(){
        return DOB;
    }

    public String getNumber(){
        return number;
    }

//
//    public void Record_Vitals(Patient p, Vitals v){
//        p.vital = v;
//    }
//
//    public void Record_HealthHistory(Patient p, String s){
//        p.medicalHistory.add(s);
//    }
//
    public void messagePatient(String pfn, String lfn, String message){
        String filePath = pfn+lfn+"_Messages.txt";
        // Create a Path object
        Path path = Paths.get(filePath);

        // Check if the file exists
        if (!Files.exists(path)) {
            try {
                // Create the file
                Files.createFile(path);
                System.out.println("File created successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists.");
        }

        // Define the path to the file

        // Write the string to the file
        message = "\nNurse : " + message + "\n";
        try {
            Path pathp = Paths.get(filePath);
            Files.writeString(pathp, message);
            System.out.println("String written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = firstName+lastName+"_Messages.txt";
        // Create a Path object
        path = Paths.get(filePath);

        // Check if the file exists
        if (!Files.exists(path)) {
            try {
                // Create the file
                Files.createFile(path);
                System.out.println("File created successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists.");
        }

        // Define the path to the file

        // Write the string to the file
        message = "\nNurse : " + message + "\n";
        try {
            Path pathp = Paths.get(filePath);
            Files.writeString(pathp, message);
            System.out.println("String written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//
    public void callPatient(Patient p){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(String.valueOf(p.getContactNumber()));
        alert.setHeaderText("This is the number of Patient");
        alert.showAndWait();
    }
//
    public void seeMessage(TextArea ta){
        String filePath = firstName+lastName+"_Messages.txt";
                // Create a Path object
        Path path = Paths.get(filePath);

                // Check if the file exists
        if (!Files.exists(path)) {
            try {
                // Create the file
                Files.createFile(path);
                System.out.println("File created successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists.");
        }

        // Read the content of the file into a String variable
        String content = "";
        try {
            content = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ta.setText(content);

    }
}

