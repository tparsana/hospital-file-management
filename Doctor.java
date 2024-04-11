package com.example.p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Doctor implements Serializable {
    private String F_Name;
    private String L_Name;
    private String DOB;
    private String Number;

    //Constructor
    public Doctor(String firstname, String lastName, String DOB, String number)  {
        this.F_Name = firstname;
        this.L_Name = lastName;
        this.DOB = DOB;
        this.Number = number;
    }

    public String getFirstName() {
        return F_Name;
    }

    public String getLastName() {
        return L_Name;
    }

    public String getDOB(){ return DOB; }

    public String getNumber(){ return Number; }




    public void Prescribe(String prescription){
        String fileName = F_Name + L_Name + "_prescription.txt";


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(prescription);
            System.out.println("Prescription saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the prescription.");
            e.printStackTrace();
        }

    }

    public void send_message(String message, String filePath) {
        String fileName = F_Name + L_Name + "_message.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileName))) {
            writer.write(message);
            System.out.println("Message saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the message.");
            e.printStackTrace();
        }
    }

    public void enterFindings(String findings) {
        String fileName = F_Name +  L_Name + "_findings.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(findings);
            System.out.println("Findings saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the findings.");
            e.printStackTrace();
        }
    }

//    public void Send_Prescriptions(){
//
//    }

//    public void View_HealthHistory(){
//
//    }

    public void Call_Patient(){

    }

    public void SignUp_Login(){

    }

    public void ReplyPatient(){

    }

}
