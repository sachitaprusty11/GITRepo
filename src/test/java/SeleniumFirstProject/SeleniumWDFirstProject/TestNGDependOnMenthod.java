package SeleniumFirstProject.SeleniumWDFirstProject;

import org.testng.annotations.Test;

public class TestNGDependOnMenthod {
	@Test
	public void test1(){
		System.out.println("Test1");
		int i= 2/0;
	}
	//It will only be execute if and only if "test1 get pass otherwise it will be skipped"
	@Test(dependsOnMethods= "test1")
	public void test2(){
		System.out.println("Test2");
	}

}
