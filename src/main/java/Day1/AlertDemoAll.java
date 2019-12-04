package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertDemoAll {
	private static WebDriver driver;
	private Alert alert;
	private static  WebElement element;
	
	public void simpleAlert()
	{
		element=driver.findElement(By.xpath("//button[contains(text(),'Simple')]"));
		element.click();
		alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	public void confirmAlert()
	{
		element=driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		JavascriptExecutor jac=((JavascriptExecutor)driver);
		jac.executeScript("arguments[0].click()", element);
		alert=driver.switchTo().alert();
		String alerText=alert.getText();
		System.out.println(alerText);
		alert.accept();
	}
	public void promptText() throws InterruptedException
	{
		element=driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
		JavascriptExecutor jac=((JavascriptExecutor)driver);
		jac.executeScript("arguments[0].click()", element);
		alert=driver.switchTo().alert();
		String alertText=alert.getText();
		alert.sendKeys("Accept the alert");
		Thread.sleep(5000);
		alert.accept();
	}
	public static void main(String[] args) throws InterruptedException {
		AlertDemoAll all=new AlertDemoAll();
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		//all.simpleAlert();
		//all.confirmAlert();
		all.promptText();
	}

}
