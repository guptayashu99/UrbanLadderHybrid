package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class FooterUI {
	public static By facebook = By.xpath("//a[@href='https://facebook.com/urbanladder']");
	
	public static By twitter = By.xpath("//a[@href='https://twitter.com/UrbanLadder']");
	
	public static By pintrest = By.xpath("//a[@href='https://www.pinterest.com/urbanladder']");
	
	public static By youtube = By.xpath("//a[@href='https://youtube.com/user/urbanladder']");
	
	public static By instagram = By.xpath("//a[@href='https://instagram.com/urbanladder']");
	
	public static By linkedin = By.xpath("//a[@href='https://in.linkedin.com/company/urban-ladder']");
	
	public static By appstore = By.xpath("//a[@href='https://itunes.apple.com/us/app/urban-ladder/id959886087']");
		public static By apptitle = By.cssSelector(("h1.product-header__title.app-header__title"));
	
	public static By playstore = By.xpath("//a[@href='https://play.google.com/store/apps/details?id=com.urbanladder.catalog']");
		public static By playtitle = By.cssSelector("h1.AHFaub");
	
	
}
