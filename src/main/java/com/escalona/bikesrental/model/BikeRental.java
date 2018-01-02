package com.escalona.bikesrental.model;

public abstract class BikeRental {
	
	protected Integer amountOfTime;
	protected Client client;
	
	protected abstract Double getPriceOfRental();

}
