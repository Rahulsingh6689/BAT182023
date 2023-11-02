package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
  public WebDriver ldriver;//local driver
	
	public AddNewCustomerPage(WebDriver rdriver) { //Parameterized constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//which is used to initialize our web element
		}
	
	//Web elements
	//@FindBy(xpath="//input[@id='Email']")
	//WebElement txtEmail;
	
	//@FindBy(xpath="//a [@href='#']")//p[contains(text(), 'Customers')]
	//WebElement lnkCustomers_menu;

	By lnkCustomers_menu=By.xpath("//a [@href='#']");
	By lnkCustomers_menu_item=By.xpath("//p[text()=' Customers']");
	By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password'");
	//By btnlogin=By.xpath("//button[text()='Log in");
	By txtFirstName=By.xpath("//input[@id='SearchFirstName']");
	By txtLastName=By.xpath("//input[@id='SearchLastName']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	By txtDOB=By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName=By.xpath("//input[@id='Company']");
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("//button[@name='save']");
	
	@FindBy (xpath="//*[@id='VendorId']")
	WebElement dropdownVendorMgr;
	
	//User defined methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
		}
	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menu_item).click();
	}
	
	public void clickOAddNew() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void SetEmail(String Email) {
		ldriver.findElement(txtEmail).sendKeys(Email);;
	}
	public void SetPassword (String Password) {
		ldriver.findElement(txtEmail).sendKeys(Password);;
	}
	public void SetFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	public void SetLastName(String lname) {
		ldriver.findElement(txtFirstName).sendKeys(lname);
	}
	public void SetGender (String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();	
		}else {
			ldriver.findElement(rdFemaleGender).click();	
		}
	}
	public void enterdob(String dob) {
		ldriver.findElement(txtDOB).sendKeys(dob);
	}
	public void enterManagerOfVendor (String value) {
		Select drp=new Select (dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}
	
	public void SetCompanyName(String comName) {
		ldriver.findElement(txtCompanyName).sendKeys(comName);
	}
	public void SetAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
		public void clickOnSave() {
			ldriver.findElement(btnSave).click();
		
	}
	
	
}
	
	
	
	
	
	

