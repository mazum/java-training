package com.mazum.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgram {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Windows");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com.au/");
		
		WebElement element = driver.findElement(By.name("q"));
		
		element.sendKeys("Selenium");
		element.submit();
		
		//driver.findElement(By.name("btnK")).click();
	}

}
