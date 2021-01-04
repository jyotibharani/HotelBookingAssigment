package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BookingSucess extends TestBase{
	// PageFactory

		@FindBy(xpath = "//h1[contains(text(),'Booking Completed!')]")
		WebElement sucessfullmessage;
		public BookingSucess() {
			PageFactory.initElements(driver, this);
		}
        
		/**
		 * To get the title of page
		 * @return
		 */
		
		public String getPageTitle() {
			return driver.getTitle();
		}
		
		/** To get the content of message on booking successful page 
		 * 
		 * @return
		 */
		public String getsucessmessage() {
			 return sucessfullmessage.getText();
		}
}
