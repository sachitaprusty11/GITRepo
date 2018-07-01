package Library;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.utils.FileUtil;

public class Utility {
	public static String captureScreenshot(WebDriver d){
		TakesScreenshot ts =(TakesScreenshot)d;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		File dest =new File(path);
		try {
			FileHandler.copy(source,dest);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return path;
	}
	
}
