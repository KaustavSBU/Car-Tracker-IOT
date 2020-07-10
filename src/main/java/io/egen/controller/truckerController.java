package io.egen.controller;

import io.egen.entity.alertDetailsByVehicle;
import io.egen.entity.tirePressure;
import io.egen.entity.vehicleDetails;
import io.egen.entity.vehicleReadings;
import io.egen.service.truckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kaustav Sarkar
 *	Date : 07/01/2020
 *	Version : 1.0.0
 *
 *	Trucker Controller: Define all possible endpoints like finding all Vehicles or Vehicles by ID, alerts, geolocation and other CRUD ops
 */

@CrossOrigin
@RestController
public class truckerController {

    @Autowired
    truckerService service;

    //GETs the list of all vehicles currently in the Database
    @GetMapping("/vehicles")
    public List<vehicleDetails> searchAll(){
        return service.searchAll();
    }

    //GETs the vehicle corresponding to the id, if present in the Database, otherwise, throws ResourceNotFoundException
    @GetMapping("/vehicles/{id}")
    public vehicleDetails searchById(@PathVariable("id") String vin ){
        return service.searchById(vin);
    }

    //GETs the list of all High alerts from the Database
    @GetMapping("alerts/high")
    public List<alertDetailsByVehicle> getHighAlerts(){
        return service.getHighAlerts();
    }

    //GETs the list of all alerts corresponding to a particular VIN
    @GetMapping("alerts/{vin}")
    public List<alertDetailsByVehicle> getVehicleAlerts(@PathVariable("vin") String vin){
        return service.getVehicleAlerts(vin);
    }

    //GETs the list of all vehicle readings corresponding to a particular VIN, in the last 30 minutes
    @GetMapping("/geolocation/{vin}")
    public List<vehicleReadings> getGeoLocation(@PathVariable("vin") String vin){
        return service.getGeoLocation(vin);
    }

    // PUTs mock vehicle details (array of vehicle objects) coming from Mocker API
    @PutMapping(value = "/vehicles",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<vehicleDetails> update(@RequestBody List<vehicleDetails> vehicles) {
        for(vehicleDetails vehicle : vehicles) {
            service.update(vehicle);
        }
        return vehicles;
    }

    // POSTs mock vehicle readings coming from Mocker API
    @PostMapping(value = "/readings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public vehicleReadings create(@RequestBody vehicleReadings vehicle) {

        tirePressure pressure = new tirePressure();
        pressure.vin = vehicle.getVin();
        pressure.timestamp = vehicle.getTimestamp();
        pressure.rearRight = vehicle.tires.rearRight;
        pressure.frontRight = vehicle.tires.frontRight;
        pressure.rearLeft = vehicle.tires.rearLeft;
        pressure.frontLeft = vehicle.tires.frontLeft;
        service.create(pressure);
        service.throwAlerts(vehicle);
        return service.create(vehicle);

    }



}
