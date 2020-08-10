package com.altimetrik.api.model;

import org.springframework.stereotype.Component;

@Component
public class Flight {

	    private String flightNumber;
	    private String airLineName;
	    private String departureTime;
	    private String arrivalTime;
	    private String duration;
	    private int noOfStops;
	    private double price;
	    
		public String getFlightNumber() {
			return flightNumber;
		}
		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}
		public String getAirLineName() {
			return airLineName;
		}
		public void setAirLineName(String airLineName) {
			this.airLineName = airLineName;
		}
		public String getDepartureTime() {
			return departureTime;
		}
		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}
		public String getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String durtion) {
			this.duration = durtion;
		}
		public int getNoOfStops() {
			return noOfStops;
		}
		public void setNoOfStops(int noOfStops) {
			this.noOfStops = noOfStops;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
}
