package stepdefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefinition extends Base {
	
	//@Before will execute before every scenario
	@Before
	public void setUp() throws Exception {
		//Create object of Read config file
		System.err.println("SetUp method execution");
		
		readConfig=new ReadConfig();//create object of ReadConfig java class
		System.setProperty("webdriver.chrome.driver","D:\\Automation Training_Software\\chromedriver-win32\\chromedriver.exe");
		String browser=readConfig.getbrowser();//value=chrome
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
		}else if(browser.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}
	
	
	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() throws Exception {
		
		
		//System.setProperty("webdriver.chrome.driver","D:\\Automation Training_Software\\chromedriver-win32\\chromedriver.exe");
		//driver= new ChromeDriver();//already declared with base class
		
		//Create object of AdminPage java class
		ad=new AdminPage(driver); //Parameterized constructor already declared with Base class
	    Thread.sleep(2000);
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
		driver.get(url);
		 Thread.sleep(2000);
	}

	@When("User enter emaail as {string} and password as {string}")
	public void user_enter_emaail_as_and_password_as(String emaail, String password) throws Exception {
		ad.SetUsername(emaail);
		 Thread.sleep(2000);
		ad.SetPassword(password);
		 Thread.sleep(2000);
	   
		
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
		ad.ClickonLogin();
		 Thread.sleep(2000);
	   
	}
	

	@Then("Close browser")
	public void close_browser() throws Exception {
		driver.close();
		 Thread.sleep(2000);
	    
	}
	
	//Add new customer coding snippet
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		addCust=new AddNewCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
				Thread.sleep(2000);
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws Exception {
		addCust.clickOnCustomersMenu();
		Thread.sleep(2000);
	    
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() throws InterruptedException {
		addCust.clickOnCustomersMenuItem();
		Thread.sleep(2000);
	   
	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() throws Exception {
		addCust.clickOAddNew();
		Thread.sleep(2000);
	    
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws Exception {
		Thread.sleep(2000);
		Assert.assertEquals("Add a new customer / nop commerce administration", addCust.getPageTitle());
	    
	}
	@When("User enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String string, String string2, String string3, String string4, String string5, String string6, String string7) throws Exception  {
	addCust.SetEmail(newEmail);
	addCust.SetPassword(newPassword);
	addCust.SetFirstName(fname);
	addCust.SetLastName(lname);
	addCust.SetGender(gender);
	//enterdob("6/13/1998");
	//addCust.enterManagerOfVendor("Vendor 1");
	addCust.SetCompanyName(compName);
	addCust.SetAdminContent(adminComment);
	Thread.sleep(2000);
		
	}

	@When("User click on save button")
	public void user_click_on_save_button() {
		addCust.clickOnSave();
	   
	}

	@Then("User can view customer info msg {string}")
	public void user_can_view_customer_info_msg(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().
				Thread.sleep(2000);
	}

	
	
	
	@After
	public void tearDown(Scenario sc) throws Exception {
		System.out.println("Tear down method execute after each test case scenario");
		if (sc.isFailed()==true){
		String filewithpath="D:\\Automation Testing\\eclipse-workspace\\18OctCucumberMavenProject\\screenshot\\failedScreenshot.png";
	
		//Convert WebDriver object into screenshot
		
		TakesScreenshot scrshot=((TakesScreenshot)driver);
		
		//Call getscreenshotAs() to store image file
		
		File scrFile=scrshot.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File(filewithpath);
		FileUtils.copyFile(scrFile, destFile);
		}
		Thread.sleep(2000);
		driver.quit();
		
		}
		
	}
