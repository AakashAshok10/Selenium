package myTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class pgm1Test {
  WebDriver driver;
	@BeforeTest
  public void setup() {
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
  }
	
	@Test
	public void test1(){
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		String expTitle="OrangeHRM";
		Assert.assertEquals(actualTitle, expTitle,"Success");
	}
	
	@Test
	public void test2() throws InterruptedException
	{
		String curl=driver.getCurrentUrl();
		WebElement uname=driver.findElement(By.name("username"));
		uname.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		WebElement click=driver.findElement(By.xpath("//button[contains(@class,'oxd')]"));
		click.click();
		Thread.sleep(5000);
		String nrurl=driver.getCurrentUrl();
		System.out.println(nrurl);
		
		Assert.assertNotEquals(curl,nrurl,"Login Succesful");
	}
	
	@Test
	public void test3() throws InterruptedException {
		/*
		WebElement uname=driver.findElement(By.name("username"));
		uname.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		WebElement click=driver.findElement(By.xpath("//button[contains(@class,'oxd')]"));
		click.click();
		Thread.sleep(5000);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Thread.sleep(2000);
		String curl=driver.getCurrentUrl();
		System.out.println("Current URl:"+curl);
		
		driver.findElement(By.xpath("//a[contains(@class,'oxd-main')]")).click();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		
		String currurl=driver.getCurrentUrl();
		Thread.sleep(2000);
		System.out.println("URL after clicking on Admin"+currurl);
		*/
		/*WebElement uname=driver.findElement(By.name("username"));
		uname.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		WebElement click=driver.findElement(By.xpath("//button[contains(@class,'oxd')]"));
		click.click();
		*/
		String currurl=driver.getCurrentUrl();
		System.out.println(currurl);
		
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@class,'oxd-main')]")).click();
		
		String currurl1=driver.getCurrentUrl();
		System.out.println(currurl1);
		driver.navigate().to(currurl1);
		/*Select op=new Select(driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")));
		op.selectByVisibleText("Job Titles");
*/
		//driver.findElement(By.linkText("Job")).click();
		
		//softAssert.assertEquals(true,true);
		
		Thread.sleep(3000);
		//driver.quit();
		
		Assert.assertNotEquals(currurl1,currurl,"Navgation Successfull");
		
	}
	
	
  @AfterTest
  public void tearDown() {
	  driver.quit();
	  
  }
}
