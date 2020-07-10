package io.egen.service;

import io.egen.entity.*;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.alertRepo;
import io.egen.repository.geolocationRepo;
import io.egen.repository.tireRepo;
import io.egen.repository.vehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Kaustav Sarkar
 *	Date : 07/03/2020
 *	Version : 1.0.0
 *
 *	Trucker Service Implementation: The concrete service class implementation containing all the business logic
 */

@Service
public class truckerServiceImplementation implements truckerService {
    @Autowired
    alertRepo alert;
    @Autowired
    geolocationRepo georeadings;
    @Autowired
    tireRepo tire;
    @Autowired
    vehicleRepo vehicle;


    @Transactional(readOnly = true)
    public List<vehicleDetails> searchAll() {
        return (List<vehicleDetails>) vehicle.findAll();
    }

    @Transactional(readOnly = true)
    public vehicleDetails searchById(String Id) {

        return vehicle.findById(Id).orElseThrow(()->new ResourceNotFoundException("The vehicle with vehicle id:  " + Id + " doesn't exist !"));
    }

    @Transactional
    public List<vehicleReadings> getGeoLocation(String vin) {
        Optional<List<vehicleReadings>> existing = georeadings.getGeoLocation(vin);
        if (!existing.isPresent()){
            throw new ResourceNotFoundException("The vehicle with vin: " + vin + " doesn't exist !");
        }
        return existing.get();
    }

    @Transactional(readOnly = true)
    public List<alertDetailsByVehicle> getHighAlerts(){
        return alert.vehicleHighAlerts();
    }

    @Transactional(readOnly = true)
    public List<alertDetailsByVehicle> getVehicleAlerts(String vin){
        return alert.vehicleAlerts(vin);
    }

    @Transactional
    public vehicleDetails update(vehicleDetails vehicleDetail) {
        Optional<io.egen.entity.vehicleDetails> existing = vehicle.findById(vehicleDetail.getVin());
        if(existing.isPresent()) {
            return null;
        }
        return vehicle.save(vehicleDetail);
    }


    @Transactional
    public vehicleReadings create(vehicleReadings vehicleReading) {
        Optional<vehicleDetails> existing = vehicle.findById(vehicleReading.getVin());
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("The Vehicle you are looking for with vin: "+ vehicleReading.getVin() + " is not present in our records");
        }
        return georeadings.save(vehicleReading);
    }

    @Transactional
    public tirePressure create(tirePressure pressure) {
        Optional<vehicleDetails> existing = vehicle.findById(pressure.getVin());
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("The Vehicle you are looking for with vin:"+ pressure.getVin() + " is not present in our records");
        }
        return tire.save(pressure);
    }


    public void throwAlerts(vehicleReadings vehicles){
        Optional<vehicleDetails> vehicleDetails = vehicle.findById(vehicles.getVin());
        Optional<tirePressure> tirePressure = tire.findById(new vehicleId(vehicles.getVin(),vehicles.getTimestamp()));

        if(vehicleDetails.isPresent()){
            if(vehicleDetails.get().getRedlineRpm() < vehicles.getEngineRpm())
            {
                alertDetailsByVehicle alertDetailsByVehicle = new alertDetailsByVehicle(vehicles.getVin(),vehicles.getTimestamp());
                alertDetailsByVehicle.setPriority("HIGH");
                alertDetailsByVehicle.setAlertType("RPM");
                alertDetailsByVehicle.setMessage("HIGH ALERT: Vehicle's RPM is more than Red Line RPM !!!");
                alert.save(alertDetailsByVehicle);
            }
            if(vehicleDetails.get().getMaxFuelVolume()*0.1 > vehicles.getFuelVolume()){
                alertDetailsByVehicle alertDetailsByVehicle = new alertDetailsByVehicle(vehicles.getVin(),vehicles.getTimestamp());
                alertDetailsByVehicle.setPriority("MEDIUM");
                alertDetailsByVehicle.setAlertType("FUEL");
                alertDetailsByVehicle.setMessage("MEDIUM ALERT: You have less than 10% fuel remaining. Please fill at the next Gas Stop !");
                alert.save(alertDetailsByVehicle);
            }

            if(tirePressure.get().getRearLeft() < 32 || tirePressure.get().getRearLeft() > 36 || tirePressure.get().getRearRight() < 32 || tirePressure.get().getRearRight() > 36  ||
                    tirePressure.get().getFrontLeft() < 32 || tirePressure.get().getFrontLeft() > 36 || tirePressure.get().getFrontRight() < 32 || tirePressure.get().getFrontRight() > 36 )
            {
                alertDetailsByVehicle alertDetailsByVehicle = new alertDetailsByVehicle(vehicles.getVin(),vehicles.getTimestamp());
                alertDetailsByVehicle.setPriority("LOW");
                alertDetailsByVehicle.setAlertType("TIRE");
                alertDetailsByVehicle.setMessage("LOW ALERT: The tire pressure is lower than normal !");
                alert.save(alertDetailsByVehicle);
            }

            if(vehicles.isEngineCoolantLow() || vehicles.isCheckEngineLightOn()) {
                alertDetailsByVehicle alertDetailsByVehicle = new alertDetailsByVehicle(vehicles.getVin(),vehicles.getTimestamp());
                alertDetailsByVehicle.setPriority("LOW");
                alertDetailsByVehicle.setAlertType("ENGINE");
                alertDetailsByVehicle.setMessage("LOW ALERT: Engine Coolant is low and Engine Light is On !");
                alert.save(alertDetailsByVehicle);
            }
        }

    }


}
