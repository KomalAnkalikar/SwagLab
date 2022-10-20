package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
		public static WebDriver openChromeBrowser() {
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			return driver;
		}
}
