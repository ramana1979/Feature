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

public class ActionsWithMouse {
	private static WebDriver driver;
	private static WebElement element;

	@BeforeMethod()
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	@Test(priority=0)
	public void actionTest() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Actions act=new Actions(driver);
		element=driver.findElement(By.name("q"));
		Action action=act.moveToElement(element).sendKeys("Java tutorial").build();
		action.perform();
		
	}
	@Test(priority=1)
	public void actionTest1()
	{
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Actions act=new Actions(driver);
		element=driver.findElement(By.name("q"));
		Action action=act.moveToElement(element).click()
				.keyDown(element,Keys.SHIFT)
				.sendKeys(element, "hello")
				.keyUp(element, Keys.SHIFT)
				.doubleClick(element)
				.contextClick()
				.build();
		action.perform();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}