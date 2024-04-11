package com.example.doctor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class doctor_screen extends Application {

    private Patient patient;
    private ArrayList<String> visit;
    private Vitals vital;

    public Scene returnScene(doctor_class doctor){
        VBox leftBox = new VBox();
        leftBox.setPadding(new Insets(10, 10, 10, 10));
        leftBox.setSpacing(20);

        VBox userNameBox = new VBox();
        userNameBox.setSpacing(10);
        Label username = new Label("Username");
        Label NAME = new Label("Dubey Ji");
        Label dobi = new Label("2024-04-09");
        Button loginLogoutButton = new Button("Logout");
//        loginLogoutButton.setOnAction(
//            event -> new HelloApplication()
//        );


        userNameBox.getChildren().addAll(username, loginLogoutButton);

        VBox contactInfoBox = new VBox();
        contactInfoBox.setSpacing(10);
//        Button contactPatientButton = new Button("Contact Patient:");
        Label contactPatient = new Label("Contact Patient:");
        Label number = new Label("1234567890");
        contactInfoBox.getChildren().addAll(contactPatient);

//        VBox bookAppointmentBox = new VBox();
//        bookAppointmentBox.setSpacing(10);
//        Button changeAppointmentButton = new Button("Change Appointment");
//        Button cancelAppointmentButton = new Button("Cancel Appointment");
//        bookAppointmentBox.getChildren().addAll(changeAppointmentButton, cancelAppointmentButton);

        leftBox.getChildren().addAll(userNameBox, contactInfoBox);

        // Create the center VBox for patient information and doctor notes
        VBox centerBox = new VBox();
        centerBox.setPadding(new Insets(10, 10, 10, 10));
        centerBox.setSpacing(20);

        GridPane details = new GridPane();
        Label fName = new Label("First Name: ");
        TextField FName = new TextField();
        Label lName = new Label("Last Name: ");
        TextField LName = new TextField();
        Label dob = new Label("DOB: ");
        DatePicker DOB = new DatePicker();
        Button search = new Button("Search");
        Label age = new Label("AGE: ");


        Label display_vitals = new Label();


        details.add(fName, 0 , 0);
        details.add(FName, 1,0);
        details.add(lName,0,1);
        details.add(LName,1,1);
        details.add(dob,0,2);
        details.add(DOB,1,2);
        details.add(search,0,3);

        search.setOnAction(
                e -> {

                    deserializeP(FName.getText() + LName.getText()+ DOB.getValue().toString() );
                    Patient P = deserializeP(FName.getText() + LName.getText()+ DOB.getValue().toString() );



                    display_vitals.setText("AGE:- " + patient.getVitals().getAge());
                    display_vitals.setText("HEIGHT:- " + patient.getVitals().getHeight());
                    display_vitals.setText("WEIGHT:- " + vital.getWeight());
                    display_vitals.setText("BLOOD PRESSURE:- " + vital.getBloodPressure());
                    display_vitals.setText("TEMPERATURE:- " + vital.getBodyTemperature());
                }
        );

        TextArea doctorNotesTextArea = new TextArea();
        doctorNotesTextArea.setPromptText("Enter Your Findings");
        doctorNotesTextArea.setMinHeight(150); // Set the minimum height for the TextArea

        Button submit_findings = new Button("Submit Findings");
        submit_findings.setOnAction(
                event -> {
                    String Findings = doctorNotesTextArea.getText();
                    doctor.enterFindings(Findings);
//                    visit.add(Findings);
                }
        );

        centerBox.getChildren().addAll(details, doctorNotesTextArea, submit_findings);
        // Add components for patient information and doctor notes here

        // Create the right-side VBox for the prescription view
        VBox rightBox = new VBox();
        rightBox.setPadding(new Insets(10, 10, 10, 10));
        rightBox.setSpacing(20);

        VBox prescriptionBox = new VBox();
        prescriptionBox.setSpacing(10);
//        ListView<String> prescriptionListView = new ListView<>();

        TextArea prescriptionArea = new TextArea();
        prescriptionArea.setPromptText("Prescriptions:");
        prescriptionArea.setMinHeight(300);

        Button prescription = new Button("Submit");
        prescription.setOnAction(
                event -> {
                    String Prescribed_data = prescriptionArea.getText();
                   doctor.Prescribe(Prescribed_data);
//                    patient.setPrescription(Prescribed_data);
                }
        );

        ListView<String> previousvisitView = new ListView<>();

//        previousvisitView.getItems().addAll(visit);

        prescriptionBox.getChildren().addAll(prescriptionArea,prescription, previousvisitView);

        previousvisitView.setMaxHeight(350);

        rightBox.getChildren().addAll(prescriptionBox);

        // Create the SplitPane and set the left, center, and right nodes
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(leftBox, centerBox, rightBox);
        splitPane.setDividerPositions(0.25, 0.75); // Set the initial divider positions



        // Create the scene and set it on the stage
        Scene scene = new Scene(splitPane, 800, 600);
        return scene;
    }

    public Patient deserializeP(String s){
        if (Files.exists(Paths.get(s))) {
            // If the file exists, deserialize it
            String filePath = s;

            try (FileInputStream fileIn = new FileInputStream(filePath);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                // Read the serialized object
                Object deserializedObject = in.readObject();

                // Cast the deserialized object to the appropriate class
                // In this example, assume it's MyClass
                Patient p = (Patient) deserializedObject;
                return p;

                // Now you can use the deserialized object as needed
            } catch (IOException | ClassNotFoundException er) {
                er.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public void start(Stage stage) throws IOException {

    }

    public static void main(String[] args) {
        launch(args);
    }
}

