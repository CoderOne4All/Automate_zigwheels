package com.automaton.base;

import java.util.ArrayList;
import java.util.List;

public class BikeInfo implements Comparable<BikeInfo> {
	public String bikeName;
	public int bikePrice;
	public String expectedLaunchDate;

	public BikeInfo(String bikeName, int bikePrice, String expectedLaunchDate) {

		this.bikeName = bikeName;
		this.bikePrice = bikePrice;
		this.expectedLaunchDate = expectedLaunchDate;
	}

	public int compareTo(BikeInfo bike) {
		if (bikePrice == bike.bikePrice)
			return 0;

		else if (bikePrice > bike.bikePrice)
			return 1;
		else
			return -1;
	}

	public static List<BikeInfo> filterPrice(List<BikeInfo> bikes) {
		ArrayList<BikeInfo> filterBikes = new ArrayList<BikeInfo>();
		for (BikeInfo bike : bikes) {
			if (bike.bikePrice <= 400000) {
				filterBikes.add(bike);
			}
		}
		return filterBikes;

	}

	@Override
	public String toString() {
		return "BikeInfo [bikeName=" + bikeName + ", bikePrice=" + bikePrice + ", expectedLaunchDate="
				+ expectedLaunchDate + "]";
	}

}
