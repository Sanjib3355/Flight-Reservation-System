package com.altimetrik.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.altimetrik.api.controller.FlightController;
import com.altimetrik.api.service.FlightService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class FlightControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private FlightController flightController;

	@Mock
	private FlightService service;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
	}

	@Test
	public void testSearchFlightDetails() throws Exception {

		/*
		 * when(service.searchFlightDetails(sourceCity, destinationCity, travelDate,
		 * returnDate)).thenReturn(list); assertEquals(Integer.MIN_VALUE,
		 * flightController.searchFlightDetails(sourceCity, destinationCity, travelDate,
		 * returnDate));
		 */

		/*
		 * mockMvc.perform(get("/getflightdetails")).andExpect(status().isOk())
		 * .andExpect(jsonPath("$.title", Matchers.is("sourceCity")))
		 * .andExpect(jsonPath("$.body", Matchers.is("destinationCity")))
		 * .andExpect(jsonPath("$.body", Matchers.is("travelDate")))
		 * .andExpect(jsonPath("$.body", Matchers.is("returnDate")));
		 */

	}
}
