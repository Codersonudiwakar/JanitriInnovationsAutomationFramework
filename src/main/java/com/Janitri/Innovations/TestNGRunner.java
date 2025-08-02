package com.Janitri.Innovations;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNGRunner {
	  public static void main(String[] args) {
			TestNG runner=new TestNG();
			List<String> suitefiles=new ArrayList<String>();
						suitefiles.add("xml/testng.xml");
			runner.setTestSuites(suitefiles);
			runner.run();	    }

}
