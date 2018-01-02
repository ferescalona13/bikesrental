package com.escalona.bikesrental.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.escalona.bikesrental.exception.NotValidSizeOfRentalsException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyRentalTest {
	
	Double rentalValueWithDiscount;
	Rental familyRental;
	List<BikeRental> rentals;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		
		BikeRentalByHour bikeRentalByHour = new BikeRentalByHour(2, new Client("95569957", "Fernando Escalona"));
		BikeRentalByDay bikeRentalByDay = new BikeRentalByDay(4, new Client("12345678", "Hilda Mendoza"));
		BikeRentalByWeek bikeRentalByWeek = new BikeRentalByWeek(3, new Client("87654321", "Cristina Rondon"));
		
		Double rentalValueTotal = bikeRentalByHour.getPriceOfRental() + bikeRentalByDay.getPriceOfRental() + bikeRentalByWeek.getPriceOfRental();
		rentalValueWithDiscount = rentalValueTotal * 0.7;
		
		rentals = new ArrayList<BikeRental>();
		rentals.add(bikeRentalByHour);
		rentals.add(bikeRentalByDay);
		rentals.add(bikeRentalByWeek);
		
		familyRental = new FamilyBikeRental(rentals);
	}
	
	@After
	public void tearDown() {
		familyRental = null;
	}

	@Test
	public void testFamilyRentalDiscountApplied() throws NotValidSizeOfRentalsException {
		
		System.out.println("Family Rent "+familyRental.rent());
		assertEquals(rentalValueWithDiscount, familyRental.rent());		
	}
	
	@Test (expected = NotValidSizeOfRentalsException.class)
	public void testFamilyRentalValidSizeOfRentals() throws NotValidSizeOfRentalsException{
		rentals.remove(0);
		familyRental.rent();
		thrown.expect(NotValidSizeOfRentalsException.class);
	}

}
