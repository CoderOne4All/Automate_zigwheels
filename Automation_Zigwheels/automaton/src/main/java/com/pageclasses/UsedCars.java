package com.pageclasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.datadriven.utils.WriteToExcel;
import com.automaton.base.BaseUI;
import com.automaton.base.PopularCarInfo;

public class UsedCars extends BaseUI {

	public UsedCars(WebDriver driver) {
		this.driver = driver;
	}

	// To store popular car information
	public void storeCarDetails(String locatorKey_carNames, String locatorKey_carPrices) {
		List<WebElement> carNames = getElements(locatorKey_carNames);
		List<WebElement> carPrices = getElements(locatorKey_carPrices);
		List<PopularCarInfo> cars = new ArrayList<PopularCarInfo>();

		for (int index = 0; index < carNames.size(); index++) {
			System.out.println(carNames.get(index).getText() + "  " + carPrices.get(index).getText());

			cars.add(new PopularCarInfo(carNames.get(index).getText(), carPrices.get(index).getText()));

		}

		try {
			WriteToExcel.writeInExcel_CarInfo(cars);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
