/* Olubukola Akintoroye
 * Assignment 002 - Test Cases using Selenium
 * Due Date: 06/01/2018 
 * Test Case #5: Add - Task - Started
 * 
 * */
package newpackage;

import java.awt.List;
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





public class TestCase5 {

	public static void main(String[] args) {
		ChromeOptions options;
		WebDriver driver;
			
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			
		options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); 

		driver = new ChromeDriver(options);
		driver.get("http://localhost/todo2/index.php");

		assert(driver.getPageSource().contains("Welcome to Todo List"));


		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String username = "Oakin";

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys("password");

		driver.findElement(By.name("enter")).click();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("task_name")).sendKeys("Testing Case 5");
		
		DateFormat df = new SimpleDateFormat("MMddyyyy");
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		today.add(Calendar.DAY_OF_YEAR, 2);
		//this adds two days to the current day
		String duedate = df.format(today.getTime());
		
		
	
		
		driver.findElement(By.name("due_date")).sendKeys(duedate);
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("status_list")).sendKeys("Started");
		driver.findElement(By.name("enter")).click();
		
		
	
	}
}

