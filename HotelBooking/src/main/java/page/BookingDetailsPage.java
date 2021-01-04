package page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class BookingDetailsPage extends TestBase {

	// PageFactory

	@FindBy(id = "txtFirstName")
	WebElement firstname;

	@FindBy(id = "txtLastName")
	WebElement lastname;

	@FindBy(name = "Email")
	WebElement emailid;

	@FindBy(id = "txtPhone")
	WebElement phonenumber;

	@FindBy(xpath = "//td[contains(text(),'Address')]/following-sibling::td/textarea")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "persons")
	WebElement guestcount;

	@FindBy(id = "txtCardholderName")
	WebElement cardholdername;

	@FindBy(id = "txtDebit")
	WebElement cardno;

	@FindBy(name = "cvv")
	WebElement cvv;

	@FindBy(id = "txtMonth")
	WebElement expirymonth;

	@FindBy(name = "year")
	WebElement expiryyear;

	@FindBy(id = "btnPayment")
	WebElement bookingbtn;

	public Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	/**
	 * Initialize the object
	 */
	public BookingDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	
	//Action
	
	/** 
	 * To get the title of current page
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * To capture error message if any field in missing on booking details page
	 * @return
	 */
	public String validateErrormessage() {
		
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
         alert.accept();
		return alertMessage;
		
		
	}
  
	/**
	 * To enter the booking details on booking detail page
	 * @param userfn
	 * @param userln
	 * @param useremail
	 * @param mob
	 * @param useradd
	 * @param usercity
	 * @param userstate
	 * @param personcount
	 * @param holdername
	 * @param cardnumber
	 * @param cvvs
	 * @param month
	 * @param year
	 */
	public void bookingdetails(String userfn,String userln,String useremail,String mob,String useradd,String usercity,String userstate,String personcount,String holdername,String cardnumber,String cvvs,String month,String year) {
		firstname.sendKeys(userfn);	
		lastname.sendKeys(userln);
		emailid.sendKeys(useremail);
		phonenumber.sendKeys(mob);
		address.sendKeys(useradd);
		Select cityselect = new Select(city);
		cityselect.selectByVisibleText(usercity);
		Select stateselect = new Select(state);
		stateselect.selectByVisibleText(userstate);
		Select guestcounts= new Select(guestcount);
		guestcounts.selectByVisibleText(personcount);
		cardholdername.sendKeys(holdername);
		cardno.sendKeys(cardnumber);
		cvv.sendKeys(cvvs);
		expirymonth.sendKeys(month);
		expiryyear.sendKeys(year);
		
	}
	
	/**
	 *  To validate the format of email id 
	 * @param emailStr
	 * @return  true if format is correct otherwise false
	 */
	
	public boolean validateemailformat(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	
	/**
	 * To validate the format of contact number 
	 * @param mob
	 * @return true or false
	 */
	
	public boolean validatemobile(String mob) {
		
		//length of mobile number is less than 10 it return true
		if(mob.length() <10) {
			//Return error
			return true;
		}
		//contactnumber doesnot starts with 9 & 8,7 it return true otherwise return false
		if(!(mob.startsWith("9") || mob.startsWith("8") || mob.startsWith("7"))) {
			//Return error
			return true;
		}
		else
		{
		return false ;	
	}
		
		
	}
	
	
	
	
	/**
	 * click confirm Booking  button on Booking details page
	 */
public void clickbookingbtn() {
	bookingbtn.click();
}


	
	
}
