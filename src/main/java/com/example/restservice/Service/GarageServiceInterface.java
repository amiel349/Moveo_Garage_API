package com.example.restservice.Service;

import com.example.restservice.model.Vehicle;

import java.util.Collection;
import java.util.List;
/**
 *interface class for the service
 */

public interface GarageServiceInterface {
    void insertVehicle(Vehicle vehicle, int type);
    List<Vehicle> selectAllVehicles();
    Vehicle retrieveVehicleByLicense(long licenseNumber);
    void inflateVehicleTires(long licenseNumber);
    void addEnergy(long licenseNumber, int energy);
    void deleteVehicle(long licenseNumber );
    void deleteAllVehicles();
}
