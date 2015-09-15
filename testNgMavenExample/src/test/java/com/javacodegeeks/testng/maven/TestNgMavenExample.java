package com.javacodegeeks.testng.maven;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgMavenExample {
	
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() {
		System.out.println("testClass: before test");
	}

	@Test
	public void googleQuery() throws InterruptedException {
		driver.get("http://www.eurotech.com/it/");
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='ctl00_Header_PB_Menu3_search']"));
		searchBox.sendKeys("kura");
		 
			Thread.sleep(5000);
		 
		WebElement enterSearch = driver.findElement(By.xpath("//input[@id='ctl00_Header_PB_Menu3_btnSearch']"));
		enterSearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		WebElement result = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ctl01_DataListNews\"]/tbody/tr[2]/td/span[2]/a"));
		String expectedString = "Eurotech annuncia il rilascio di Everyware Software Framework (ESF) 3.0, l’infrastruttura Java-OSGi per M2M gateway, dispositivi intelligenti e applicazioni IoT";
		
		Assert.assertTrue(result.getText().trim().equals(expectedString), "Recieved String is different from expected string");
		
		
		
	}

	@Test
	public void unitLevel2() {
		System.out.println("testClass: Unit level2 testing");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("testClass: before method");
	}

	@BeforeMethod
	public static void staticBeforeMethod() {
		System.out.println("testClass: static before method");
	}

	
	@BeforeMethod
	public void beforeMethodWithParam() {
		System.out.println("testClass: before method with param ");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("testClass: after method");
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		System.out.println("testClass: before class");

		//URL hubUrl = new URL("http://172.30.41.195:4444/wd/hub");
		URL hubUrl = new URL("http://10.73.2.120:4444/wd/hub");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setBrowserName("firefox");
	    capabilities.setPlatform(Platform.LINUX);
		
		driver = new RemoteWebDriver(hubUrl, capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("testClass: after class");
		driver.close();
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("testClass: after test");
	}
}
