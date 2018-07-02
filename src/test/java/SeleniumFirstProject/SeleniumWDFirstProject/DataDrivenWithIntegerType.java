
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

	public class DataDrivenWithIntegerType {

		@Test(dataProvider="testdata")
		public void gmailLogin(String num1,String num2, String num3){
			int a=Integer.parseInt(num1);
			int b=Integer.parseInt(num2);
			int c=Integer.parseInt(num3);
			int result= a+b+c;
			System.out.println(result);
		}
		
		@DataProvider(name="testdata")
		public Object[][] readExcelData() throws BiffException, IOException {

			File f =new File("D:/SeleniumWebDriverWS/SeleniumWDFirstProject/Inputs/InputDataForAddition.xls");
			Workbook wb =Workbook.getWorkbook(f);
			Sheet sh =wb.getSheet("DataCredential");
			int rows=sh.getRows();
			int columns=sh.getColumns();
			//System.out.println(rows);
			//System.out.println(columns);
			String inputData[][]= new String [rows][columns];
			for(int i=0; i<rows;i++){
				for(int j=0;j<columns;j++){
					Cell c=sh.getCell(j,i);
					inputData[i][j]=c.getContents();
					//System.out.println(inputData[i][j]);
				}
			}
			return inputData;
		}
		
		
		

	}

