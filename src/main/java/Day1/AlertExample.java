package Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertExample {
	private static WebDriver driver;

	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
	}

	public void dismissAlert() {
		getAlert().dismiss();
	}
	public String alertText()
	{
		return getAlert().getText();
	}
	public void sendText(String text)
	{
		getAlert().sendKeys(text);
	}
	

}
