package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

    TestUtil testutil;
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	@CacheLookup
	WebElement userNameLable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
    WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	//Initializing the page objects
		public HomePage()
		{
			PageFactory.initElements(driver,this);
		}
		
		public String verifyHomePageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName()
		{
			
			return userNameLable.isDisplayed();
			
		}
		public ContactsPage clickOnContactsPage()
		{
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsPage()
		{
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksPage()
		{
			tasksLink.click();
			return new TasksPage();
		}
		
		public void clickOnNewContact()
		{
			//action used to perform mousehover,drag and drop,right click etc
			Actions action=new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactsLink.click();		
			
		}
		
}
