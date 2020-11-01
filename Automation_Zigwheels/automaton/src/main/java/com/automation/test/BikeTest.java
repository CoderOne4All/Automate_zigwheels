package com.automation.test;

import org.testng.annotations.Test;
import com.automaton.base.BaseUI;
import com.aventstack.extentreports.Status;
import com.pageclasses.LandingPage;
import com.pageclasses.UpcomingBikes;

public class BikeTest extends BaseUI {
	@Test
	public void testOne() {
		logger=report.createTest("Upcoming Bikes");
		LandingPage landingPage = new LandingPage();
		UpcomingBikes upcomingBikes = landingPage.clickOnNewBike();
		logger.log(Status.PASS, "Clicked on the new Bikes option");
		upcomingBikes.storeBikeDetails("bikeNames_Xpath", "bikePrices_Xpath", "expectedLaunchDates_Xpath");
		logger.log(Status.PASS, "Stored the details of the bikes successfully");
		upcomingBikes.quitBrowser();
		logger.log(Status.PASS, "Closed the browser Successfully");
	}

}