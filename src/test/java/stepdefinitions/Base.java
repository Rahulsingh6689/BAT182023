package stepdefinitions;

import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class Base {
	
	//Access modifier
	public WebDriver driver; //reference of driver in a base class
	
	public AdminPage ad;
	
	public ReadConfig readConfig;
	public AddNewCustomerPage addCust;
	
}
