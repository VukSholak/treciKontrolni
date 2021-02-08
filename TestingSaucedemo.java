package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.SaucedemoPage;

public class TestingSaucedemo {
	
public static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test (priority = 0)
	public void testFailedLogin() {
		driver.navigate().to(Home.URL);
		
		Home.failedLoginToSaucedemo(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = Home.URL;
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 1)
	public void testSuccessfulLogin() {
		driver.navigate().to(Home.URL);
		
		Home.loginToSaucedemo(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = SaucedemoPage.URL;
		
		Assert.assertEquals(actual, expected);		
	}
	
	@Test (priority = 2)
	public void testPriceSort() {
		driver.navigate().to(SaucedemoPage.URL);
		
		SaucedemoPage.inventorySort(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = SaucedemoPage.URL;
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 3)
	public void testSort() {
		driver.navigate().to(SaucedemoPage.URL);
		
		double[] actual = {29.99, 9.99, 15.99, 49.99, 7.99, 15.99};
		SaucedemoPage.sort(actual);
		SaucedemoPage.inventorySort(driver);
		double[] expected = {7.99, 9.99, 15.99, 15.99, 29.99 ,49.99};
		
		Assert.assertEquals(actual, expected);
		
	}
	
	

}
