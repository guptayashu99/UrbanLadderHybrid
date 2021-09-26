package com.urbanladder.pageobject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.FooterUI;
import com.urbanladder.utility.Logging;

public class Footer {
	
	FooterUI fu = new FooterUI();
	private static Boolean flag = null;
	
	public static boolean getAppStore(WebDriver driver) {
		flag = null;
		try {
			Actions a = new Actions(driver);
			WebElement appstore = ReusableMethods.getElement(driver, FooterUI.appstore);
			a.moveToElement(appstore).keyDown(Keys.CONTROL).click();
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> it = ids.iterator();
			String urban = it.next();
			String apple = it.next();
			driver.switchTo().window(apple);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(urban);
			flag = true;
			Logging.log("info", "Appstore has been Opened");
		}
		catch(Exception e) {
			Logging.log("error", "Could not Open App Store");
			flag = false;
		}
		
		return flag;
	}
	
	public static boolean getPlayStore(WebDriver driver) {
		flag = null;
		try {			
			Actions a = new Actions(driver);
			WebElement appstore = ReusableMethods.getElement(driver, FooterUI.playstore);
			a.moveToElement(appstore).keyDown(Keys.CONTROL).click();
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> it = ids.iterator();
			String urban = it.next();
			String google = it.next();
			driver.switchTo().window(google);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(urban);
			flag = true;
			Logging.log("info", "Playstore Opened");
		}
		catch(Exception e) {
			Logging.log("error", "Could not open PlayStore");
			flag = false;
		}
		
		return flag;
	}
	
	public static boolean verifyWebsites(WebDriver driver, By selector) throws InterruptedException {
		ReusableMethods.click(selector,driver);
		Thread.sleep(5000L);
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		Iterator<String> I1= s.iterator();

		while(I1.hasNext()){
			String child_window=I1.next();

		if(!parent.equals(child_window)){
			//driver.switchTo().window(child_window);
			String title = driver.switchTo().window(child_window).getTitle();
			System.out.println("Title is "+title);
			if(title.toLowerCase().contains("urban ladder") || title.toLowerCase().contains("sign in")) {
				System.out.println("Title contains urban ladder "+selector);
				return true;
			}
		}

		}
		//switch to the parent window
		driver.switchTo().window(parent);
		return false;
		
	}

}
