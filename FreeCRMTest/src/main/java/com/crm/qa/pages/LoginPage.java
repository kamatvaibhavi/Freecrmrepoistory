package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//we have to define page factory or object repository:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
	WebElement SignUpBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
    WebElement 	crmlogo;
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
		//driver:wch driver should be used to open the site wch inherits from parent class i.e base class
		//this:takes currennt class or u can write LoginPage.class
	}
	
	//Actions
	public String validateLoginPage()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();	//returns boolean	
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
}
