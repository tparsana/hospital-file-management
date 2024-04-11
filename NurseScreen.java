package com.example.hospitalsystem;

import javafx.application.Application;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.nio.file.*;
import java.io.*;

public class NurseScreen extends Application {
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient p){
        patient = p;
    }

    public Scene returnScene(Nurse nurse){

        // USERNAME VBOX///////////////////////////////
        VBox uservbox = new VBox();
        uservbox.setPadding(new Insets(20));
        uservbox.setSpacing(10);
        // Create a label
//        String fn = "Nurse";
//        String ln = "Something";
//        String month = "11";
//        String date = "04";
//        String year = "2004";
        Label username = new Label("USER NAME");
        Label firstname = new Label("First Name : " + nurse.getFirstName());
        Label lastname = new Label("Last Name : " + nurse.getLastName());
        Label dob = new Label(nurse.getDOB());
        Button logout = new Button("Logout");
        logout.setStyle("-fx-background-color: #C594D9; -fx-text-fill: white;"); // Set the button color

        uservbox.getChildren().addAll(username, firstname, lastname, dob, logout);
        /////////////////////////////////////////////////

        // Contact //////////////////////////////////////

        VBox contactvbox = new VBox();
        contactvbox.setPadding(new Insets(20));
        contactvbox.setSpacing(10);
        Label contactinfo = new Label("Contact Info");
//        String number = "9999999999";
        Label contact = new Label("Your number : " + nurse.getNumber());
        Label to = new Label("TO : ");
        TextField totf = new TextField();
        Label message = new Label("Message : ");
        TextField mtf = new TextField();
        Button send = new Button("Send");
        Label previous = new Label("Past Messages : ");
        TextArea pmta = new TextArea();
//        nurse.seeMessage(nurse.getFirstName(), nurse.getLastName(), pmta);
        contactvbox.getChildren().addAll( contactinfo, contact, to, totf, message, mtf, send, previous, pmta);
        /////////////////////////////////////////////////

        // Book Appointment //////////////////////////////////////

        VBox appoinmentvbox = new VBox();
        appoinmentvbox.setPadding(new Insets(20));
        appoinmentvbox.setSpacing(10);
        Label book = new Label("Book Appointment");
        Button appointment = new Button("Add/Edit Appointment");

        appoinmentvbox.getChildren().addAll(book, appointment);
        /////////////////////////////////////////////////

        // Left VBox ////////////////////////////////////

        VBox lvbox = new VBox();
        lvbox.setPadding(new Insets(10));
        lvbox.getChildren().addAll(uservbox, contactvbox, appoinmentvbox);
        /////////////////////////////////////////////////

        // Name Grid Pane ///////////////////////////////

        GridPane personalinfogp = new GridPane();
        personalinfogp.setVgap(10);
        personalinfogp.setPadding(new Insets(20));
        Label pfnlabel = new Label("First Name : ");
        Label plnlabel = new Label("Last Name : ");
        Label pdob = new Label("DOB : ");
        Label pcontactinfo = new Label("CONTACT NO : ");

        TextField pfntf = new TextField();
        TextField plntf = new TextField();
        DatePicker pdatePicker = new DatePicker();
        TextField pcontactinfotf = new TextField();

        personalinfogp.add(pfnlabel, 0, 0);
        personalinfogp.add(plnlabel, 0, 1);
        personalinfogp.add(pdob, 0, 2);
        personalinfogp.add(pcontactinfo, 0, 3);

        personalinfogp.add(pfntf, 1, 0);
        personalinfogp.add(plntf, 1, 1);
        personalinfogp.add(pdatePicker, 1, 2);
        personalinfogp.add(pcontactinfotf, 1, 3);
        /////////////////////////////////////////////////

        // Vitals Grid Pane /////////////////////////////

        GridPane vitalsgp = new GridPane();
        vitalsgp.setVgap(10);
        vitalsgp.setPadding(new Insets(20));

        Label page = new Label("Age : ");
        Label pheight = new Label("Height : ");
        Label pweight = new Label("Weight : ");
        Label pbp = new Label("Blood Pressure : ");
        Label ptemp = new Label("Temperature : ");

        TextField pagetf = new TextField();
        TextField pheighttf = new TextField();
        TextField pweighttf = new TextField();
        TextField pbptf = new TextField();
        TextField ptemptf = new TextField();

        vitalsgp.add(page, 0, 0);
        vitalsgp.add(pheight, 0, 1);
        vitalsgp.add(pweight, 0, 2);
        vitalsgp.add(pbp, 0, 3);
        vitalsgp.add(ptemp, 0, 4);

        vitalsgp.add(pagetf, 1, 0);
        vitalsgp.add(pheighttf, 1, 1);
        vitalsgp.add(pweighttf, 1, 2);
        vitalsgp.add(pbptf, 1, 3);
        vitalsgp.add(ptemptf, 1, 4);

        /////////////////////////////////////////////////

        // Allergy //////////////////////////////////////

        VBox allergyvb = new VBox();
        allergyvb.setSpacing(10);
        Label allergy = new Label("Allergy");
        TextField allergyList = new TextField();

        allergyvb.getChildren().addAll(allergy,allergyList);

        /////////////////////////////////////////////////

        // rvbox ////////////////////////////////////////

        VBox rvbox = new VBox();
        rvbox.setPadding(new Insets(20));
        rvbox.setSpacing(10);
        Button submitPatient = new Button("Submit");



        Button submit = new Button("Submit");

        HBox rhbox = new HBox();
        rhbox.getChildren().addAll(vitalsgp, allergyvb);
        rhbox.setSpacing(40);

        Label mainscreen = new Label("Main Screen");

        TextArea visitSummary = new TextArea("");

        submitPatient.setOnAction(e -> {
            setPatient(deserializeP(pfntf.getText()+plntf.getText()+pdatePicker.getValue().toString()+".ser"));
            if (patient!=null){
                        pcontactinfotf.setText(String.valueOf(patient.getContactNumber()));
                        visitSummary.setText(patient.getMedicalHistory());
                        allergyList.setText(patient.getAllergy());
                        if (patient.getVitals()!=null){
                            pagetf.setText(String.valueOf(patient.getVitals().getAge()));
                            pheighttf.setText(String.valueOf(patient.getVitals().getHeight()));
                            pweighttf.setText(String.valueOf(patient.getVitals().getHeight()));
                            pbptf.setText(String.valueOf(patient.getVitals().getBloodPressure()));
                            ptemptf.setText(String.valueOf(patient.getVitals().getBodyTemperature()));
                        }
                        if (patient.getVisitSummary()!=null){
                            String s = "Previous Visits:\n";
                            for (int j=0; j < patient.getVisitSummary().size(); j++){
                                s = s + patient.getVisitSummary().get(j).printSummary();
                                s = s + "\n";
                            }
                            visitSummary.setText(s);
                        }
            } else {
                setPatient(new Patient(pfntf.getText(), plntf.getText(), pdatePicker.getValue(), Integer.parseInt(pcontactinfotf.getText())));
                serializeP(patient);
            }
        });

        submit.setOnAction(e -> {
           if (patient!=null){
               patient.setVitals(new Vitals(Double.parseDouble(pweighttf.getText()), Double.parseDouble(pheighttf.getText()),
                       Double.parseDouble(ptemptf.getText()), Double.parseDouble(pbptf.getText()), Integer.parseInt(pagetf.getText())));
               patient.setAllergy(allergyList.getText());
               serializeP(patient);

           }
        });

        rvbox.getChildren().addAll(mainscreen, personalinfogp, submitPatient, rhbox, submit, visitSummary);

        /////////////////////////////////////////////////

        // mainhbox /////////////////////////////////////

        HBox mainhbox = new HBox();
        mainhbox.setStyle("-fx-background-color: #f0e3ff;"); // Set the background color

        mainhbox.getChildren().addAll(lvbox ,rvbox);




        Scene scene = new Scene(mainhbox, 320, 240);
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {

    }

    public void serializeP(Patient p){
        try (FileOutputStream fileOut = new FileOutputStream(p.getFirstName()+p.getLastName()+p.getDateOfBirth().toString()+".ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // Serialize the object
            out.writeObject(p);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        launch();
    }
}