package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public WebDriver driver;
	public void SelectByVisibleText(WebElement element, String text) {
		
		Select select1=new Select(element);
		select1.selectByVisibleText(text);
		
	}
	
	public void SelectByDrop(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
}
