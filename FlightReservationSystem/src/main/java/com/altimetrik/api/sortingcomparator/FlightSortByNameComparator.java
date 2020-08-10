package com.altimetrik.api.sortingcomparator;

import java.util.Comparator;

import com.altimetrik.api.model.Flight;

public class FlightSortByNameComparator implements Comparator<Flight> {

	/*
	 * @Override public int compare(Flight o1, Flight o2) { // In ascending order
	 * 
	 * return o1.getAirLineName().compareTo(o2.getAirLineName()); }
	 */
	
	@Override
	public int compare(Flight o2, Flight o1) { // In descending order
		
		return o1.getAirLineName().compareTo(o2.getAirLineName());
	}
}