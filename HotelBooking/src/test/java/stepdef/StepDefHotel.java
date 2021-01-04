package stepdef;

import org.junit.Assert;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.BookingDetailsPage;
import page.BookingSucess;
import page.LoginPage;

public class StepDefHotel extends TestBase {
	LoginPage loginpage;
	BookingDetailsPage bookingpage;
	BookingSucess bookingsucess;

	// To Intialize the Object
	@Given("^User is already on login Page$")
	public void user_is_already_on_login_Page() throws Throwable {
		TestBase.intialize();
	}

	@Given("^Heading of login page is Hotel Booking Application$")
	public void heading_of_login_page_is_Hotel_Booking_Application() throws Throwable {
		loginpage = new LoginPage();
		String Header = loginpage.getPageTitle();
		// To check the header of Hotel Login Page
		Assert.assertEquals("Hotel Booking Application", Header);
	}

	@When("^user enter valid login id and password$")
	public void user_enter_valid_login_id_and_password() throws Throwable {

		loginpage.logincredentails(prop.getProperty("username"), prop.getProperty("password"));

	}

	@When("^click on loginbtn$")
	public void click_on_loginbtn() throws Throwable {
		loginpage.loginbtnclick();

	}

	@Then("^Booking Details screen appear\\.$")
	public void booking_Details_screen_appear() throws Throwable {
		bookingpage = new BookingDetailsPage();
		String bookingpagetitle = bookingpage.getPageTitle();

		// To validate the title of Booking details page
		Assert.assertEquals("Hotel Booking", bookingpagetitle);

	}

	@When("^user enter invalid credentails \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_invalid_credentails_and(String userid, String pwd) throws Throwable {
		loginpage.logincredentails(userid, pwd);
		loginpage.loginbtnclick();

		if (userid.length() == 0 & pwd.length() == 0) {
			// To check the error message if userid and password is blank
			Assert.assertEquals("* Please enter userName.", loginpage.validateuseridtext());

		} else if (userid.length() == 0 & pwd.length() != 0) {
			// To check the error message if user id is blank
			Assert.assertEquals("* Please enter userName.", loginpage.validateuseridtext());

		} else if (userid.length() != 0 & pwd.length() == 0) {
			// To check the error message if password is blank
			Assert.assertEquals("* Please enter password.", loginpage.validatepwdtext());

		}

		else if ((userid != "admin" || pwd != "admin")) {
			// To get the alert message
			String errormessage = loginpage.validatealert();
			// To check the error message if login id & password is different from admin
			Assert.assertEquals("Invalid login! Please try again!", errormessage);

		}

	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {

		// To validate the title of Hotel Booking Application .
		Assert.assertEquals("Hotel Booking Application", loginpage.getPageTitle());
	}

	@When("^user enter proper details \\.$")
	public void user_enter_proper_details() throws Throwable {

		bookingpage.bookingdetails(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("emailid"), prop.getProperty("contactno"), prop.getProperty("address"),
				prop.getProperty("city"), prop.getProperty("state"), prop.getProperty("guestcount"),
				prop.getProperty("holdername"), prop.getProperty("cardnumber"), prop.getProperty("cvv"),
				prop.getProperty("expirymonth"), prop.getProperty("expiryyear"));
		bookingpage.clickbookingbtn();
	}

	@Then("^Booking Sucessfull page appears\\.$")
	public void booking_Sucessfull_page_appears() throws Throwable {
		bookingsucess = new BookingSucess();
		String sucessfullpagetitle = bookingsucess.getPageTitle();
		String sucessmessage = bookingsucess.getsucessmessage();
		Assert.assertEquals("Payment Details", sucessfullpagetitle);
		Assert.assertEquals("Booking Completed!", sucessmessage);

	}

	@When("^user doesnot enter proper details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_doesnot_enter_proper_details_and_and_and_and_and_and_and_and_and_and_and_and(String fn, String ln,
			String email, String mob, String add, String city, String state, String guestcount, String holdername,
			String cardnumber, String cvv, String month, String year) throws Throwable {
		bookingpage.bookingdetails(fn, ln, email, mob, add, city, state, guestcount, holdername, cardnumber, cvv, month,
				year);
		bookingpage.clickbookingbtn();

		// checking FN
		if (fn.length() == 0) {

			// To check the error message if first name is blank
			Assert.assertEquals("Please fill the First Name", bookingpage.validateErrormessage());
		}

		else if (ln.length() == 0) {
			// To check the error message if last name is blank
			Assert.assertEquals("Please fill the Last Name", bookingpage.validateErrormessage());
		}

		else if (email.length() == 0) {
			// To check the error message if email id is blank
			Assert.assertEquals("Please fill the Email", bookingpage.validateErrormessage());

		}

		else if (!bookingpage.validateemailformat(email)) {
			// To check the error message if the format of email id is incorrect
			Assert.assertEquals("Please enter valid Email Id.", bookingpage.validateErrormessage());
		}

		else if (mob.length() == 0) {
			// To check the error message if the mobile field is blank
			Assert.assertEquals("Please fill the Mobile No.", bookingpage.validateErrormessage());
		}

		else if (bookingpage.validatemobile(mob)) {
			// To check the length or format of mobile number
			Assert.assertEquals("Please enter valid Contact no.", bookingpage.validateErrormessage());

		}

		else if (guestcount.length() == 0) {
			// To check the guest count field
			Assert.assertEquals("Please fill the Number of people attending", bookingpage.validateErrormessage());
		} else if (city.equalsIgnoreCase("Select City")) {
			// To check the error message if city is not provided
			Assert.assertEquals("Please select city", bookingpage.validateErrormessage());
		}

		else if (state.equalsIgnoreCase("Select State")) {
			// To check the error message if state is not provided
			Assert.assertEquals("Please select state", bookingpage.validateErrormessage());
		} else if (holdername.length() == 0) {
			// To check the error message if card holder name is not provided
			Assert.assertEquals("Please fill the Card holder name", bookingpage.validateErrormessage());
		} else if (cardnumber.length() == 0) {
			// To check the error message if the card number is not provided
			Assert.assertEquals("Please fill the Debit card Number", bookingpage.validateErrormessage());
		} else if (cvv.length() == 0) {

			// To check the error message if CVV is blank
			Assert.assertEquals("Please fill the CVV", bookingpage.validateErrormessage());

		} else if (month.length() == 0) {

			// To check the error message expiry month is blank
			Assert.assertEquals("Please fill expiration month", bookingpage.validateErrormessage());

		} else if (year.length() == 0) {

			// To check the error message expiry year is blank
			Assert.assertEquals("Please fill the expiration year", bookingpage.validateErrormessage());

		}
	}

	@Then("^user is on Booking details screen\\.$")
	public void user_is_on_Booking_details_screen() throws Throwable {

		// To validate if the user is on Hotel Booking Page
		Assert.assertEquals("Hotel Booking", bookingpage.getPageTitle());
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
}
