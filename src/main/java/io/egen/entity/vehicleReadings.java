package io.egen.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Kaustav Sarkar
 *	Date : 07/01/2020
 *	Version : 1.0.0
 *
 *	Vehicle Readings Entity: This is the entity storing the real-time vehicle readings coming in from Mocker API
 */
@Entity
@Table
@IdClass(vehicleId.class)
public class vehicleReadings implements Serializable {

        @Id
        private String vin;
        @Id
        private String timestamp;

        private double latitude;
        private double longitude;
        private float fuelVolume;
        private int speed;
        private double engineHp;
        private boolean checkEngineLightOn;
        private boolean engineCoolantLow;
        private boolean cruiseControlOn;
        private int engineRpm;

        @Transient
        public tirePressure tires;


        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public float getFuelVolume() {
            return fuelVolume;
        }

        public void setFuelVolume(float fuelVolume) {
            this.fuelVolume = fuelVolume;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public double getEngineHp() {
            return engineHp;
        }

        public void setEngineHp(double engineHp) {
            this.engineHp = engineHp;
        }

        public boolean isCheckEngineLightOn() {
            return checkEngineLightOn;
        }

        public void setCheckEngineLightOn(boolean checkEngineLightOn) {
            this.checkEngineLightOn = checkEngineLightOn;
        }

        public boolean isEngineCoolantLow() {
            return engineCoolantLow;
        }

        public void setEngineCoolantLow(boolean engineCoolantLow) {
            this.engineCoolantLow = engineCoolantLow;
        }

        public boolean isCruiseControlOn() {
            return cruiseControlOn;
        }

        public void setCruiseControlOn(boolean cruiseControlOn) {
            this.cruiseControlOn = cruiseControlOn;
        }

        public int getEngineRpm() {
            return engineRpm;
        }

        public void setEngineRpm(int engineRpm) {
            this.engineRpm = engineRpm;
        }

    }

