package com.mooyla.testCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
	
	 @Override		
	    public void onTestFailure(ITestResult Result) {					
		 System.out.println("The name of the testcase failed is :"+Result.getName());		
	    }		

	 @Override		
	    public void onTestSkipped(ITestResult Result) {					
		 System.out.println("The name of the testcase skipped is :"+Result.getName()); 		
	    }		

	 @Override		
	    public void onTestStart(ITestResult Result) {					
		 System.out.println("The name of the testcase start is :"+Result.getName());		
	    }		

	 @Override		
	    public void onTestSuccess(ITestResult Result) {					
		 System.out.println("The name of the testcase passed is :"+Result.getName());		
	    }	
	  @Override		
       public void onFinish(ITestContext Result) {					
        		
        }		

      @Override		
       public void onStart(ITestContext Result) {					
        		
       }		

       @Override		
       public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {					
        		
         }		

   

}
