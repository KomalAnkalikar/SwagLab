package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import pom.SwagLabProductPage;
import utility.ExtentReport;
import utility.SwagPageElements;

@Listeners(utility.Listeners.class)
public class SwagLabProductPageTest extends SwagPageElements {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void createReport()
	{
		reports = ExtentReport.getReports();
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.openChromeBrowser();
	}
	
	@DataProvider (name="UserCredentails")
	public Object[] [] userData()
	{
		return new Object[] [] {{"standard_user","secret_sauce"}};
	}
	
	@Test (dataProvider = "UserCredentails")
	public void validateSwagProduct(String userName, String Password) throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = reports.createTest("validateSwagProduct");
		
		SwagLabProductPage swagProductPage = new SwagLabProductPage(driver);
		
		swagProductPage.enterUserName(userName);
		swagProductPage.enterPassword(Password);
		Thread.sleep(5000);
		swagProductPage.clickOnLogin();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		
		
//		swagProductPage.clickshoppingCart();
//		Thread.sleep(5000);
//		swagProductPage.clickOncheckOut();
//		swagProductPage.enterFirstName("Komal");
//		swagProductPage.enterLastName("kajsak");
//		swagProductPage.enterPostalCode("123567");
//		Thread.sleep(5000);
//		swagProductPage.clickOnContinue();
//		swagProductPage.clickOnFinish();
//		
//		String expectedText = "THANK YOU FOR YOUR ORDER";
//		String actualText = swagProductPage.getText();
//		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test (dataProvider = "UserCredentails")
	public void addToCart(String userName, String Password) throws InterruptedException
	{
		test = reports.createTest("validateSwagProduct");
		SwagLabProductPage swagProductPage = new SwagLabProductPage(driver);
		swagProductPage.enterUserName(userName);
		swagProductPage.enterPassword(Password);
		Thread.sleep(5000);
		swagProductPage.clickOnLogin();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		swagProductPage.clickOnaddToCart();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	  public void captureResults(ITestResult result)
		{
			if(result.getStatus() == ITestResult.SUCCESS)
			{
				test.log(Status.PASS, result.getName());
			}
			else if(result.getStatus() == ITestResult.FAILURE)
			{
				test.log(Status.FAIL, result.getName());
			}
			else
			{
				test.log(Status.SKIP, result.getName());
			}
		}
	
	  @AfterTest
	  public void flushResults()
	  {
		  reports.flush();
	  }

}
