//My modification
package SeleniumFirstProject.SeleniumWDFirstProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ImmutableBiMap.Builder;

import Library.Utility;
import junit.framework.Assert;

public class TestNGConcept {
	WebDriver d;
	ExtentHtmlReporter reporter; 
	ExtentReports extent;
	ExtentTest logger;
	@BeforeMethod
	public void setup(){
		reporter = new ExtentHtmlReporter("./Report/MyFirstReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger=extent.createTest("GetTitle Test");
		
	}
	@Test
	public void login() throws IOException{
		System.setProperty("webdriver.chrome.driver", "D://Software//ChromeDriverSelenium//chromedriver.exe");
		d= new ChromeDriver();
		d.get("http://www.google.com");
		String firstScreenshot=Utility.captureScreenshot(d);
		d.findElement(By.id("lst-ib")).sendKeys("MyHome");
		String secondScreenshot=Utility.captureScreenshot(d);
		System.out.println(d.getTitle());
		Assert.assertTrue(d.getTitle().contains("Go"));
		
		/*logger.log(Status.INFO, "Getting title of Google site");
		logger.log(Status.PASS, "Getting title is successful");
		extent.flush();
		
		ExtentTest logger2=extent.createTest("GetTitle Test");
		logger2.log(Status.INFO, "Getting title of Google site");
		logger2.log(Status.FAIL, "Getting title is unsuccessful");
		logger2.fail("Failed because of few issues",MediaEntityBuilder.createScreenCaptureFromPath("C://Users//Public//Pictures//Sample Pictures//Desert.jpg").build());
		extent.flush();*/
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(ITestResult.FAILURE==result.getStatus()){
			String faileTest=Utility.captureScreenshot(d);
			String failedCause=result.getThrowable().getMessage();
			logger.fail(failedCause.toString(),MediaEntityBuilder.createScreenCaptureFromPath(faileTest).build());
		}
		d.quit();
		extent.flush();
	}
}
