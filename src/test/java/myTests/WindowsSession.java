package myTests;

//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WindowsSession {
			WebDriver dr;
			WebElement ck;
			
			@BeforeTest
		public void SetUp() {
				dr = new ChromeDriver();
				dr.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			}
			
		@Test
		public void test1() throws InterruptedException
		{
				
				String parentHandle=dr.getWindowHandle();
				System.out.println("Parent window:"+parentHandle);
				dr.findElement(By.id("newWindowBtn")).click();
				Set <String> handles=dr.getWindowHandles();
				for (String handle : handles) {
					System.out.println("Window :"+handles);

					if(!handle.equals(parentHandle)) {
						
						dr.switchTo().window(handle);

						dr.findElement(By.id("firstName")).sendKeys("Aakash");
						dr.findElement(By.id("lastName")).sendKeys("Ashok");
						dr.findElement(By.id("malerb")).click();
						dr.findElement(By.id("englishchbx")).click();
						dr.findElement(By.name("email")).sendKeys("akashashok78@gmail.com");
						dr.findElement(By.name("psw")).sendKeys("Random");
						dr.findElement(By.xpath("//*[@id=\"registerbtn\"]")).click();
						

						Thread.sleep(3000);
						//dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						dr.close();
					}
						
				}
				//dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				dr.switchTo().window(parentHandle);
				ck=dr.findElement(By.id("name"));
				ck.sendKeys("Hello, I'm back!!");
				Thread.sleep(5000);
				System.out.println(ck);
				Assert.assertTrue(ck.isDisplayed());
				
				
		}
		

		@AfterTest
		public void tearDown() throws InterruptedException {
			Thread.sleep(2000);
			dr.quit();
		}
		

}
