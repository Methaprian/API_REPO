package genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplemtationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+ " Test Script execution Started");
	}
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+ " Test Script Passed");
		Reporter.log(methodName+ " Test Script execution successful");
	}
	public void onTestFailure(ITestResult result) {
		String path = "FailedScript"+ new Java_Utility().getSystemDateAndtime();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("Screenshot"+path+".png");
		String filePath = dst.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath);
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+" Test Script failed");
		Reporter.log(methodName+" Test Script execution not completed");
	
	}
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" Test Script Skipped");
		Reporter.log(methodName+" Test Script excution has been skipped");
	
	}
	
	
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlReport.config().setDocumentTitle("SIS_API Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Sales And Invetory Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("System", "Windows 10");
		report.setSystemInfo("URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		report.setSystemInfo("Reporter name", "Sachinkumar");
	}
	public void onFinish(ITestContext context) {
		report.flush();
	
	}
	

	
}
