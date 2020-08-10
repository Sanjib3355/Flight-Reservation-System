package com.altimetrik.api.service;

import java.util.List;

import com.altimetrik.api.model.Flight;

public interface FlightService {

	public List<Flight> searchFlightDetails(String sourceCity,String destinationCity,String travelDate,String returnDate) throws Exception;
	public List<Flight> sortFlightDetailsWithAilrlineName(String airlneName,List<Flight> serachResultObj) throws Exception;
	public List<Flight> sortFlightDetailsWithDepartureTime(String deparatureTime,List<Flight> serachResultObj) throws Exception;
	public List<Flight> sortFlightDetailsWithDuration(String duration,List<Flight> serachResultObj) throws Exception;
	public List<Flight> sortFlightDetailsWithPrice(int price,List<Flight> serachResultObj) throws Exception;
}
