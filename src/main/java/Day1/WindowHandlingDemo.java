package Day1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandlingDemo {

	private static WebDriver driver;

	@BeforeMethod()
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void windowTest() {
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main Window-->" + mainWindow);
		// For multiple window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> ilt = set.iterator();
		while (ilt.hasNext()) {
			String childWindow = ilt.next();
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("Child window title-->" + driver.switchTo().window(childWindow).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();
	}

}
