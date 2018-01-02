package com.escalona.bikesrental.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BikeRentalByDay extends BikeRental implements Rental {
	
	public static final Logger logger = LoggerFactory.getLogger(BikeRentalByDay.class);

	public static Double priceRentalByDay = 20.0;
	
	public BikeRentalByDay(Integer amountOfDays, Client client) {
		
		this.amountOfTime = amountOfDays;
		this.client = client;		
	}

	@Override
	public Double rent() {
		// TODO Auto-generated method stub
		logger.info("Renting bike for "+amountOfTime+" days");
		return getPriceOfRental();
	}

	@Override
	protected Double getPriceOfRental() {
		// TODO Auto-generated method stub
		return this.amountOfTime * priceRentalByDay;
	}


}
