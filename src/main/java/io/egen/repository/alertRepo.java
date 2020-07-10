package io.egen.repository;

import io.egen.entity.alertByVehicle;
import io.egen.entity.alertDetailsByVehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Kaustav Sarkar
 *	Date : 07/02/2020
 *	Version : 1.0.0
 *
 *	Alert Repository: The alert repository extends the Crud Repository (of Spring Framework) but uses Native SQL Query to generate all vehicle
 *                    alerts, and then the ones which have high priority
 */

public interface alertRepo extends CrudRepository<alertDetailsByVehicle, alertByVehicle> {

    @Query(value = "SELECT * FROM alert_details_by_vehicle where vin =:vin ",nativeQuery = true)
    List<alertDetailsByVehicle> vehicleAlerts(@Param("vin") String vin);

    @Query(value = "SELECT * FROM alert_details_by_vehicle where Priority = 'HIGH' and TIME_TO_SEC(TIMEDIFF(current_timestamp, timestamp)) / 60<= 120   order by timestamp DESC ",nativeQuery = true)
    List<alertDetailsByVehicle> vehicleHighAlerts();

}
