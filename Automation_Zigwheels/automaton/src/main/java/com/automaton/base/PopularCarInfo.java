package com.automaton.base;

public class PopularCarInfo {

	public String carName;
	public String carCost;

	public PopularCarInfo(String carName, String carCost) {
		this.carName = carName;
		this.carCost = carCost;
	}

	@Override
	public String toString() {
		return "PopularCarInfo [carName=" + carName + ", carCost=" + carCost + "]";
	}

}
