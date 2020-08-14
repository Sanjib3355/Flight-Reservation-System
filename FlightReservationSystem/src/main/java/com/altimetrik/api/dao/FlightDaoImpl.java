package com.altimetrik.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.altimetrik.api.model.Flight;
import com.altimetrik.api.util.JDBCDBUtil;

@Component
public class FlightDaoImpl implements FlightDao {

	// This method will search all the flights according to sourceCity, destinationCity, travelDate and returnDate.
	public List<Flight> searchFlightDetails(String sourceCity, String destinationCity, String travelDate,
			String returnDate) throws Exception {

		SqlRowSet sqlRowSet = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCDBUtil.getInstance().dataSource());

		List<Flight> listOfFlightDetailsObj = new ArrayList<Flight>();
		
		Flight flight = null;
		
		try {
			sqlRowSet = jdbcTemplate.queryForRowSet(SEARCH_FLIGHT_DETAILS, new Object[] { sourceCity, destinationCity, travelDate, returnDate });
			
			while (sqlRowSet.next()) {
				flight = new Flight();
				flight.setAirLineName(sqlRowSet.getString("airLineName"));
				flight.setFlightNumber(sqlRowSet.getString("flightNumber"));
				flight.setDepartureTime(sqlRowSet.getString("departureTime"));
				flight.setArrivalTime(sqlRowSet.getString("arrivalTime"));
				flight.setDuration(sqlRowSet.getString("duration"));
				flight.setNoOfStops(sqlRowSet.getInt("noOfStops"));
				flight.setPrice(sqlRowSet.getDouble("price"));
				listOfFlightDetailsObj.add(flight);
			}

		} catch (Exception ex) {
			// log.error("Exception in searchFlightDetails :- " + ex);
		}
		return listOfFlightDetailsObj;
	}
}
