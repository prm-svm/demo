package com.javacodegeeks.testng.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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

	@Parameters({ "param" })
	@BeforeMethod
	public void beforeMethodWithParam(String p) {
		System.out.println("testClass: before method with param " + p);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("testClass: after method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("testClass: before class");
		driver = new FirefoxDriver(); 
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
