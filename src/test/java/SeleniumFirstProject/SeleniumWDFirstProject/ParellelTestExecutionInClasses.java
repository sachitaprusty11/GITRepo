package SeleniumFirstProject.SeleniumWDFirstProject;

import org.testng.annotations.Test;

public class ParellelTestExecutionInClasses {

	@Test
	public void Test4(){
		long threadId= Thread.currentThread().getId();
		System.out.println("Test1"+":Thread Id is"+threadId);
	}
	@Test
	public void Test5(){
		long threadId= Thread.currentThread().getId();
		System.out.println("Test2"+":Thread Id is"+threadId);
	}
	@Test
	public void Test6(){
		long threadId= Thread.currentThread().getId();
		System.out.println("Test3"+":Thread Id is"+threadId);
	
	}
	@Test
	public void Test7(){
		long threadId= Thread.currentThread().getId();
		System.out.println("Test3"+":Thread Id is"+threadId);
	
	}
	
}

/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="MyFirstSuite" parallel="classes" thread-count="2">
  <test name="MyFirstTest">
    <classes>
      <class name="SeleniumFirstProject.SeleniumWDFirstProject.ParellelTestExecutionInMethods"/>
      <class name="SeleniumFirstProject.SeleniumWDFirstProject.ParellelTestExecutionInClasses"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
*/