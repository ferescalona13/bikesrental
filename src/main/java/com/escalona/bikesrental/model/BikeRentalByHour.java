package com.escalona.bikesrental.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BikeRentalByHour extends BikeRental implements Rental {
	
	public static final Logger logger = LoggerFactory.getLogger(BikeRentalByHour.class);
	
	public static Double priceRentalByHour = 5.0;	

	public BikeRentalByHour(Integer amountOfHours, Client client) {
		
		this.amountOfTime = amountOfHours;
		this.client = client;		
	}

	@Override
	public Double rent() {
		// TODO Auto-generated method stub
		logger.info("Renting bike for "+amountOfTime+" hours");
		return getPriceOfRental();
	}

	@Override
	protected Double getPriceOfRental() {
		// TODO Auto-generated method stub
		return this.amountOfTime * priceRentalByHour;
	}

}
