package SeleniumFirstProject.SeleniumWDFirstProject;

import org.testng.annotations.Test;

public class ParellelTestExecutionInMethods {
	
	@Test
	public void Test1(){
		long threadId= Thread.currentThread().getId();
		System.out.println("Test1"+":Thread Id is"+threadId);
	}
	@Test
	public void Test2(){
		long threadId= Thread.currentThread().getId();
		System.out.println("Test2"+":Thread Id is"+threadId);
	}
	@Test
	public void Test3(){
		long threadId= Thread.currentThread().getId();
		System.out.println("Test3"+":Thread Id is"+threadId);
	
	}

}

/*<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="MyFirstSuite" parallel="methods" thread-count="3">
  <test name="MyFirstTest">
    <classes>
      <class name="SeleniumFirstProject.SeleniumWDFirstProject.ParellelTestExecutionInMethods"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->*/
