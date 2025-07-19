package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Tests.BaseTest;
import Utilities.ExtentManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testThread.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		testThread.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		testThread.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseTest) currentClass).getDriver();

		// Screenshot logic
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + result.getMethod().getMethodName() + "_"
				+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
		try {
			Files.copy(src.toPath(), new File(path).toPath());
			testThread.get().addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
