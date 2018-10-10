package customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testBase.TestBase;

public class Listener extends TestBase implements ITestListener{
	//WebDriver driver;
	//public Listener(WebDriver driver) {
	//this.driver=driver;
	//}

	public void onFinish(ITestContext arg0) {
		Reporter.log("Tests Execution Finished:" +((ITestResult) arg0).getMethod().getMethodName());
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
			if(!result.isSuccess()){
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				
				String methodName = result.getName();

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/";
					File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
					
					FileUtils.copyFile(scrFile, destFile);
					
					Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Tests Skipped:" +arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Tests Started Running:" +arg0.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("Tests Run is Success:" +arg0.getMethod().getMethodName());
		if(arg0.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = arg0.getName();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/";
				File destFile = new File((String) reportDirectory + "/success_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
		
	}



