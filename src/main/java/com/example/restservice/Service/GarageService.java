package com.example.restservice.Service;

import com.example.restservice.exceptions.ApiRequestExceptions;
import com.example.restservice.model.*;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class GarageService implements GarageServiceInterface {
    private static HashMap<Long,Vehicle> vehicleCollection=new HashMap<>();


    @Override
    public void insertVehicle(Vehicle vehicle, int type) {
        if(vehicleCollection.containsKey(vehicle.getLicenseNumber()))
            throw  new ApiRequestExceptions("This vehicle is already in the collection");
        switch (type){
            case 0:
                vehicleCollection.put(vehicle.getLicenseNumber(),
                              new RegularMotorcycle(vehicle.getModelName(),
                                vehicle.getLicenseNumber(),
                                vehicle.getEnergyPercentage(),
                                vehicle.getTirePressure(),
                                vehicle.getMaxTirePressure()));
                break;
            case 1:
                vehicleCollection.put(vehicle.getLicenseNumber(),
                                new ElectricMotorcycle(vehicle.getModelName(),
                                vehicle.getLicenseNumber(),
                                vehicle.getEnergyPercentage(),
                                vehicle.getTirePressure(),
                                vehicle.getMaxTirePressure()));
                break;
            case 2:
                vehicleCollection.put(vehicle.getLicenseNumber(),
                                new RegularCar(vehicle.getModelName(),
                                vehicle.getLicenseNumber(),
                                vehicle.getEnergyPercentage(),
                                vehicle.getTirePressure(),
                                vehicle.getMaxTirePressure()));
                break;
            case 3:
                vehicleCollection.put(vehicle.getLicenseNumber(),
                                new ElectricCar(vehicle.getModelName(),
                                vehicle.getLicenseNumber(),
                                vehicle.getEnergyPercentage(),
                                vehicle.getTirePressure(),
                                vehicle.getMaxTirePressure()));
                break;
            case 4:
                vehicleCollection.put(vehicle.getLicenseNumber(),
                                new Truck(vehicle.getModelName(),
                                vehicle.getLicenseNumber(),
                                vehicle.getEnergyPercentage(),
                                vehicle.getTirePressure(),
                                vehicle.getMaxTirePressure()));
                break;
            default:
                return;
        }

    }

    @Override
    public List<Vehicle> selectAllVehicles() {
        return new ArrayList( vehicleCollection.values());
    }

    @Override
    public Vehicle retrieveVehicleByLicense(long licenseNumber) {
        if(!vehicleCollection.containsKey(licenseNumber))
            throw new ApiRequestExceptions("This vehicle doesn't exist in the collection ");
        return vehicleCollection.get(licenseNumber);
    }

    @Override
    public void inflateVehicleTires(long licenseNumber) {
        if(!vehicleCollection.containsKey(licenseNumber))
            throw new ApiRequestExceptions("This vehicle doesn't exist in the collection ");
        retrieveVehicleByLicense(licenseNumber).inflateTires();
    }

    @Override
    public void addEnergy(long licenseNumber, int energy) {
        if(!vehicleCollection.containsKey(licenseNumber))
            throw new ApiRequestExceptions("This vehicle doesnt exist in the collection ");
        retrieveVehicleByLicense(licenseNumber).addEnergy(energy);

    }

    @Override
    public void deleteVehicle(long licenseNumber) {
        if(!vehicleCollection.containsKey(licenseNumber))
            throw new ApiRequestExceptions("This vehicle doesnt exist in the collection ");
        vehicleCollection.remove(licenseNumber);

    }

    @Override
    public void deleteAllVehicles() {
        vehicleCollection.clear();

    }
}
