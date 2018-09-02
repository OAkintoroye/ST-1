/* Olubukola Akintoroye
 * Assignment 002 - Test Cases using Selenium
 * Due Date: 06/01/2018 
 * Test Case #7: Add - Task - Pending Late
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

public class TestCase7 {
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

		driver.findElement(By.name("task_name")).sendKeys("Testing Case 6");
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//yyyy-mm-dd for firefox, mm-dd-yyyy for chrome
		DateFormat df = new SimpleDateFormat("MMddyyyy");
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		today.add(Calendar.DAY_OF_YEAR, 0);
		//this adds zero days to the current day
		String duedate = df.format(today.getTime());
		
		//System.out.print(duedate);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		driver.findElement(By.name("due_date")).sendKeys(duedate);

		driver.findElement(By.name("status_list")).sendKeys("Pending");
		driver.findElement(By.name("enter")).click();
		
		//List <WebElement> col = driver.findElements(By.xpath("/html/body/table[2]/thead/tr/th"));
		//System.out.println("Num of cols: " + col.size());
		
		List <WebElement> row = driver.findElements(By.xpath("/html/body/table[2]/tbody/tr/td[1]"));
		//System.out.println("num of rows: " + row.size());
	
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//look for the row that matches the task name
		//when found, click on the element for the edit status
		for(int r = 1; r<row.size() + 1;r++)
		{
				if(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[" + r + "]/td[2]")).getAttribute("innerHTML").equals("Testing Case 6"))
					{
						driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[" + r + "]/td[5]/a")).click();
					}
		}
		
		//select the ok button to get past the pop-up window
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.name("task_name")).sendKeys("Testing Case 7");
		driver.findElement(By.name("due_date")).sendKeys(duedate);
		driver.findElement(By.name("status_list")).sendKeys("Late");
		
		//note: if a task was created today as pending, after refreshing it becomes late.
		//another option would be to leave it as it is and refresh the page :D
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("update")).click();
		driver.findElement(By.xpath("/html/body/a")).click();
	}	
	


	}

