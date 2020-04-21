package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public String sheetName="contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		 initialization();
		 testutil=new TestUtil();
		 contactspage=new ContactsPage();
		 loginpage=new LoginPage();
		 homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		 testutil.switchToFrame();
		 contactspage=homepage.clickOnContactsPage();
		 
	}
	
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactspage.verifyContactsLable(),"contacts label is missing on the page");	
	}
	
	@Test(priority=2)
	public void selectsingleContactsTest()
	{
		contactspage.selectContactsByName("Betty Jones");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		contactspage.selectContactsByName("Betty Jones");
		contactspage.selectContactsByName("Bruce Wayne");		
	}
	

	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homepage.clickOnNewContact();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactspage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
