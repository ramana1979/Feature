/*
 * Alert example demo session for practice
 */
package Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertExample {
	private static WebDriver driver;

	public Alert getAlert() {
		return driver.switchTo().alert();
	}
/*
 * Accept the alert 
 */
	public void acceptAlert() {
		getAlert().accept();
	}
//Dismiss the alert
	public void dismissAlert() {
		getAlert().dismiss();
	}
	//return alert string 
	public String alertText()
	{
		return getAlert().getText();
	}
	public void sendText(String text)
	{
		getAlert().sendKeys(text);
	}
	

}
