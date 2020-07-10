package io.egen.repository;

import io.egen.entity.vehicleId;
import io.egen.entity.vehicleReadings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Kaustav Sarkar
 *	Date : 07/02/2020
 *	Version : 1.0.0
 *
 *	Geolocation Repository: The geolocation repository extends the Crud Repository (of Spring Framework) but uses Native SQL Query to generate all vehicle
 *                    alerts corresponding to a particular VIN, in the last 30 minutes
 */

public interface geolocationRepo extends CrudRepository<vehicleReadings, vehicleId> {
    @Query(value = "select * from vehicle_readings where vin =:vin and TIME_TO_SEC(TIMEDIFF(current_timestamp, timestamp)) / 60<= 30  ",
            nativeQuery = true)
    Optional<List<vehicleReadings>> getGeoLocation(@Param("vin") String vin);
}
