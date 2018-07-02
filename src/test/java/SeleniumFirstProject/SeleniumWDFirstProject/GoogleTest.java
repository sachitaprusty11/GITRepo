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

public class GoogleTest {
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
	}

	@Test(priority=3, groups="Logo")
	public void googleLogoTest() {
		boolean b=d.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		Assert.assertEquals(true, b);
	}

	@Test(priority=2, groups="Logo , Title")
	public void gmailLinkTest(){
		d.findElement(By.linkText("Gmail")).isDisplayed();
				
	}

	@AfterMethod
	public void tearDown(ITestResult result){
		d.quit();
	}

}
