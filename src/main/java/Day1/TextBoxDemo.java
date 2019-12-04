package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBoxDemo {
	private static WebDriver driver;
	private static WebElement text1,text2;
	//private static String res1,res2;
	static String url="http://www.newtours.demoaut.com/";

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		text1=driver.findElement(By.name("userName"));
		text1.sendKeys("ramana");
		text2=driver.findElement(By.name("password"));
		text2.sendKeys("ramana");
		System.out.println(text1.getAttribute("value"));
		System.out.println(text2.getAttribute("value"));
		System.out.println(text1.getTagName());
		System.out.println(text1.getClass());
		

	}

}
