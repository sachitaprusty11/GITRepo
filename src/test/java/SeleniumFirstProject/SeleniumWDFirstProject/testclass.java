package SeleniumFirstProject.SeleniumWDFirstProject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class testclass {
	WebDriver d;
	@Test(dataProvider="testdata")
	public void gmailLogin(String num1,String num2, String num3){
		int a=Integer.parseInt(num1);
		int b=Integer.parseInt(num2);
		int c=Integer.parseInt(num3);
		int result= a+b+c;
		System.out.println(result);
	}
	@AfterMethod
	public void closeBrowser(){
		if(!d.toString().contains("null")){
			d.close();
		}
		
	}
}
