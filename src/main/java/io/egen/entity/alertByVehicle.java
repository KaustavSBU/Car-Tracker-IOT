package io.egen.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Kaustav Sarkar
 *	Date : 07/01/2020
 *	Version : 1.0.0
 *
 *	Alert By Vehicle Entity: This entity creates an alert, based on an unique combination of vin and timestamp
 */

public class alertByVehicle implements Serializable {
    String vin;
    String timestamp;
    String alertType;

    public alertByVehicle(){}
    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public alertByVehicle(String vin, String timestamp, String alertType) {
        this.vin = vin;
        this.timestamp = timestamp;
        this.alertType = alertType;
    }



    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        alertByVehicle that = (alertByVehicle) o;
        return vin.equals(that.vin) &&
                timestamp.equals(that.timestamp) && alertType.equals(that.alertType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, timestamp, alertType);
    }
}
