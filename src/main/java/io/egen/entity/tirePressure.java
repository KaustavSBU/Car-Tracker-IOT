package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


/**
 * @author Kaustav Sarkar
 *	Date : 07/01/2020
 *	Version : 1.0.0
 *
 *	Tire Pressure Entity: These are the tire pressure values coming from the tires reading
 */

@Entity
@Table
@IdClass(vehicleId.class)
public class tirePressure {
    @Id
    public String vin;
    @Id
    public String timestamp;
    public int frontLeft;
    public int rearLeft;
    public int rearRight;
    public int frontRight;


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

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }
}
