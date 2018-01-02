package com.escalona.bikesrental.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BikeRentalByHourTest {
	
	Double valueExpected;
	BikeRentalByHour bikeRentalByHour;

	@Before
	public void setUp() throws Exception {
		valueExpected = 30.0;
		bikeRentalByHour = new BikeRentalByHour(6, new Client("95569957", "Fernando Escalona"));
	}

	@After
	public void tearDown() throws Exception {
		bikeRentalByHour = null;
	}

	@Test
	public void testRentalByHourValueExpected() {
		System.out.println(bikeRentalByHour.rent());
		assertEquals(valueExpected, bikeRentalByHour.rent());		
	}

}
