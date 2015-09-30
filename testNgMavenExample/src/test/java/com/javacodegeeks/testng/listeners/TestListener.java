package com.javacodegeeks.testng.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.javacodegeeks.testng.maven.TestNgMavenExample;
import com.javacodegeeks.testng.utils.Util;

public class TestListener implements ITestListener {
	String filePath;

	public TestListener() {
		// filePath = System.getProperty("user.dir") + "/screenshots";
		//
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		// Date date = new Date();
		// String dateTime = dateFormat.format(date);
		//
		// String buildNumber = System.getenv("BUILD_NUMBER");
		// String folderName = filePath + "/";
		// if (buildNumber != null) {
		// folderName += buildNumber;
		// } else {
		// folderName += dateTime;
		// }
		//
		// filePath = folderName + "/";
		//
		// try {
		// Files.createDirectories(Paths.get(folderName));
		//
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }
	}

	WebDriver driver = null;

	public void onTestFailure(ITestResult result) {
		String methodName = result.getName().toString().trim();
		takeScreenShot(methodName);
	}

	public void takeScreenShot(String fileName) {

		driver = TestNgMavenExample.getDriver();
		Util.takeScreenshot(fileName, driver);

	}

	public void onFinish(ITestContext context) {
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}
}
