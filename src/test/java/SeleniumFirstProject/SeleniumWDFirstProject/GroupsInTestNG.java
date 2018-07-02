package SeleniumFirstProject.SeleniumWDFirstProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import Library.Utility;
import junit.framework.Assert;

public class GroupsInTestNG {
	WebDriver d;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D://Software//ChromeDriverSelenium//chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("http://www.google.com");
	}
	// due to invocation count This test will execute 3 times
	@Test(priority=1, invocationCount=3, groups="Title")
	public void getTitle() {
		String titleName = d.getTitle();
		System.out.println(titleName);
		System.out.println("Title Group");
	}

	@Test(priority=3, groups="Logo")
	public void googleLogoTest() {
		boolean b=d.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		Assert.assertEquals(true, b);
		System.out.println("Logo Group");
	}

	@Test(priority=2, groups="Logo , Title")
	public void gmailLinkTest(){
		d.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("Logo and Title groups");
				
	}
	@Test(groups="group3")
	public void googleTest(){
		System.out.println("group3");
	}

	@AfterMethod
	public void tearDown(ITestResult result){
		d.quit();
	}

}


/*<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="MyFirstSuite">
  <test thread-count="5" name="MyFirstTest">
  <groups>
  <run>
  <include name="group3"></include>
  <exclude name="Logo"></exclude>
  </run>
  </groups>
    <classes>
      <class name="SeleniumFirstProject.SeleniumWDFirstProject.GoogleTest"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
*/
