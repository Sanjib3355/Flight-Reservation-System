package com.altimetrik.api.sortingcomparator;

import java.util.Comparator;

import com.altimetrik.api.model.Flight;

public class FlightSortByPriceComparator implements Comparator<Flight> {

	/*
	 * @Override public int compare(FlightComparator o1, FlightComparator o2) { // In ascending order
	 * 
	 * return (int) (o1.getPrice() - (o2.getPrice()));
	 * 
	 * }
	 */

	@Override
	public int compare(Flight o2, Flight o1) { // In descending order

		return (int) (o1.getPrice() - o2.getPrice());
	}
}