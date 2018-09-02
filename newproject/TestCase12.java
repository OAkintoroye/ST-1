/* Olubukola Akintoroye
 * Assignment 002 - Test Cases using Selenium
 * Due Date: 06/01/2018 
 * Test Case #12: Delete task - Verify total count decreases by 1
 * 
 * */
package newpackage;

import java.util.List;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestCase12 {
	public static void main(String[] args) {
		ChromeOptions options;
		WebDriver driver;
		Boolean pendingFound;
		int r = 1;
		
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			
		options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); 

		driver = new ChromeDriver(options);
		
		driver.get("http://localhost/todo2/index.php");

		assert(driver.getPageSource().contains("Welcome to Todo List"));
		String username = "Oakin";


		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("enter")).click();
		//time to verify that the password and username has been entered
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String totalamount = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td[1]")).getAttribute("innerHTML");
		int totalnum1 = Integer.parseInt(totalamount);
		
		//converts string to int
		pendingFound = false;
		
		while(pendingFound == false) {
			
			if(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[" + r + "]/td[4]")).getAttribute("innerHTML").equals("Pending"))
			{
				pendingFound = true;
				//clicks the delete button
				driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[" + r + "]/td[6]/a")).click();
			}
			r++;
		}
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//select the ok button to get past the pop-up window
		driver.switchTo().alert().accept();
		
		 totalamount = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td[1]")).getAttribute("innerHTML");
		int totalnum2 = Integer.parseInt(totalamount);
		
		int total = totalnum1 - totalnum2;
		
		if (total == 1) 
			System.out.println("Total amount of tasks has been decremented by one(" + total +") . Test Passed");
		
		else
			System.out.println("Total amout of tasks has not been decremented by one. Test Failed");
	
}
}
