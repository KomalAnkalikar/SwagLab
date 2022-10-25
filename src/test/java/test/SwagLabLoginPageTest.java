package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import utility.ExtentReport;
import utility.Parameterization;
import utility.SwagPageElements;

@Listeners(utility.Listeners.class)

public class SwagLabLoginPageTest extends SwagPageElements{
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void createReports()
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
		return new Object[] [] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"}};
	}
	
	@Test (dataProvider = "UserCredentails")
	public void validateSwagLogin(String userName, String Password) throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = reports.createTest("validateSwagLogin");
		
		SwagLabLoginPage swagLoginPage = new SwagLabLoginPage(driver);
		
		swagLoginPage.enterUserName(userName);
		swagLoginPage.enterPassword(Password);
		Thread.sleep(2000);
		swagLoginPage.clickOnLogin();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
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
