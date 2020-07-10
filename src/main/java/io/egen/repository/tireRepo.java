package io.egen.repository;

import io.egen.entity.tirePressure;
import io.egen.entity.vehicleId;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kaustav Sarkar
 *	Date : 07/02/2020
 *	Version : 1.0.0
 *
 *	Tire Repository: The tire repository simply extends the Crud Repository (of Spring Framework) to implement the tire related functions
 */


public interface tireRepo extends CrudRepository<tirePressure, vehicleId> {

}
