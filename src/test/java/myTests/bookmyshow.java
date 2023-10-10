package myTests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class bookmyshow {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void Setup() {
		
		driver=new ChromeDriver();
		driver.get("https://in.bookmyshow.com/explore/home/kochi");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test1() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Movie Tickets, Plays, Sports, Events & Cinemas near Kochi - BookMyShow");
	}
	/*
	@Test
	public void test2() {
		//driver.findElement(By.xpath("//img[@alt='KOCH']")).click();
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[3]/ul/li[10]")).click();
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Movie Tickets, Plays, Sports, Events & Cinemas near Kochi - BookMyShow");

		//driver.getTitle().contains("nearby Kochi"));
	}
*/
	@Test
	public void test2() {
		driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[1]/header/div[2]/div/div/div/div[1]/div/a[1]")).click();
		//driver.findElement(By.xpath("//a[@href='/explore/movies-kochi' and contains(@class,'bwc__sc-1shzs91-0')]")).click();
		//Assert.assertEquals(driver.getTitle(), "Kochi Movie Tickets Online Booking & Showtimes near you - BookMyShow");
		driver.findElement(By.xpath("//div[@class='sc-133848s-2 sc-7naidv-0 fDjfAS' and text()='Malayalam']")).click();
	
	
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
