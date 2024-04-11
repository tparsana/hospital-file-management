package com.example.p;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.nio.file.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class HelloApplication extends Application {

    public void start(Stage primaryStage) {

        PatientList patientList = read();
        Label fnameLabel = new Label("First Name: ");
        Label lnameLabel = new Label("Last Name: ");
        Label dobLabel = new Label("Date of Birth: ");

        TextField fnameField = new TextField();
        TextField lnameField = new TextField();
        DatePicker dobPicker = new DatePicker();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.add(fnameLabel, 0, 0);
        gridPane.add(fnameField, 1, 0);
        gridPane.add(lnameLabel, 0, 1);
        gridPane.add(lnameField, 1, 1);
        gridPane.add(dobLabel, 0, 2);
        gridPane.add(dobPicker, 1, 2);

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #326fa8; -fx-text-fill: white;");
        loginButton.setPrefWidth(150);
        loginButton.setPrefHeight(50);
        loginButton.setOnAction(e -> {
            String firstName = fnameField.getText().trim();
            String lastName = lnameField.getText().trim();
            String DOB = dobPicker.getValue().toString();
            System.out.println(DOB);

            if (Files.exists(Paths.get("N"+firstName+lastName+DOB+".ser"))) {
                // If the file exists, deserialize it
                String filePath = "N"+firstName+lastName+DOB+".ser";

                try (FileInputStream fileIn = new FileInputStream(filePath);
                     ObjectInputStream in = new ObjectInputStream(fileIn)) {
                    // Read the serialized object
                    Object deserializedObject = in.readObject();

                    // Cast the deserialized object to the appropriate class
                    // In this example, assume it's MyClass
                    Nurse nurse = (Nurse) deserializedObject;
                    primaryStage.setScene((new NurseScreen()).returnScene(nurse));

                    // Now you can use the deserialized object as needed
                } catch (IOException | ClassNotFoundException er) {
                    er.printStackTrace();
                }
            }else if (Files.exists(Paths.get(firstName+lastName+DOB+".ser"))){
                String filePath = firstName+lastName+DOB+".ser";

                try (FileInputStream fileIn = new FileInputStream(filePath);
                     ObjectInputStream in = new ObjectInputStream(fileIn)) {
                    // Read the serialized object
                    Object deserializedObject = in.readObject();

                    // Cast the deserialized object to the appropriate class
                    // In this example, assume it's MyClass
                    Patient patient = (Patient) deserializedObject;
                    primaryStage.setScene((new PatientGui()).returnScene(firstName, lastName, DOB, patient));
//                    allergyField.setText(Patient.getAllergy());

                    // Now you can use the deserialized object as needed
                } catch (IOException | ClassNotFoundException er) {
                    er.printStackTrace();
                }
            }

        });

        VBox buttonsVBox = new VBox(10);
        buttonsVBox.setAlignment(Pos.CENTER);
        buttonsVBox.getChildren().addAll(loginButton);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridPane, buttonsVBox);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Heart Health System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public PatientList read(){
        PatientList patientList = null; // Initialize patientList

        // Check if the file exists

        if (Files.exists(Paths.get("patientdata.ser"))) {
            // If the file exists, deserialize it
            String filePath = "patientdata.ser";

            try (FileInputStream fileIn = new FileInputStream(filePath);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                // Read the serialized object
                Object deserializedObject = in.readObject();

                // Cast the deserialized object to the appropriate class
                // In this example, assume it's MyClass
                PatientList plist = (PatientList) deserializedObject;
                return plist;
                // Now you can use the deserialized object as needed
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            PatientList plist = new PatientList();

            try (FileOutputStream fileOut = new FileOutputStream("patientdata.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                // Serialize the object
                out.writeObject(plist);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return plist;
        }
        return null;
    }

    private boolean isValidPatient(String firstName, String lastName, PatientList plist) {
        return true;
    }

    private void openPatientView() {
        // Implement logic to open PatientView scene
        System.out.println("Opening PatientView...");
    }



    public static void main(String[] args) {
        Nurse ser = new Nurse("alexa", "goodfellow", "2024-01-13", "1234567890");
        try (FileOutputStream fileOut = new FileOutputStream("N"+ser.getFirstName()+ser.getLastName()+ser.getDOB()+".ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // Serialize the object
            out.writeObject(ser);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
