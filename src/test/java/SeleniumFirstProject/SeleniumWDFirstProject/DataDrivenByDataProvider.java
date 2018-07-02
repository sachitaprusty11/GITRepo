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

public class DataDrivenByDataProvider {
	WebDriver d;
	@Test(dataProvider="testdata")
	public void gmailLogin(String userName, String password){
		System.setProperty("webdriver.chrome.driver", "D://Software//ChromeDriverSelenium//chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://www.gmail.com");
		d.manage().window().maximize();
		//d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(userName);
		d.findElement(By.xpath("//span[@class='RveJvd snByac'][contains(text(),'Next')]")).click();
		d.findElement(By.xpath("//div[@id='password']//div[@class='aCsJod oJeWuf']//div[@class='aXBtI Wic03c']//div[@class='Xb9hP']//input[@class='whsOnd zHQkBf']")).sendKeys(password);
		d.findElement(By.id("passwordNext")).click();
		WebDriverWait wait=new WebDriverWait(d, 20);
		Assert.assertEquals("https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward", d.getCurrentUrl());
		
	}
	@AfterMethod
	public void closeBrowser(){
		if(!d.toString().contains("null")){
			d.close();
		}
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] readExcelData() throws BiffException, IOException {

		File f =new File("D:/SeleniumWebDriverWS/SeleniumWDFirstProject/Inputs/InputData.xls");
		Workbook wb =Workbook.getWorkbook(f);
		Sheet sh =wb.getSheet("DataCredential");
		int rows=sh.getRows();
		int columns=sh.getColumns();
		//System.out.println(rows);
		//System.out.println(columns);
		String inputData[][]= new String [rows][columns];
		for(int i=1; i<rows;i++){
			for(int j=0;j<columns;j++){
				Cell c=sh.getCell(j,i);
				inputData[i][j]=c.getContents();
				//System.out.println(inputData[i][j]);
			}
		}
		return inputData;
	}
	
	
	

}
