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

public class PremierLeague {
	
	WebDriver pl;
	
	@BeforeTest
	public void SetUp() {
		pl=new ChromeDriver();
		pl.get("https://premierleague.com/");
	}
	
	@Test
	public void test1() { //closing alerts and ads
		
		pl.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		pl.findElement(By.id("advertClose")).click();
		pl.getTitle();
		Assert.assertEquals(pl.getTitle(), "Premier League Football News, Fixtures, Scores & Results");
	
//		pl.findElement(By.id("loginUsername")).sendKeys("akashashok78@gmail.com");
//		pl.findElement(By.id("loginLoginWrap")).sendKeys("Aakash#10");
//		pl.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[3]/button")).click();
	}
	
	@Test
	public void test2() {
		pl.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		pl.findElement(By.id("advertClose")).click();
		
		pl.findElement(By.xpath("//a[@data-link-index='2']")).click();
		pl.findElement(By.id("advertClose")).click();
		pl.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[1]/section/div[3]/div[2]")).click();
		pl.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[1]/section/div[3]/div[3]/ul/li[2]")).click();
		//pl.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div[1]/div[2]/section/div[4]/div[2]/ul/li[1]/div/span")).click();
		pl.findElement(By.id("advertClose")).click();

		//pl.findElement(By.xpath("//li[@class=\"match-fixture\" and @data-home=\"Aston Villa\"]")).click();	
		}
	
	@AfterTest
	public void tearDown() {
		pl.close();
	}
}

