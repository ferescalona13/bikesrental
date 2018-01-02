package com.escalona.bikesrental.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BikeRentalByWeek extends BikeRental implements Rental {
	
	public static final Logger logger = LoggerFactory.getLogger(BikeRentalByWeek.class);
	
	public static Double priceRentalByWeek = 60.0;

	public BikeRentalByWeek(Integer amountOfWeeks, Client client) {

		this.amountOfTime = amountOfWeeks;
		this.client = client;
	}

	@Override
	public Double rent() {
		// TODO Auto-generated method stub
		logger.info("Renting bike for "+amountOfTime+" weeks");
		return getPriceOfRental();
	}

	@Override
	protected Double getPriceOfRental() {
		// TODO Auto-generated method stub
		return this.amountOfTime * priceRentalByWeek;
	}

}
