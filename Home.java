package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	public static final String URL = "https://www.saucedemo.com/";
	private static final String USERNAME_XPATH = "//*[@id=\"user-name\"]";
	private static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	private static final String LOGINBTN_XPATH = "//*[@id=\"login-button\"]";

	public static void failedLoginToSaucedemo(WebDriver driver) {

		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row1 = sheet.getRow(0);
			Row row2 = sheet.getRow(1);
			String invUser = row1.getCell(0).toString();
			String invPass = row2.getCell(1).toString();

			driver.findElement(By.xpath(USERNAME_XPATH)).click();
			driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(invUser);
			driver.findElement(By.xpath(PASSWORD_XPATH)).click();
			driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(invPass);
			driver.findElement(By.xpath(LOGINBTN_XPATH)).click();

			wb.close();
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}

	}

	public static void loginToSaucedemo(WebDriver driver) {

		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			for (int i = 1; i < 4; i++) {
				row = sheet.getRow(i);
				String user = row.getCell(0).toString();
				String pass = row.getCell(1).toString();
				driver.findElement(By.xpath(USERNAME_XPATH)).click();
				driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(user);
				driver.findElement(By.xpath(PASSWORD_XPATH)).click();
				driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(pass);
				driver.findElement(By.xpath(LOGINBTN_XPATH)).click();

				wb.close();
			}
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}

	}

}
