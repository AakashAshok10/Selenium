package myTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest {
	WebDriver wb;
	WebElement ck, afterExit;
	 
	@BeforeMethod
	public void setUp() {
		wb=new ChromeDriver();
		wb.get("https://www.hyrtutorials.com/p/frames-practice.html");
		wb.manage().window().maximize();
		wb.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//wb.manage().deleteAllCookies();
		
	}
	
	@Test
	public void test1() throws InterruptedException {
		ck=wb.findElement(By.id("name"));
		ck.sendKeys("Hello");
		//System.out.println(ck.getText());
		wb.switchTo().frame(wb.findElement(By.id("frm1")));

		
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor)wb;
		js.executeScript("window.scrollBy(0,500)");
		//Select op=new Select(
		//dr.findElement(By.xpath("//*[@id=\"body-wrapper\"]/div[4]/div/li/a")).click();
		Select op=new Select(wb.findElement(By.id("course")));
		Thread.sleep(5000);

		op.selectByVisibleText("Java");
		wb.switchTo().parentFrame();
		
		Thread.sleep(5000);

		wb.findElement(By.id("name")).clear();
		afterExit=wb.findElement(By.id("name"));
		afterExit.sendKeys("Changed to Hi!!");
		//System.out.println(afterExit.getText());
		//Thread.sleep(5000);
		
		
		Assert.assertNotNull(wb.findElement(By.id("name")));
		wb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wb.switchTo().frame(wb.findElement(By.id("frm2")));
		wb.findElement(By.id("firstName")).sendKeys("Aakash");
		wb.findElement(By.id("lastName")).sendKeys("Ashok");
		wb.findElement(By.id("malerb")).click();
		wb.findElement(By.id("englishchbx")).click();
		
		
		wb.switchTo().parentFrame();
		//dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		wb.findElement(By.id("name")).clear();
		wb.findElement(By.id("name")).sendKeys("Changed to Hello World!!");
		Thread.sleep(5000);
		Assert.assertNotNull(wb.findElement(By.id("name")));

	}
	/*
	@Test
	public void test3() throws InterruptedException {
		
		wb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wb.switchTo().frame(wb.findElement(By.id("frm2")));
		wb.findElement(By.id("firstName")).sendKeys("Aakash");
		wb.findElement(By.id("lastName")).sendKeys("Ashok");
		wb.findElement(By.id("malerb")).click();
		wb.findElement(By.id("englishchbx")).click();
		
		
		wb.switchTo().parentFrame();
		//dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		wb.findElement(By.id("name")).clear();
		wb.findElement(By.id("name")).sendKeys("Changed to Hello World!!");
		Thread.sleep(5000);
		Assert.assertNotNull(wb.findElement(By.id("name")));

	}
	*/
	
	@AfterMethod
	public void tearDown() {
		
		wb.close();
	}
	
	

}
