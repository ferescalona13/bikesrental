package com.escalona.bikesrental.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BikeRentalRestControllerTest {
	
	public static final Logger logger = LoggerFactory.getLogger(BikeRentalRestControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBikeRentalRestController() throws Exception{
		
		mockMvc.perform(post("/rental/bikes/rentBike")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("amountOfTime", "4")
                .param("typeOfRent", "1")
                .param("clientName", "Fernando Escalona")
                .param("clientNroDoc", "95569957")
        ).andExpect(status().isOk());
	}

}
