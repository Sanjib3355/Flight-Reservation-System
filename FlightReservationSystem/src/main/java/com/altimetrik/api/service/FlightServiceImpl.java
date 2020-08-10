package com.altimetrik.api.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.api.dao.FlightDao;
import com.altimetrik.api.model.Flight;
import com.altimetrik.api.sortingcomparator.FlightSortByDepartureTimeComparator;
import com.altimetrik.api.sortingcomparator.FlightSortByDurationComparator;
import com.altimetrik.api.sortingcomparator.FlightSortByNameComparator;
import com.altimetrik.api.sortingcomparator.FlightSortByPriceComparator;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;
	
	@Autowired
    Flight flight;
	
	public List<Flight> searchFlightDetails(String sourceCity, String destinationCity, String travelDate,
			String returnDate) throws Exception {
		return flightDao.searchFlightDetails(sourceCity, destinationCity, travelDate, returnDate);
	}

	// This method will sort the flights w.r.t Airline Name.
	@Override
	public List<Flight> sortFlightDetailsWithAilrlineName(String airlneName, List<Flight> serachResultObj)
			throws Exception {

		new FlightSortByNameComparator().compare(flight, flight);
		Collections.sort(serachResultObj, new FlightSortByNameComparator());
		
		//Collections.sort(serachResultObj, (o1, o2) -> (o1.getAirLineName().compareTo(o2.getAirLineName())));
		return serachResultObj;
	}
	
	// This method will sort the flights w.r.t Departure Time
	@Override
	public List<Flight> sortFlightDetailsWithDepartureTime(String departureTime,
			List<Flight> serachResultObj) throws Exception {

		new FlightSortByDepartureTimeComparator().compare(flight, flight);
		Collections.sort(serachResultObj, new FlightSortByDepartureTimeComparator());
		
		//Collections.sort(serachResultObj, (o1, o2) -> (o1.getDepartureTime().compareTo(o2.getDepartureTime())));
		return serachResultObj;
	}
	
	// This method will sort the flights w.r.t Duration
	@Override
	public List<Flight> sortFlightDetailsWithDuration(String duration, List<Flight> serachResultObj)
			throws Exception {
		
		new FlightSortByDurationComparator().compare(flight, flight);
		Collections.sort(serachResultObj, new FlightSortByDurationComparator());
		
		//Collections.sort(serachResultObj, (o1, o2) -> (o1.getDuration().compareTo(o2.getDuration())));
		return serachResultObj;
	}
	
	// This method will sort the flights w.r.t Price
	@Override
	public List<Flight> sortFlightDetailsWithPrice(int price, List<Flight> serachResultObj)
			throws Exception {
		
		new FlightSortByPriceComparator().compare(flight, flight);
		Collections.sort(serachResultObj, new FlightSortByPriceComparator());
		
		//Collections.sort(serachResultObj, (o1, o2) -> (o1.getPrice().compareTo(o2.getPrice())));

		return serachResultObj;
	}
}