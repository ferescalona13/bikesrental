package com.escalona.bikesrental.model;

import com.escalona.bikesrental.exception.NotValidSizeOfRentalsException;

public interface Rental {
	
	public static final int RENTAL_BY_HOURS = 1;
	public static final int RENTAL_BY_DAYS = 2;
	public static final int RENTAL_BY_WEEKS = 3;

	public Double rent() throws NotValidSizeOfRentalsException;

}