package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
/**
 * This class represent a vehicle and its the main class of the model, all the classes extends this class
 * the class have the getters and setters for the properties and some basics methods like addEnergy or
 * inflate tires
 */

public class Vehicle {
    private final String modelName;
    private final long licenseNumber;
    private int energyPercentage;
    private final int maxTirePressure;
    private int tirePressure;
    private int numOfWheels;
    private  EnergySource energySource;
    private Type type;

    public Vehicle(@JsonProperty("modelName") String modelName,
                   @JsonProperty("licenseNumber") long licenseNumber,
                   @JsonProperty("energyPercentage") int energyPercentage,
                   @JsonProperty("tirePressure") int tirePressure,
                   @JsonProperty("maxTirePressure") int maxTirePressure){
        this.modelName = modelName;
        this.licenseNumber = licenseNumber;
        this.energyPercentage = energyPercentage;
        this.tirePressure = tirePressure;
        this.maxTirePressure = maxTirePressure;
        if (tirePressure > maxTirePressure){
            this.tirePressure = maxTirePressure;
        }
        if(energyPercentage>100)
            this.energyPercentage=100;
    }
    public void setEnergySource(EnergySource energySource) {
        this.energySource = energySource;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public void setNumOfWheels(int numOfWheels){
        this.numOfWheels=numOfWheels;
    }


    public String getModelName() {
        return modelName;
    }

    public long getLicenseNumber() {
        return licenseNumber;
    }

    public int getEnergyPercentage() {
        return energyPercentage;
    }

    public int getMaxTirePressure() {
        return maxTirePressure;
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public int getTirePressure() {
        return tirePressure;
    }

    public EnergySource getEnergySource() {
        return energySource;
    }
    public void inflateTires(){
        tirePressure=getMaxTirePressure();

    }
    public Type getType(){
        return type;
    }
    public void addEnergy(int energy){
        if(energy<0)
            return;
        this.energyPercentage  +=energy;
        if (this.energyPercentage > 100)
            this.energyPercentage = 100;
    }
}
