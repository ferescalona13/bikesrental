package com.escalona.bikesrental.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BikeRentalByDayTest {
	
	public static final Logger logger = LoggerFactory.getLogger(BikeRentalByDayTest.class);
	
	Double valueExpected;
	BikeRentalByDay bikeRentalByDay ;
	
	@Before 
	public void setUp() {
		valueExpected = 80.0;
		bikeRentalByDay = new BikeRentalByDay(4, new Client("95569957", "Fernando Escalona"));
	}
	

	@After
	public void tearDown() {
		bikeRentalByDay = null;
	}

	@Test
	public void testRentalByDayValueExpected() {
		System.out.println(bikeRentalByDay.rent());
		assertEquals(valueExpected, bikeRentalByDay.rent());
		
	}
	
}
