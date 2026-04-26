package testNGPrac;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class MultiBrowser {
	
	WebDriver driver ;
	
@Parameters("browserName")
@BeforeTest
 
 public void setup(String browser) {
	 
	 if(browser.equalsIgnoreCase("Chrome")) {
		 
		 driver = new ChromeDriver();
	 }
	 else if (browser.equalsIgnoreCase("safari")) {
		 
		 driver = new SafariDriver();
		 
	 }
	 else if (browser.equalsIgnoreCase("FireFox")) {
		 
		 driver = new FirefoxDriver();
	 }
 }
	
  @Test(enabled=false)
  public void url() {
	  
	  
	  driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
	  
	  driver.manage().window().maximize();
	  
	  WebElement city =   driver.findElement((By.xpath("//select[@name='state']")));
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  Select sl = new Select(city);
	  
	  
	  
	  List<WebElement> cs = sl.getOptions();
	  
	  for(WebElement ch:cs) {
		  
		 System.out.println(ch.getText()); 
	  }
	  
  }
  
  @Test(enabled=true, dataProvider ="dp")
  public void practice(String user, String value ) {
	  
	  driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
	  
	  WebElement id = driver.findElement(By.id(""));
	  
	  WebElement pwd = driver.findElement(By.id(""));
	  
	  id.sendKeys(user);
	  pwd.sendKeys(value);
	  
  }
  
  @DataProvider(name="dp")
  public Object[][] userlogin() {
	  
	  return new Object[][]{
		  
		  {"vaib" ,"122"}
			  
		  };
  
	  
	  
  }
  
  @Test
  
  public void prac() throws IOException {
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  
	  js.executeScript("window.scrollBy(0,50);");
	  
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  
	File src =   ts.getScreenshotAs(OutputType.FILE);
	
	String path = "tc + timestamp";
	
	File dest = new File(path);
	
	FileUtils.copyFile(src, dest);
	 
	List<WebElement> link = driver.findElements(By.tagName("a"));
	
	for( WebElement url:link) {
		
		System.out.println(url.getAttribute("href"));
		
	}
	
	
	String s = "ABCDEFGHI";
	
	   char a[] =  s.toCharArray();
	   
	   ArrayList<Character> al = new ArrayList<Character>();
	   
	   for(char ch:a) {
		   
		   al.add(ch);
	   }
	   
	   al.add(9, 'j');
	 
	   System.out.println(al);
	   
	  WebElement user =  driver.findElement(By.xpath("//*[contains(@id,'value')]"));
	  
	  user.click();
	  
	  user.sendKeys("");
	  
	  
	   
	   Alert alt = driver.switchTo().alert();
	   
	   alt.accept();
	   
	   alt.getText();
	   
	   ChromeOptions option = new ChromeOptions();
	   
	   option.addArguments("--disable-Notifications");
	   
	   WebDriver driver = new ChromeDriver();
	   
	   
	   
	   
	   
	   
  }
  
  
  
}
