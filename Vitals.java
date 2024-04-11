package com.example.p;
import java.io.Serializable;
public class Vitals implements  Serializable{
    private double weight;
    private double height;
    private double bodyTemperature;
    private double bloodPressure;
    private int age;

    // Constructor to initialize the vitals
    public Vitals(double weight, double height, double bodyTemperature, double bloodPressure, int age){
        this.weight = weight;
        this.height = height;
        this.bodyTemperature = bodyTemperature;
        this.bloodPressure = bloodPressure;
        this.age = age;
    }
    // Getters for each attribute
    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public int getAge(){return age;}
    public String writeVitals() {
        String x = "";

        x += "Age: " + getAge() + "" + "\n";
        x += "Weight: " + getWeight() + "\n";
        x += "Height: " + getHeight() + "\n";
        x += "Body Temperature: " + getBodyTemperature() + "\n";
        x += "Blood Pressure" + getBloodPressure() + "\n";

        return x;
    }
}