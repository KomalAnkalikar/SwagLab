package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabProductPage {
	
	@FindBy (xpath ="//input[@id='user-name']")private WebElement username;
	@FindBy (xpath ="//input[@id='password']")private WebElement password;
	@FindBy (xpath ="//input[@id='login-button']")private WebElement login;
	@FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement addToCart;
	@FindBy (xpath = "//button[@id='remove-sauce-labs-backpack']")private WebElement remove;
	@FindBy (xpath = "//a[@class='shopping_cart_link']")private WebElement shoppingCart;
	@FindBy (xpath = "//button[@id='checkout']")private WebElement checkOut;
	@FindBy (xpath = "//button[@id='continue-shopping']")private WebElement continueShopping;
	@FindBy (xpath = "//input[@id='first-name']")private WebElement firstName;
	@FindBy (xpath = "//input[@id='last-name']")private WebElement lastName;
	@FindBy (xpath = "//input[@id='postal-code']")private WebElement postalCode;
	@FindBy (xpath = "//input[@id='continue']")private WebElement continue1;
	@FindBy (xpath = "//button[@id='finish']")private WebElement finish;
	@FindBy (xpath = "//button[@id='cancel']")private WebElement cancel;
	@FindBy (xpath = "//h2[text()=\"THANK YOU FOR YOUR ORDER\"]")private WebElement text;
	
	public SwagLabProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name)
	{
		username.sendKeys(name);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnaddToCart()
	{
		addToCart.click();
	}
	
	public String txtRemove()
	{
		return remove.getText();
	}
	
	public void clickOnRemove()
	{
		remove.click();
	}
	
	public void clickshoppingCart()
	{
		shoppingCart.click();
	}	
	
	public void clickOncheckOut()
	{
		checkOut.click();
	}
	
	public void clickOncontShopping()
	{
		continueShopping.click();
	}
	
	public void enterFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void enterPostalCode(String postCode)
	{
		postalCode.sendKeys(postCode);
	}
	
	public void clickOnContinue()
	{
		continue1.click();
	}
	
	public void clickOnCancel()
	{
		cancel.click();
	}
	public void clickOnFinish()
	{
		finish.click();
	}
	
	public String getText()
	{
		return text.getText();
	}
}
