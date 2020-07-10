package io.egen.repository;

import io.egen.entity.vehicleDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kaustav Sarkar
 *	Date : 07/02/2020
 *	Version : 1.0.0
 *
 *	Vehicle Repository: The vehicle repository simply extends the Crud Repository (of Spring Framework) to implement all the basic functions
 */


public interface vehicleRepo extends CrudRepository<vehicleDetails, String> {

}
