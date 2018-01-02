package com.escalona.bikesrental.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BikeRentalByWeekTest {
	
	Double valueExpected;
	BikeRentalByWeek bikeRentalByWeek;

	@Before
	public void setUp() throws Exception {
		valueExpected = 120.0;
		bikeRentalByWeek = new BikeRentalByWeek(2, new Client("95569957", "Fernando Escalona"));
	}

	@After
	public void tearDown() throws Exception {
		bikeRentalByWeek = null;
	}

	@Test
	public void test() {
		System.out.println(bikeRentalByWeek.rent());
		assertEquals(valueExpected, bikeRentalByWeek.rent());
	}

}
