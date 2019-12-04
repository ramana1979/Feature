package Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsWithKeyboard {
	private static WebDriver driver;
	private static WebElement element;
	@BeforeMethod()
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	@Test
	public void actionTest() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Actions act=new Actions(driver);
		element=driver.findElement(By.name("q"));
		act.keyDown(element, Keys.SHIFT);
		act.sendKeys("Text to be Uppercae");
		Thread.sleep(5000);
		act.keyUp(element, Keys.SHIFT);
		Action action=act.build();
		action.perform();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
