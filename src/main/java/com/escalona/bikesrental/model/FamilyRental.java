package com.escalona.bikesrental.model;

public interface FamilyRental {
	
	public static final Integer MIN_AMOUNT_OF_RENTALS = 3;
	public static final Integer MAX_AMOUNT_RENTALS = 5;
	
	public default Double applyDiscount(Double price) {
		return price * 0.7;
	}
}
