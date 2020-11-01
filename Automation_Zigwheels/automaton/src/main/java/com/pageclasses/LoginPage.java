package com.pageclasses;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automaton.base.BaseUI;

public class LoginPage extends BaseUI {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void LoginWithGoogle(String locatorKey_google, String locatorKey_email, String locatorkey_nextbutton,
			String locatorKey_errormsg, String id) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement signin = getElement(locatorKey_google);
		signin.click();

		Set<String> handles = driver.getWindowHandles();
		String originalWindow = driver.getWindowHandle();

		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {

			String newWindow = iterator.next();

			if (!originalWindow.equalsIgnoreCase(newWindow)) {

				driver.switchTo().window(newWindow);

			}

		}

		WebElement email = getElement(locatorKey_email);
		email.sendKeys(id);// ("testerunited@123.com");
		WebElement element = getElement(locatorkey_nextbutton);
		element.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement msg = getElement(locatorKey_errormsg);
		msg.getText();

		System.out.println("Couldn't find your Google Account");

		driver.switchTo().window(originalWindow);

	}

}