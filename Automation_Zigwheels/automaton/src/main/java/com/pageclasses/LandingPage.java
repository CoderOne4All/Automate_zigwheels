package com.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.automaton.base.BaseUI;
import com.aventstack.extentreports.ExtentTest;

public class LandingPage extends BaseUI {
	public ExtentTest logger;

	public LandingPage() {

		this.driver = invokeBrowser("browserName");
		openURL("webSiteUrl");
	}

	// to return the UpcomingBikes page
	public UpcomingBikes clickOnNewBike() {

		WebElement newBikesOption = driver
				.findElement(By.xpath("//header/div[2]/div[2]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(newBikesOption).perform();
		WebElement upcomingBikesOption = driver.findElement(
				By.xpath("//header/div[2]/div[2]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[1]/div[1]/ul[1]/li[3]/a[1]"));
		upcomingBikesOption.click();

		Select select = new Select(driver.findElement(By.className("custom-select")));
		select.selectByVisibleText("Bajaj");

		return PageFactory.initElements(driver, UpcomingBikes.class);
	}

	// to return the UpcomingBikes page in Chennai
	public UsedCars clickOnPopularUsedCars() {
		WebElement usedCarsOption = driver
				.findElement(By.xpath("//header/div[2]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(usedCarsOption).perform();
		WebElement popularCarInChennai = driver
				.findElement(By.xpath("//header/div[2]/div[2]/div[1]/div[2]/ul[1]/li[5]/ul[1]//div[2]//li[5]/a"));
		popularCarInChennai.click();
		return PageFactory.initElements(driver, UsedCars.class);
	}

	public LoginPage clickOnSignIn() {
		driver.findElement(By.xpath("//*[@id='des_lIcon']")).click();

		return PageFactory.initElements(driver, LoginPage.class);
	}

}
