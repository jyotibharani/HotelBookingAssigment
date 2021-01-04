package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

import cucumber.api.CucumberOptions;
import com.cucumber.listener.Reporter;

@RunWith(ExtendedCucumber.class) 

@CucumberOptions(
		features="src//main//resources//feature",
		//features="src//main//resources//feature//HotelBookingloginFeature.feature",
		glue= {"stepdef"},
		dryRun=false,
		strict=true,
		monochrome=true,
		plugin= {"pretty",
				//"usuage:target//cucumber-reports",
				"html:target//html-reports//",
				//"json:target//json-reports",
				//"junit:target//junit-reports//cucumber.xml"
				"com.cucumber.listener.ExtentCucumberFormatter:target/html-reports/ExtentReport.html"
				
				}
		
		)
public class RunnerHotelBooking {
	@AfterClass
	public static void writeExtentReport()
	{
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone",System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Application Name","Sample Test App");
		Reporter.setSystemInfo("OS",System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment","Testing Server");



	}
}
