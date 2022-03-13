package com.example.restservice.model;

public class RegularMotorcycle extends Vehicle{

    public RegularMotorcycle(String modelName,
                             long licenseNumber,
                             int energyPercentage,
                             int tirePressure,
                             int maxTirePressure) {
        super(modelName, licenseNumber, energyPercentage, tirePressure, maxTirePressure);
        super.setEnergySource(EnergySource.FUEL);
        super.setType(Type.REGULAR_MOTORCYCLE);
        super.setNumOfWheels(2);
    }

    public Type getType() {
        return super.getType();
    }

    @Override
    public String getModelName() {
        return super.getModelName();
    }

    @Override
    public long getLicenseNumber() {
        return super.getLicenseNumber();
    }

    @Override
    public int getEnergyPercentage() {
        return super.getEnergyPercentage();
    }

    @Override
    public int getTirePressure() {
        return super.getTirePressure();
    }

    @Override
    public int getMaxTirePressure() {
        return super.getMaxTirePressure();
    }

    @Override
    public int getNumOfWheels() {
        return super.getNumOfWheels();
    }

    @Override
    public EnergySource getEnergySource() {
        return super.getEnergySource();
    }

    @Override
    public void inflateTires() {
        super.inflateTires();
    }

    @Override
    public void addEnergy(int energy) {
        super.addEnergy(energy);
    }
}
