package com.javacodegeeks.testng.utils;

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

public class Util {

	public static void takeScreenshot(String fileName, WebDriver driver) {
		String filePath = System.getProperty("user.dir") + "/screenshots";

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date);

		String buildNumber = System.getenv("BUILD_NUMBER");
		String folderName = filePath + "/";
		if (buildNumber != null) {
			folderName += buildNumber;
		} else {
			folderName += dateTime;
		}

		filePath = folderName + "/";

		try {
			Files.createDirectories(Paths.get(folderName));

		} catch (IOException e) {

			e.printStackTrace();
		}

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {
			String imageLocation = filePath + fileName + ".png";
			FileUtils.copyFile(scrFile, new File(imageLocation));
			scrFile.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
