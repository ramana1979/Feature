package Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertDemo {
private static WebDriver driver;
static String url="http://demo.guru99.com/test/delete_customer.php";
	@BeforeMethod()
	public void setup()
	{
		Reporter.log("Before method started");
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	@Test
	public void alertTest() throws InterruptedException
	{
		Reporter.log("Test method started");
		driver.get(url);
		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).click();
		Alert alert=driver.switchTo().alert();
		
		if(!alert.equals(true))
		{
			System.out.println("Alert is present");
		}
		else
		{
			System.out.println("Alert not present");
		}
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.accept();
	}
	@AfterMethod()
	public void exit()
	{
		Reporter.log("After method started");
		driver.close();
	}

}
