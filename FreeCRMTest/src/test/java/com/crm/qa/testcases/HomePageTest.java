package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;//ctrl+shft+o(to import the package)
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest()
	{
		super();
		//called becoz before initialization all the details and system properies are present in base class of it 
	}
	//test cases should be separated --independent with each other (avoid dependency btween 2 test cases) 
	//before each test case launch the browser and login
	//@test---execute test case
	//after each test case--close the browser
	
	
	@BeforeMethod
	public void setUp()
	{
		 initialization();
		 testutil=new TestUtil();
		 contactspage=new ContactsPage();
		 loginpage=new LoginPage();
		 homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home Page Title Not Matching"); 
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsPage();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
