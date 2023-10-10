package MySeleniumSessionsClasses.MySeleniumSessionsClasses;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test1 {
	
	SoftAssert softAssert=new SoftAssert();
	WebDriver driver= new ChromeDriver();
	
	@Test
	public void testA() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver","/Users/AakashAshok/Downloads/chromedriver_mac64" );
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		//WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
		String gT=driver.getTitle();
		
		softAssert.assertEquals("OrangeHRM", gT);
		
		WebElement uname=driver.findElement(By.name("username"));
		uname.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		WebElement click=driver.findElement(By.xpath("//button[contains(@class,'oxd')]"));
		click.click();
	String currurl=driver.getCurrentUrl();
		System.out.println(currurl);
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
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
		
		
		
	}
}
