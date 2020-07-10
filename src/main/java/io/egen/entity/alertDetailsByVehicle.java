package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @author Kaustav Sarkar
 *	Date : 07/01/2020
 *	Version : 1.0.0
 *
 *	Alert Details By Vehicle Entity: This entity furnishes further details, based on an data coming in from
 */

@Entity
@Table
@IdClass(alertByVehicle.class)
public class alertDetailsByVehicle implements Serializable {
    @Id
    String vin;
    @Id
    String timestamp;
    @Id
    String alertType;
    String Priority;
    String message;

    public alertDetailsByVehicle(){}
    public alertDetailsByVehicle(String vin, String timestamp) {
        this.vin = vin;
        this.timestamp = timestamp;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getVin() {
        return vin;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
