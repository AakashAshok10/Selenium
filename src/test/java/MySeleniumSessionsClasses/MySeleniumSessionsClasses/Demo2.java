package MySeleniumSessionsClasses.MySeleniumSessionsClasses;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2{
	WebDriver driver;
	
	@BeforeTest
	public  void SetUp() {
		
		driver=new ChromeDriver();
		
		driver.get("https://www.noon.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void test1() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("dd_header_signInOrUp")).click();
		driver.findElement(By.id("emailInput")).sendKeys("akashashok1011@gmail.com");
		driver.findElement(By.id("passwordInput")).sendKeys("NoonPassword");
		driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
		boolean flag=driver.findElement(By.xpath("//span[contains(text(),'Hala')]")).isDisplayed();
		Assert.assertTrue(flag);
		//Thread.sleep(5000);
		//driver.findElement(By.className("sc-b51db3f-1 iCVkuj")).click();
		Thread.sleep(5000);
	}	
	
	@Test
	public void test2() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		WebElement ck=driver.findElement(By.id("searchBar"));
		ck.sendKeys("Airpods Pro");
		//driver.findElement(By.className("sc-a554a9cf-5 jGBDWB")).click();
		ck.sendKeys(Keys.ENTER);
		//driver.navigate().to("https://www.noon.com/uae-en/search/?q=Airpods%20Pro");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().wait(1000);
		
		
		driver.findElement(By.id("productBox-N53348815A")).click();
		
		/*Set<String> s=driver.getWindowHandles();
		ArrayList ar=new ArrayList(s);
		System.out.println(ar.get(0));
		System.out.println(ar.get(1));
		
		driver.switchTo().window((String)ar.get(1)); */
		
		driver.findElement(By.xpath("//div[@class='sc-37f0ec13-24 kCaBgu']")).click();
		/*
		
		driver.findElement(By.id("emailInput")).sendKeys("akashashok1011@gmail.com");
		driver.findElement(By.id("passwordInput")).sendKeys("AakashNoon");
		driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
	*/
	}
	
	@Test
	public void test3() throws InterruptedException {
		WebElement ele=driver.findElement(By.className("wishlistLink"));
		ele.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		//driver.findElement(By.className("jsx-undefined")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div[2]/div/ul/div/div[1]/div[1]/li/a/span")).click();
		//driver.navigate().to("https://www.noon.com/uae-en/electronics/");
		String actualTitle=driver.getTitle();
		System.out.println("Actual Title:"+actualTitle);
		String expectedTitle="Electronics UAE | Online in Dubai, Abu Dhabi | noon";
		System.out.println("Expected Title:"+expectedTitle);
		Assert.assertEquals(actualTitle,expectedTitle,"Successful");
		//Actions action=new Actions(driver);
		//action.moveToElement(ele).perform();
		
	}
	/*	//driver.manage().timeouts().wait(100);
		WebElement ck=driver.findElement(By.id("searchBar"));
		ck.sendKeys("Airpods Pro");
		//driver.findElement(By.className("sc-a554a9cf-5 jGBDWB")).click();
		ck.sendKeys(Keys.ENTER);
		//driver.navigate().to(driver.getCurrentUrl());
		//driver.findElement(By.linkText("Colour Family")).click();
		//driver.findElement(By.id("facet-navpills-black")).click();
		driver.findElement(By.id("productBox-N53348815A")).click();
		//driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div[2]/div/div/div[1]/a")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		*/
	
	@AfterTest
	public void tearDown() throws InterruptedException {
	Thread.sleep(1000);
	driver.close();

}
}
