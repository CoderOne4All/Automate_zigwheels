package com.pageclasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.automation.datadriven.utils.WriteToExcel;
import com.automaton.base.BaseUI;
import com.automaton.base.BikeInfo;

public class UpcomingBikes extends BaseUI {

	public UpcomingBikes(WebDriver driver) {

		this.driver = driver;

	}

	// to Store the bike details
	public void storeBikeDetails(String locatorKey_bikeNames, String locatorKey_bikePrices,
			String locatorKey_bikeExpectedLaunchDates) {
		List<WebElement> bikeNames = getElements(locatorKey_bikeNames);
		List<WebElement> bikePrices = getElements(locatorKey_bikePrices);
		List<WebElement> bikeExpectedLaunchDates = getElements(locatorKey_bikeExpectedLaunchDates);
		List<BikeInfo> bikes = new ArrayList<BikeInfo>();
		int lakh = 100000;

		for (int index = 0; index < bikeNames.size(); index++) {
			System.out.println(bikeNames.get(index).getText() + "  " + bikePrices.get(index).getText() + "  "
					+ bikeExpectedLaunchDates.get(index).getText());

			if (!bikeNames.get(index).getText().trim().isEmpty()) {
				bikes.add(new BikeInfo(bikeNames.get(index).getText(),
						Float.valueOf(Float.valueOf((bikePrices.get(index).getText().replaceAll("[A-Z a-z]", "")
								.replaceAll("^.", "").trim())) * lakh).intValue(),
						bikeExpectedLaunchDates.get(index).getText().split(":")[1]));
			}
		}

		Collections.sort(bikes);

		try {
			WriteToExcel.writeInExcel_BikeInfo(BikeInfo.filterPrice(bikes));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
