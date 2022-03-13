package com.example.restservice.controller;

import com.example.restservice.model.Vehicle;
import com.example.restservice.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * This class is a controller for the Rest API
 * it has the basics operetions of POST, GET, PUT, and DELETE
 * @author Amiel Lejzor
 */

@RequestMapping("/api/1.0/vehicle")
@RestController
public class VehicleController {


    private final GarageService garageService;
    @Autowired
    public VehicleController(GarageService garageService){
        this.garageService = garageService;
    }
    @PostMapping (value = "{type}")
    public void addVehicle(@PathVariable("type") int type , @RequestBody Vehicle vehicle) {
        garageService.insertVehicle(vehicle, type);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles(){
        return garageService.selectAllVehicles();
    }

    @GetMapping(value = "{licenseNumber}")
    public Vehicle getVehicle(@PathVariable("licenseNumber") long licenseNumber) {
        return garageService.retrieveVehicleByLicense(licenseNumber);
    }

    @PutMapping(value = "{licenseNumber}")
    public void inflateTires(@PathVariable("licenseNumber") long licenseNumber){
        garageService.inflateVehicleTires(licenseNumber);
    }

    @PutMapping(value = "{licenseNumber}/{energy}")
    public void addEnergy(@PathVariable("licenseNumber") long licenseNumber, @PathVariable("energy") int percentage){
        garageService.addEnergy(licenseNumber, percentage);
    }
    @DeleteMapping(value ="{licenceNumber}")
    public void deleteVehicleByLicenceNumber(@PathVariable("licenceNumber") long licenseNumber){
        garageService.deleteVehicle(licenseNumber);


    }
    @DeleteMapping()
    public void deleteVehicleByLicenceNumber(){
        garageService.deleteAllVehicles();
    }
}
