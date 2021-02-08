package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SaucedemoPage {

	public static final String URL = "https://www.saucedemo.com/inventory.html";
	private static final String SORTBTN_XPATH = "//*[@id=\"inventory_filter_container\"]/select";
	private static final String PRICESORT_XPATH = "//*[@id=\"inventory_container\"]";

	public static void inventorySort(WebDriver driver) {
		driver.findElement(By.xpath(SORTBTN_XPATH)).click();
		driver.findElement(By.xpath(SORTBTN_XPATH)).sendKeys("Price (low to high");
		driver.findElement(By.xpath(SORTBTN_XPATH)).sendKeys(Keys.RETURN);

	}

	public static void sort(double[] niz) {
		for (int i = 0; i < niz.length; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] > niz[j]) {
					double p = niz[i];
					niz[i] = niz[j];
					niz[j] = p;

				}
			}
		}
	}
}
