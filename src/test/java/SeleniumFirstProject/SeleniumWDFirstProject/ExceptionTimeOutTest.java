package SeleniumFirstProject.SeleniumWDFirstProject;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {

/*	@Test(timeOut=2000)
	public void infiniteLoop(){
		int i=1;
		while(i==1){
			System.out.println(i);
		}
	}*/
	@Test(expectedExceptions =NumberFormatException.class)
	public void NoFormatexceptionTest(){
		String str= "100A";
		Integer.parseInt(str);
	}
	@Test(enabled=true)
	public void enableTest(){
		System.out.println("ENABLE is failse");
	}
}
