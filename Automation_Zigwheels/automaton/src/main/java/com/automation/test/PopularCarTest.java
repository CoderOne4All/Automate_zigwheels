package com.automation.test;

import org.testng.annotations.Test;
import com.automaton.base.BaseUI;
import com.aventstack.extentreports.Status;
import com.pageclasses.LandingPage;
import com.pageclasses.UsedCars;

public class PopularCarTest extends BaseUI{
	@Test
	public void testOne()
	{
			logger=report.createTest("Used Cars");
		    LandingPage landingPage = new LandingPage();//driver, logger);
		    logger.log(Status.INFO,"Clicking on used cars in chennai option");
		    UsedCars usedCars = landingPage.clickOnPopularUsedCars();
		    logger.log(Status.PASS,"clicked on used cars in chennai");
			usedCars.storeCarDetails("carNames_Xpath", "carPrices_Xpath");
			logger.log(Status.PASS, "Successfully stored the details of the used cars in excel");
			usedCars.quitBrowser();
			logger.log(Status.PASS,"Closed the browser succesfully");

   }
}
