package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	// PageFactory

	@FindBy(xpath = "//h1[contains(text(),'Hotel Booking Application')]")
	WebElement title;

	@FindBy(id = "userErrMsg")
	WebElement usererrormessage;

	@FindBy(name = "userName")
	WebElement username;

	@FindBy(name = "userPwd")
	WebElement password;

	@FindBy(id = "pwdErrMsg")
	WebElement pwderrormessage;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	/**
	 * Initialize the object
	 */

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Action

	/**
	 * To get the title of Page
	 * 
	 * @return tile of page
	 */
	public String getPageTitle() {
		return title.getText();
	}

	/**
	 * To capture error message for userid
	 * 
	 * @return string
	 */
	public String validateuseridtext() {
		return usererrormessage.getText();
	}

	/**
	 * To capture error message for password
	 * 
	 * @return string
	 */
	public String validatepwdtext() {
		return pwderrormessage.getText();
	}

	/**
	 * To enter login loginid and password on Hotel login page
	 * 
	 * @param login
	 * @param passwords
	 */

	public void logincredentails(String login, String passwords) {
		username.sendKeys(login);
		password.sendKeys(passwords);
	}

	/**
	 * To capture alert if invalid credentials are entered
	 * 
	 * @return
	 */
	public String validatealert() {
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		alert.accept();
		return alertMessage;

	}

	/**
	 * click login button on hotel login page
	 */
	public void loginbtnclick() {
		loginbtn.click();

	}

}
