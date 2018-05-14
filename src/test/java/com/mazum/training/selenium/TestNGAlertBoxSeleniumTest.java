package com.mazum.training.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAlertBoxSeleniumTest {
	WebDriver driver = null;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testSimpleAlert() {
		driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: " + alertText);
		alert.accept();
	}
	
	@Test
	public void testConfirmationAlert() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='content']/p[8]/button")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: " + alertText);
		Thread.sleep(5000);
		alert.dismiss();
	}
	
	@Test
	public void testPromptAlert() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='content']/p[11]/button")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: " + alertText);
		alert.sendKeys("Accepting the alert");
		Thread.sleep(5000);
		alert.accept();
	}
}
