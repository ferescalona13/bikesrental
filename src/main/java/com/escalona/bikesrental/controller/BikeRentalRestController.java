package com.escalona.bikesrental.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.escalona.bikesrental.exception.NotValidSizeOfRentalsException;
import com.escalona.bikesrental.model.BikeRentalByDay;
import com.escalona.bikesrental.model.BikeRentalByHour;
import com.escalona.bikesrental.model.BikeRentalByWeek;
import com.escalona.bikesrental.model.Client;
import com.escalona.bikesrental.model.Rental;


@RestController
@RequestMapping("/rental/bikes")
public class BikeRentalRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(BikeRentalRestController.class);
	
	@ResponseBody
	@RequestMapping(value = "/rentBike", method = RequestMethod.POST)
	public ResponseEntity<?> rentByHour(@RequestParam(value = "amountOfTime") Integer amountOfTime, @RequestParam(value = "typeOfRent") Integer typeOfRent, @RequestParam(value = "clientName") String clientName, @RequestParam(value = "clientNroDoc") String clientNroDoc) throws NotValidSizeOfRentalsException {
		logger.info("Renting bike for "+amountOfTime+" Type of rent "+typeOfRent+" for the client "+clientName+" with number of document "+clientNroDoc);
		
		Rental rental = null;
		String type = null;
		
		switch (typeOfRent) {
			case Rental.RENTAL_BY_HOURS:
				rental = new BikeRentalByHour(amountOfTime, new Client (clientNroDoc, clientName));
				type = "hours";
				break;
			case Rental.RENTAL_BY_DAYS:
				rental = new BikeRentalByDay(amountOfTime, new Client (clientNroDoc, clientName));
				type = "days";
				break;
			case Rental.RENTAL_BY_WEEKS:
				rental = new BikeRentalByWeek(amountOfTime, new Client (clientNroDoc, clientName));
				type = "weeks";
				break;
			default:
				break;
		}
		
		Double costOfRental = rental.rent();
		
		logger.info("Bike succesfully rented for "+ amountOfTime +" "+type+" with a cost of "+costOfRental);
		
		return new ResponseEntity<String>("Bike succesfully rented for "+ amountOfTime +" "+type+" with a cost of "+costOfRental,HttpStatus.OK);	
					
	}


}
