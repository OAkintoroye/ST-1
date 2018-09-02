/* Olubukola Akintoroye
 * Assignment 002 - Test Cases using Selenium
 * Due Date: 06/01/2018 
 * Test Case #8: Add - verify multiple task of same type are allowed
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

public class TestCase8 {
	public static void main(String[] args) {
	ChromeOptions options;
	WebDriver driver;
	
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

	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//yyyy-mm-dd for firefox, mm-dd-yyyy for chrome
	DateFormat df = new SimpleDateFormat("MMddyyyy");
	Calendar today = Calendar.getInstance();
	today.setTime(new Date());
	today.add(Calendar.DAY_OF_YEAR, 2);
	//this adds zero days to the current day
	String duedate = df.format(today.getTime());
	
	//System.out.print(duedate);
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	//First pending type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8a1");
	driver.findElement(By.name("due_date")).sendKeys(duedate);

	driver.findElement(By.name("status_list")).sendKeys("Pending");
	driver.findElement(By.name("enter")).click();
	
	//Second pending type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8a2");
	driver.findElement(By.name("due_date")).sendKeys(duedate);

	driver.findElement(By.name("status_list")).sendKeys("Pending");
	driver.findElement(By.name("enter")).click();
	//first Started type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8b1");
	driver.findElement(By.name("due_date")).sendKeys(duedate);
	driver.findElement(By.name("status_list")).sendKeys("Started");
	driver.findElement(By.name("enter")).click();
	//Second Started type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8b2");
	driver.findElement(By.name("due_date")).sendKeys(duedate);
	driver.findElement(By.name("status_list")).sendKeys("Started");
	driver.findElement(By.name("enter")).click();
	//first Late type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8c1");
	driver.findElement(By.name("due_date")).sendKeys(duedate);
	driver.findElement(By.name("status_list")).sendKeys("Late");
	driver.findElement(By.name("enter")).click();
	//Second Late type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8c2");
	driver.findElement(By.name("due_date")).sendKeys(duedate);
	driver.findElement(By.name("status_list")).sendKeys("Late");
	driver.findElement(By.name("enter")).click();
	//first Completed type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8d1");
	driver.findElement(By.name("due_date")).sendKeys(duedate);
	driver.findElement(By.name("status_list")).sendKeys("Completed");
	driver.findElement(By.name("enter")).click();
	//Second Completed type
	driver.findElement(By.name("task_name")).sendKeys("Testing Case 8d2");
	driver.findElement(By.name("due_date")).sendKeys(duedate);
	driver.findElement(By.name("status_list")).sendKeys("Completed");
	driver.findElement(By.name("enter")).click();
	
	//Confirmed that at least two tasks of the same type can be entered into the todo list
}
}
