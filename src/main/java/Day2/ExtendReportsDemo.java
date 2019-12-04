package Day2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ExtendReportsDemo {
	static ExtentReports report;
	static ExtentTest test;
	static WebDriver driver;
	
	@BeforeClass
	public static void startTest()
	{
		System.out.println(System.getProperty("user.dir"));
		report = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentResult.html");
		test=report.startTest("ExtentDemo");
	}
	@Test
	public void extentReportDemo()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.google.com/");
		if(driver.getTitle().equals("Google"))
		{
			test.log(LogStatus.PASS, "Navigate to the specified URL");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}

}
