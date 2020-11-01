package com.automaton.base;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ExtentReportManager;

public class BaseUI {

	public WebDriver driver;
	public static Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public DesiredCapabilities cap = null;

	static {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\ObjectRepository\\projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public WebDriver invokeBrowser(String browser) {
		try {

			if (prop.getProperty(browser).equalsIgnoreCase("chrome")) {
				cap = DesiredCapabilities.chrome();
			} else if (prop.getProperty(browser).equalsIgnoreCase("edge")) {
				cap = DesiredCapabilities.edge();
			} else {
				cap = DesiredCapabilities.firefox();
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.29.32:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}

	@AfterMethod
	public void flushReports() {
		report.flush();
	}

	// To open the website URL
	public void openURL(String websiteURLKey) {

		driver.get(prop.getProperty(websiteURLKey));
		driver.manage().window().maximize();

	}

	// To close the browser.
	public void closeBrowser() {
		driver.close();
	}

	// To quit the browser instance.
	public void quitBrowser() {
		driver.quit();
	}

	// To Enter the text in Text Fields which are uniquely identified.
	public void enterText(String xpathKey, String data) {
		getElement(xpathKey).sendKeys(data);
	}

	// To Enter the text in Text Fields which are not uniquely identified.
	public void enter_Text(String xpathKey, String data) {
		getElement(xpathKey).sendKeys(prop.getProperty(data));
	}

	// To click the element on the webpage.
	public void elementClick(String xpathKey) {
		try {

			getElement(xpathKey).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// To set the time of wait.
	public void waitInSeconds(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	// To Identify the Page WebElement
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		try {

			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Linktext")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
			} else {
				reportFail("Failing the TestCase, Invalid Locator " + locatorKey);
				Assert.fail("Failing the TestCase : " + locatorKey);
				System.out.println("Failing the TestCase : " + locatorKey);
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();

			Assert.fail("Failing the TestCase : " + e.getMessage());
		}

		return element;

	}

	// To get all the WebElements having same locator identity

	public List<WebElement> getElements(String locatorKey) {
		List<WebElement> elements = null;
		try {

			if (locatorKey.endsWith("_Id")) {
				elements = driver.findElements(By.id(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Xpath")) {
				elements = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				elements = driver.findElements(By.cssSelector(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Linktext")) {
				elements = driver.findElements(By.linkText(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				elements = driver.findElements(By.partialLinkText(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Name")) {
				elements = driver.findElements(By.name(prop.getProperty(locatorKey)));
			} else {
				reportFail("Failing the TestCase, Invalid Locator " + locatorKey);
				Assert.fail("Failing the TestCase : " + locatorKey);
				System.out.println("Failing the TestCase : " + locatorKey);
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();

			Assert.fail("Failing the TestCase : " + e.getMessage());
		}

		return elements;

	}

	// To double click the web element.
	public void doubleClick(String locatorKey) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locatorKey)).doubleClick().build().perform();
	}

	// To wait explicitly.
	public void explicitWait(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(locatorKey))));
	}

	public void pressTab(String locatorKey) {
		getElements(locatorKey).get(2).sendKeys(Keys.TAB);
	}

	// To select the date of booking flight
	public void clickFromAutoSuggestion(String locatorKey) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getElements(locatorKey).get(1).click();
	}

	// to dismiss the alert
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/*************** reporting Function ************/
	public void reportFail(String reportString) {
		System.out.println("Error is " + reportString);

	}
}
