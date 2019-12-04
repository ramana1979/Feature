package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyPageTitle {
	private static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver=new FirefoxDriver();
		String url="http://www.newtours.demoaut.com/";
		String expTitle="Welcome: Mercury Tours";
		String actTitle="";
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		actTitle=driver.getTitle();
		if(actTitle.contentEquals(expTitle))
		{
			System.out.println("Test is passed");
		}
		else
		{
			System.out.println("Test is failed.");
		}
		driver.close();
		
	}

}
