package testNGPrac;

import java.net.MalformedURLException;
import java.net.URL;

import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BrowserPrac {
	
	WebDriver driver;
	
  @Test
  public void launch() throws MalformedURLException {
	  
	  driver = new ChromeDriver();
	  
	  URL url = new URL("https://jsonpathfinder.com/");
	  
	  driver.navigate().to(url);
	  
	  
	  driver.navigate().back();
	  
	  WebElement login = driver.findElement(By.cssSelector("['']"));
	  
	  Actions act = new Actions(driver);
	  
	  Action dd = act.moveToElement(login).click().build();
	  
	  dd.perform();
  }
  
}
