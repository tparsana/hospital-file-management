package com.example.p;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.Serializable;

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
//    public void messagePatient(String pfn, String lfn, String message){
//        String checkerfilename = pfn+lfn+"_Messages.txt";
//        File filename = new File(checkerfilename);
//        if(!filename.exists()){
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Error");
//            alert.setHeaderText("Such patient doesn't exist");
//            alert.setContentText("Check patient First Name and Last Name");
//            alert.showAndWait();
//            return;
//        }
//
//        try {
//            FileWriter writer = new FileWriter(filename);
//            writer.write("\n ");
//            writer.write("nurse : " + message +" \n");
//            writer.close();
//        }
//        catch (IOException er){
//            System.out.println("An error has occurred.");
//        }
//    }
//
    public void callPatient(Patient p){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(String.valueOf(p.getContactNumber()));
        alert.setHeaderText("This is the number of Patient");
        alert.showAndWait();
    }
//
//    public void seeMessage(String pfn, String lfn, TextArea ta){
//        String checkerfilename = pfn+lfn+"_Messages.txt";
//        File filename = new File(checkerfilename);
//        if(!filename.exists()){
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Error");
//            alert.setHeaderText("Such patient doesn't exist");
//            alert.setContentText("Check patient First Name and Last Name");
//            alert.showAndWait();
//            return;
//        }
//        try {
//            // Read the content of the file into a String
//            String content = Files.readString(Paths.get(checkerfilename));
//            // Display the content
//            ta.setText(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }




}
