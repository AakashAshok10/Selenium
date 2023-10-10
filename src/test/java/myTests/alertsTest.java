package myTests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class alertsTest {
	WebDriver wb;
	
	
	@BeforeTest
	public void setUp() {
		wb=new ChromeDriver();
		wb.get("https://nxtgenaiacademy.com/alertandpopup/");
		wb.manage().window().maximize();
		wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test
	public void test1() throws InterruptedException {
		wb.findElement(By.name("alertbox")).click();
		Thread.sleep(5000);
		Alert al=wb.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(2000);
		al.accept();
		
		//Assert.assert(al.accept());
		
	}
	
	@Test
	public void test2() throws InterruptedException {
		wb.findElement(By.name("confirmalertbox")).click();
		Thread.sleep(5000);
		Alert al=wb.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(2000);
		al.dismiss();
		System.out.println(wb.findElement(By.id("demo")).getText());
		Assert.assertEquals(true, true);
		Thread.sleep(2000);
		
	}
	
	@Test
	public void Test3() throws InterruptedException {
		wb.findElement(By.name("promptalertbox1234")).click();
		Thread.sleep(5000);
		Alert al=wb.switchTo().alert();
	
		System.out.println(al.getText());
		al.sendKeys("No");
		
		Thread.sleep(2000);
		al.accept();
		
		System.out.println(wb.findElement(By.id("demoone")).getText());

	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		//Thread.sleep(5000);
		wb.close();
		
	}

}
