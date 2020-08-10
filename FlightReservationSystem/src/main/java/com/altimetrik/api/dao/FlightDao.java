package com.altimetrik.api.dao;

import java.util.List;

import com.altimetrik.api.model.Flight;

public interface FlightDao {

	public List<Flight> searchFlightDetails(String sourceCity, String destinationCity, String travelDate,
			String returnDate) throws Exception;

	public final String SEARCH_FLIGHT_DETAILS = "Select FLIGHTBOOKINGDETAILS.airLineName, FLIGHTBOOKINGDETAILS.flightNumber,"
												+ "FLIGHTBOOKINGDETAILS.departureTime,"
												+ "FLIGHTBOOKINGDETAILS.arrivalTime,"
												+ "FLIGHTBOOKINGDETAILS.durtion,FLIGHTBOOKINGDETAILS.noOfStops,FLIGHTBOOKINGDETAILS.price"
												+ "from FLIGHTBOOKINGDETAILS where sourceCity=? AND destinationCity= ? AND travelDate =? AND returnDate = ?";
}