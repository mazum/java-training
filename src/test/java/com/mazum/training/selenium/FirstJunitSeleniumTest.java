package com.mazum.training.selenium;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJunitSeleniumTest {

	WebDriver driver = null;
	String searchString = "Selenium";
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.google.com.au/");
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		System.out.println(driver.findElement(By.linkText("Gmail")).getAttribute("href"));
		System.out.println(driver.findElement(By.partialLinkText("mage")).getAttribute("href"));
		
		System.out.println(driver.manage().getCookies());
		
		WebElement element = driver.findElement(By.className("gsfi"));
		

		element.sendKeys(searchString);
		element.submit();
		System.out.println(driver.getTitle());
		assertThat(driver.getTitle(), containsString(searchString));
	}

}
