package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	WebDriver ldriver;//local driver
	
	public AdminPage(WebDriver rdriver) { //Parameterized constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//which is used to initialize our web element
	}
	
	//Java Project
	//WebElement TxtEmail=driver.findElement(By.xpath("//input[@id='Email']"));
	
	//Maven Project
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement btnlogin;
	
	//user defined method to perform operation on above web element
	
	public void SetUsername(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
		
	}
	
	public void SetPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickonLogin() {
		btnlogin.click();
		
	  }
	
	}
	
	
	
