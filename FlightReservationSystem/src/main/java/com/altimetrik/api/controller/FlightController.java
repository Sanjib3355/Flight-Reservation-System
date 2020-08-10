package com.altimetrik.api.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.api.model.Flight;
import com.altimetrik.api.service.FlightServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/flightbookingapi")
public class FlightController {

	@Autowired
	private FlightServiceImpl flightServiceImpl;

	@SuppressWarnings("unchecked")
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(value = "/getflightdetails", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> searchFlightDetails(String sourceCity, String destinationCity,
			String travelDate, String returnDate) throws Exception { // This method will search all the details of a
																		// flight according to sourceCity,
																		// destinationCity, travelDate and returnDate.

		List<Flight> listOFlightSearchResults = null;
		JSONObject listOfFlightSearchResultsJson = new JSONObject();
		ObjectMapper flightDetailsJsonMapper = null;

		try {
			if (((sourceCity != null) && (!sourceCity.isEmpty()))
					&& ((destinationCity != null) && (!destinationCity.isEmpty()))
					&& ((travelDate != null) && (!travelDate.isEmpty()))
					&& ((returnDate != null) && (!returnDate.isEmpty()))) {

				flightDetailsJsonMapper = new ObjectMapper();
				
				listOFlightSearchResults = flightServiceImpl.searchFlightDetails(sourceCity, destinationCity, travelDate, returnDate);
				listOfFlightSearchResultsJson.put("message", "SUCCESS");
				listOfFlightSearchResultsJson.put("statusCode", HttpStatus.OK);
				listOfFlightSearchResultsJson.put("result",flightDetailsJsonMapper.writeValueAsString(listOFlightSearchResults));
				
			} else {
				if (sourceCity == null || sourceCity.isEmpty()) {
					listOfFlightSearchResultsJson.put("message", "Source City Can not be Empty");
				} else if (destinationCity == null || destinationCity.isEmpty()) {
					listOfFlightSearchResultsJson.put("message", "Destination City Can not be Empty");
				} else if (travelDate == null || travelDate.isEmpty()) {
					listOfFlightSearchResultsJson.put("message", "Travel Date Can not be Empty");
				}
				listOfFlightSearchResultsJson.put("message", "FAILED");
				listOfFlightSearchResultsJson.put("status", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception ex) {
			try {
				listOfFlightSearchResultsJson.put("message", "FAILED");
				listOfFlightSearchResultsJson.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JSONException je) {
				// log.error("JSONException in searchFlightDetails:- " + je);
			}
		}
		return new ResponseEntity<String>(listOfFlightSearchResultsJson.toString(), HttpStatus.OK);
	}
}
