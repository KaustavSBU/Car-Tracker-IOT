package io.egen.service;

import io.egen.entity.alertDetailsByVehicle;
import io.egen.entity.tirePressure;
import io.egen.entity.vehicleDetails;
import io.egen.entity.vehicleReadings;

import java.util.List;

/**
 * @author Kaustav Sarkar
 *	Date : 07/03/2020
 *	Version : 1.0.0
 *
 *	Vehicle Service: An interface containing all the business items to be implemented
 */


public interface truckerService {

        vehicleDetails update(vehicleDetails vehicle);
        List<vehicleDetails> searchAll();
        vehicleDetails searchById(String Id);
        vehicleReadings create(vehicleReadings vehicle);
        tirePressure create(tirePressure pressure);
        List<alertDetailsByVehicle> getHighAlerts();
        List<vehicleReadings> getGeoLocation(String vin);
        List<alertDetailsByVehicle> getVehicleAlerts(String vin);
        void throwAlerts(vehicleReadings vehicle);

}
