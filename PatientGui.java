package com.example.p;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class PatientGui extends Application {
    public static Scene returnScene(String fn, String ln, String date, Patient patient){
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        VBox patientCase = new VBox();
        VBox.setVgrow(patientCase, Priority.ALWAYS);
        patientCase.setPadding(new Insets(10));
        patientCase.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        Label username = new Label(fn + ln);
        Label caseStatus = new Label("Case Status: Active");
        patientCase.getChildren().addAll(username, caseStatus);

        VBox contact = new VBox(5);
        contact.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        contact.setPadding(new Insets(10));
        Label contactInfo = new Label("Contact Info");
        Button contactNurse = new Button("Contact Nurse");
        String number = "1234567890";
        Label contactNumber = new Label("Your Number: ");
        TextField contactNumberField = new TextField(number);
        contactNumberField.setEditable(false);
        Button editInfo = new Button("Edit Contact Information");
        TextField numberField = new TextField();
        Button saveButton = new Button("Save");
        contact.getChildren().addAll(contactInfo, contactNumber, contactNumberField, editInfo, contactNurse);
        editInfo.setOnAction(actionEvent -> {
            contactNumberField.setEditable(true);
            contact.getChildren().add(saveButton);
            saveButton.setOnAction(actionEvent1 -> {
                contactNumberField.setEditable(false);
                contact.getChildren().remove(saveButton);
            });

        });

        GridPane main = new GridPane();
        main.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        main.setPadding(new Insets(10));
        main.setHgap(5);
        main.setVgap(5);
        Label vitals = new Label("Vitals: ");
        Label age = new Label("Age: ");
        TextField ageField = new TextField();
        ageField.setText(String.valueOf(patient.getVitals().getAge()));
        ageField.setEditable(false);
        Label height = new Label("Height: ");
        TextField heightField = new TextField();
        heightField.setText(String.valueOf(patient.getVitals().getHeight()));
        heightField.setEditable(false);
        Label weight = new Label("Weight: ");
        TextField weightField = new TextField();
        weightField.setText(String.valueOf(patient.getVitals().getWeight()));
        weightField.setEditable(false);
        Label bp = new Label("Blood Pressure: ");
        TextField bpField = new TextField();
        bpField.setText(String.valueOf(patient.getVitals().getBloodPressure()));
        bpField.setEditable(false);
        Label temp = new Label("Temperature: ");
        TextField tempField = new TextField();
        tempField.setText(String.valueOf(patient.getVitals().getBodyTemperature()));
        tempField.setEditable(false);
        Label medHis = new Label("Medical History: ");
        TextField medHisField = new TextField();
        medHisField.setEditable(false);
        main.add(vitals, 0, 0);
        main.add(age, 0, 1);
        main.add(ageField, 1, 1);
        main.add(height, 0, 2);
        main.add(heightField, 1, 2);
        main.add(weight, 0, 3);
        main.add(weightField, 1, 3);
        main.add(bp, 0, 4);
        main.add(bpField, 1, 4);
        main.add(temp, 0, 5);
        main.add(tempField, 1, 5);
        main.add(medHis, 2, 0);
        main.add(medHisField, 2,1);


        VBox records = new VBox();
        records.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        records.setPadding(new Insets(10));
        root.setRowSpan(records, 2);
        Label previous = new Label("Previous Records");
        records.getChildren().addAll(previous);

        root.add(patientCase, 0, 0);
        root.add(contact, 0, 1);
        root.add(main, 1, 0);
        root.add(records, 1, 1);
        Scene scene = new Scene(root, 800, 550);
        return scene;
    }
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        VBox patientCase = new VBox();
        VBox.setVgrow(patientCase, Priority.ALWAYS);
        patientCase.setPadding(new Insets(10));
        patientCase.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        Label username = new Label("John Doe");
        Label caseStatus = new Label("Case Status: ");
        TextField statusField = new TextField("Active");
        statusField.setEditable(false);
        patientCase.getChildren().addAll(username, caseStatus, statusField);

        VBox contact = new VBox(5);
        contact.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        contact.setPadding(new Insets(10));
        Label contactInfo = new Label("Contact Info");
        Button contactNurse = new Button("Contact Nurse");
        String number = "1234567890";
        Label contactNumber = new Label("Your Number: ");
        TextField contactNumberField = new TextField(number);
        contactNumberField.setEditable(false);
        Button editInfo = new Button("Edit Contact Information");
        TextField numberField = new TextField();
        Button saveButton = new Button("Save");
        contact.getChildren().addAll(contactInfo, contactNumber, contactNumberField, editInfo, contactNurse);
        editInfo.setOnAction(actionEvent -> {
                  contactNumberField.setEditable(true);
                  contact.getChildren().add(saveButton);
                  saveButton.setOnAction(actionEvent1 -> {
                  contactNumberField.setEditable(false);
                  contact.getChildren().remove(saveButton);
            });

        });

        GridPane main = new GridPane();
        main.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        main.setPadding(new Insets(10));
        main.setHgap(5);
        main.setVgap(5);
        Label vitals = new Label("Vitals: ");
        Label age = new Label("Age: ");
        TextField ageField = new TextField();
        ageField.setEditable(false);
        Label height = new Label("Height: ");
        TextField heightField = new TextField();
        heightField.setEditable(false);
        Label weight = new Label("Weight: ");
        TextField weightField = new TextField();
        weightField.setEditable(false);
        Label bp = new Label("Blood Pressure: ");
        TextField bpField = new TextField();
        bpField.setEditable(false);
        Label temp = new Label("Temperature: ");
        TextField tempField = new TextField();
        tempField.setEditable(false);
        Label allergy = new Label("Allergies: ");
        TextField allergyField = new TextField();
        allergyField.setEditable(false);
        Label medHis = new Label("Medical History: ");
        TextField medHisField = new TextField();
        medHisField.setEditable(false);
        main.add(vitals, 0, 0);
        main.add(age, 0, 1);
        main.add(ageField, 1, 1);
        main.add(height, 0, 2);
        main.add(heightField, 1, 2);
        main.add(weight, 0, 3);
        main.add(weightField, 1, 3);
        main.add(bp, 0, 4);
        main.add(bpField, 1, 4);
        main.add(temp, 0, 5);
        main.add(tempField, 1, 5);
        main.add(allergy, 0, 7);
        main.add(allergyField, 1, 7);
        main.add(medHis, 2, 0);
        main.add(medHisField, 2,1);


        VBox records = new VBox();
        records.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        records.setPadding(new Insets(10));
        root.setRowSpan(records, 2);
        Label previous = new Label("Previous Records");
        records.getChildren().addAll(previous);

        root.add(patientCase, 0, 0);
        root.add(contact, 0, 1);
        root.add(main, 1, 0);
        root.add(records, 1, 1);
        Scene scene = new Scene(root, 600, 440);
        stage.setTitle("Patient View");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}