package com.automation.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automaton.base.BaseUI;
import com.aventstack.extentreports.Status;
import com.pageclasses.LandingPage;
import com.pageclasses.LoginPage;


public class LoginTest extends BaseUI {
	@Test(dataProvider = "emailId")
	public void testOne(String id)
	{
			logger=report.createTest("LogIn/SignIn with  google");
		    LandingPage landingPage = new LandingPage();
		    logger.log(Status.INFO,"Clicking on Sign in button");
		    LoginPage login = landingPage.clickOnSignIn();
		    logger.log(Status.PASS,"clicked on Sign in button");
			login.LoginWithGoogle("google_signin_Xpath","email_Id","next_button_email_Xpath","error_msg_Xpath",id);
			logger.log(Status.FAIL,"Could not sign in as invalid email id is entered" );
			login.quitBrowser();
			logger.log(Status.PASS,"Closed the browser succesfully");

   }
	@DataProvider(name="emailId")
	public Object[] emailId()
	{
		return new Object[] {"testerunited@123.com"};
	}

}