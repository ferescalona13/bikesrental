package com.escalona.bikesrental.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.escalona.bikesrental.exception.NotValidSizeOfRentalsException;

public class FamilyBikeRental implements Rental, FamilyRental {
	
	public static final Logger logger = LoggerFactory.getLogger(FamilyBikeRental.class);
	
	public List<BikeRental> listBikeRentals;	
	
	public FamilyBikeRental(List<BikeRental> listBikeRentals) {
		
		this.listBikeRentals = listBikeRentals;		
		
	}

	@Override
	public Double rent() throws NotValidSizeOfRentalsException{
		// TODO Auto-generated method stub
		
		logger.info("Applying Family Rental");
		
		if (listBikeRentals.size() < FamilyRental.MIN_AMOUNT_OF_RENTALS || listBikeRentals.size() > FamilyRental.MAX_AMOUNT_RENTALS)
			throw new NotValidSizeOfRentalsException();
		
		Double amountOfRent = 0.0;
		
		for (BikeRental br : listBikeRentals) {
			amountOfRent += br.getPriceOfRental(); 
		}
		
		return this.applyDiscount(amountOfRent);
	}

}
