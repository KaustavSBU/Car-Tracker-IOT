package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Kaustav Sarkar
 *	Date : 07/01/2020
 *	Version : 1.0.0
 *
 *	Vehicle Details Entity: Create entity class corresponding to the array of vehicle objects coming in from the Mocker API
 */
@Entity
public class vehicleDetails {

    @Id
    String vin;
    String make;
    String model;
    int year;
    int redlineRpm;
    float maxFuelVolume;
    String lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolumeVol) {
        this.maxFuelVolume = maxFuelVolumeVol;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
