package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingWindowsDemo {
	private static WebDriver driver;
	private static WebElement element;
	public void MultiWindows() throws InterruptedException
	{
		element=driver.findElement(By.id("button1"));
		for(int i=0;i<3;i++)
		{
			element.click();
			Thread.sleep(5000);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		HandlingWindowsDemo hand=new HandlingWindowsDemo();
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		hand.MultiWindows();
		//driver.close();

	}

}
