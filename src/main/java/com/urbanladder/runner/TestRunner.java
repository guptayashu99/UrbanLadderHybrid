package com.urbanladder.runner;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.urbanladder.pageobject.CheckoutPage;
import com.urbanladder.pageobject.Footer;
import com.urbanladder.pageobject.GiftCardsPage;
import com.urbanladder.pageobject.Header;
import com.urbanladder.pageobject.LoginPage;
import com.urbanladder.pageobject.ProductPage;
import com.urbanladder.pageobject.SearchPage;
import com.urbanladder.pageobject.SignUpPage;
import com.urbanladder.pageobject.StorePage;
import com.urbanladder.reusablecomponent.ReusableComponents;
import com.urbanladder.runner.TestRunner;
import com.urbanladder.uistore.FooterUI;
import com.urbanladder.utility.ExcelReader;
import com.urbanladder.utility.ExtentReportGenerator;
import com.urbanladder.utility.Logging;
import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.utility.OpenReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestRunner extends ReusableComponents{

	ExtentReports reporter;
	static ExtentTest test;
	public static Logger log =  (Logger) LogManager.getLogger(TestRunner.class.getName());
	Header h = new Header();
	WebDriver driver; 
	Boolean flag = null;

	public TestRunner() throws IOException {
		super();
		driver = ReusableComponents.initializeDriver();

	}
	
	//Initialize Extent Reports and Logger
	@BeforeSuite
	public void suiteSetUp() {
		reporter = ExtentReportGenerator.generateReport();
		Logging.log("info", "Setup Complete");
	}
	
	//Initialize the WebDriver and open the URL
	@BeforeTest
	public void homePage() throws IOException {
		driver.manage().window().maximize();
		ReusableMethods.getURL(driver);
		test = reporter.createTest("Sign Up and Login");
	}
	

	//Sign Up
	@Test(priority = 0)
	public void signUp() throws IOException {
		flag = Header.getWishList(driver);
		flag = SignUpPage.getSignUp(driver);
		
	}
	
	//Login
	@Test(priority = 1)
	public void login() throws IOException {
		flag = SignUpPage.clickLogin(driver);
		flag = LoginPage.getLogin(driver);
		flag = Header.getHomePage(driver);
	}


	//HEADER TESTS
		//Help Button Test
	@Test(priority = 3)
	public void help() {
		test = reporter.createTest("Header Test");
		flag = Header.getHelp(driver);
		Assert.assertTrue(flag);
	}
	
		//Sale Test
	@Test(priority = 5)
	public void sale() {
		flag = Header.getSale(driver);
		Assert.assertTrue(flag);
	}
	
		//Living Test
	@Test(priority = 6)
	public void living() {
		flag = Header.getLiving(driver);
		//Assert.assertTrue(flag);
	}
	
		//Bedroom Test
	@Test(priority = 7)
	public void bedroom() {
		flag = Header.getBedroom(driver);
		//Assert.assertTrue(flag);
	}
	
	//Search Box Test
	@Test(priority = 9, dataProvider="searchData")
	public void searchProduct(String product) {
		test = reporter.createTest("Search Box Test");
		flag = SearchPage.search(driver, product);
		flag = Header.getHomePage(driver);
		Assert.assertTrue(flag);
	}
	
	//Select Product from Search Page
	@Test(priority = 11)
	public void selectProduct() {
		flag = SearchPage.search(driver, "Sofa");
		flag = SearchPage.getProduct(driver);
		
	}
	
		//Product Page Test
	@Test(priority = 13)
	public void addToCart() throws IOException {
		flag = ProductPage.getProductName(driver);
		flag = ProductPage.getPrice(driver);
		flag = ProductPage.getPincode(driver);
		flag = ProductPage.getDeliveryDate(driver);
		flag = ProductPage.getAddToCart(driver);
	}
	
	//Checkout
	@Test(priority = 15)
	public void checkout() throws IOException {
		flag = CheckoutPage.getClickCheckout(driver);
		flag = CheckoutPage.getDetails(driver);
		flag = CheckoutPage.getSave(driver);
	}
	
	@Test(priority = 17)
	public void stores() throws IOException {
		flag = CheckoutPage.getHome(driver);
		flag = Header.getStoreButton(driver);
		flag = StorePage.getStores(driver);
		flag = StorePage.getStoreAddress(driver);
	}
	
	@Test(priority = 19)
	public void giftCards() {
		flag = Header.getGiftButton(driver);
		flag = GiftCardsPage.verifyTitle(driver);
	}
	
//	@Test(priority = 21)
//	public void applink() {
//		flag = Footer.getAppStore(driver);
//		flag = Footer.getPlayStore(driver);
//	}
	
//	@Test(priority = 23, dataProvider="websiteNames")
//	public void socialMedia(By locator) throws InterruptedException {
//		flag = Footer.verifyWebsites(driver, locator);
//	}
	
	
	@AfterMethod
	public static void getResult(ITestResult result) throws InterruptedException {
	if (result.getStatus() == ITestResult.FAILURE) {
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +  "Test case FAILED due to below issues:",
	ExtentColor.RED));
	test.fail(result.getThrowable());
	} else if (result.getStatus() == ITestResult.SUCCESS) {
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName() +  "Test Case PASSED", ExtentColor.GREEN));
	} else {
	test.log(Status.SKIP,
	MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
	test.skip(result.getThrowable());
	}
	}
	
	@AfterSuite
	public void endSuite() throws InterruptedException, IOException {
		reporter.flush();
//		String report = OpenReport.openReport().getCanonicalPath();
//		System.out.println(report);
//		ReusableComponents.initializeDriver();
//		driver.get(report);
	}
	
	//DATA PROVIDERS
	@DataProvider
	public Object searchData() throws IOException {
		ArrayList<String> searches = new ArrayList<String>();
		searches = ExcelReader.getExcelData("TestData","Search");
		
		int size = searches.size();
		//System.out.println(size);
		Object[][] data = new Object[size][1];
		for (int i = 0; i < size; i++) {
			data[i][0] = searches.get(i);
		}
		return data;
	}
	
	@DataProvider
	public Object websiteNames() throws IOException {
		Object[][] data = new Object[6][1];
			data[0][0] = FooterUI.facebook;
			data[1][0] = FooterUI.instagram;
			data[2][0] = FooterUI.pintrest;
			data[3][0] = FooterUI.twitter;
			data[4][0] = FooterUI.youtube;
			data[5][0] = FooterUI.linkedin;
		return data;
	}	
}
