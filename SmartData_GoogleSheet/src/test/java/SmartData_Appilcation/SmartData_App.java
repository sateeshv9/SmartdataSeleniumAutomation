package SmartData_Appilcation;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.Test;


import Object_Repository.SmartData_Object;
import SmartData_GoogleSheet.TestGoogleSheet;
import SmartData_Utilities.TakeScreenshot;

import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class SmartData_App extends SmartData_Object
{
	WebDriver driver;
	ExtentReports extent;
	 ExtentTest logger;
	 ExtentHtmlReporter htmlReporter;
	 String htmlReportPath = "D:\\Selenium_Automation\\Smart_ticket\\SmartTicket_GoogleSheet\\test-output\\testReport.html";
	 TakeScreenshot TS = new TakeScreenshot();
	 String PageName =null;
	 String PageURL = null;
	@BeforeSuite
	public void Driver_Int()
	{
		 htmlReporter = new ExtentHtmlReporter(htmlReportPath);
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Automation\\Smart_ticket\\smartticketupgrade\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void SmartData_ContactUs() throws  Exception 
	{
		driver.get(url); 
		Thread.sleep(2000);
		
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(ContactUs).click();
		Thread.sleep(2000);
		
		List<List<Object>> values =TestGoogleSheet.GetContactUs();
		  if (values == null || values.isEmpty()) {
				System.out.println("No data found.");
			} else {
				for (List row : values) {
					 PageURL =driver.getCurrentUrl();
				        if (PageURL.contains(contactus_url)) {
				        	PageName=driver.findElement(ContactusEle).getText();
				        	if(PageName.contains(Contact_Us)) {
				        		driver.switchTo().frame(FrameID_contactus);		
      					driver.findElement(Email).sendKeys(row.get(0).toString());
      					Thread.sleep(2000);
      					driver.findElement(FirstName).sendKeys(row.get(1).toString());
      					Thread.sleep(2000);
      					driver.findElement(LastName).sendKeys(row.get(2).toString());
      					Thread.sleep(2000);
      					driver.findElement(Message).sendKeys(row.get(3).toString());
      					Thread.sleep(2000);
      					JavascriptExecutor js = (JavascriptExecutor) driver;
      			        js.executeScript("window.scrollBy(0,1000)");
      			        driver.switchTo().parentFrame();
      			        driver.findElement(Cincinnati).click();
      			        Thread.sleep(2000);
      			        driver.findElement(Louisville).click();
      			        Thread.sleep(2000);
      			        driver.findElement(Hyderabad).click();
      			        Thread.sleep(2000);
      				}
      			}
        	}
        }
		
	}
	@Test(priority=1)
	public void smartData_AboutUs()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(AboutUs).click();
		Thread.sleep(2000);
		
	}
	
	@AfterSuite
	public void Driver_Close()
	{
		driver.quit();
	}
}
