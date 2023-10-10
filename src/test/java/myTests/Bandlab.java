package myTests;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Bandlab {
	
	WebDriver driver;
	WebElement popup;
	WebElement pop;
	WebElement key,drop;
	
	@BeforeTest
	public void setup() {
		driver= new ChromeDriver();
		driver.get("https://www.bandlab.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test0() {
		
		System.out.println("Actual Title : "+driver.getTitle());
		String expTitle="BandLab - Make Music Online";
		Assert.assertEquals(driver.getTitle(), expTitle);
		
	}
	@Test
	public void test1(){
		//driver.wait(2000);
		try {
			popup=driver.findElement(By.xpath("//div[@class='privacy-banner']"));
			if(popup.isDisplayed()) {
				driver.findElement(By.xpath("/html/body/privacy-banner/div/div[2]/button")).click();
			}
		}
		catch(NoSuchElementException e) {
			
		}
		
		driver.findElement(By.xpath("//li/a[@href='/login']")).click();
		driver.findElement(By.id("username")).sendKeys("akashashok78@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Music#17");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@href='/explore' and @class='button-rounded']")).click();
		driver.findElement(By.xpath("/html/body/main/div/ui-view/div/div[2]/explore-genre-buttons/div/a[11]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@href=\"/bandlab/collections/0067e1bc-fbc4-e711-80c2-0003ff4668ed\" and @class=\"ds-button ds-button-secondary ds-button-medium ds-button-padding-default\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='button-cta button-height-32 button-padding-16 button-gap-8 button-create button-rounded']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.findElement(By.xpath("/html/body/div[1]/site-top-bar/nav/section[4]/div[5]/a")).click();
		driver.findElement(By.xpath("//a[@href='/studio']")).click();
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		//try {
			pop=driver.findElement(By.xpath("//div[@class='mix-editor-track-new-type' and @ng-click=\"addTrack('piano', 'Instrument')\"]"));
			//if(pop.isDisplayed()) {
			pop.click();
				//driver.findElement(By.xpath("//div[@class=\"mix-editor-track-new-type\" and @ng-click=\"addTrack('piano', 'Instrument')\"]")).click();
		//	}
	//	}
		//catch(NoSuchElementException e) {
			
		//}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		drop = driver.findElement(By.xpath("//div[@role='button'][2]"));
		drop.click();
		//driver.findElement(By.xpath("//div[@class='select-menu-item' and span[@class='select-menu-item-label text-truncate' and text()='Major Scale']]")).click();
		
		driver.findElement(By.xpath("//button[@title=\"Start Recording (R)\"]")).click();
		
		driver.findElement(By.xpath("//div[@class='virtual-piano-white' and @data-midi-code=\"41\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='virtual-piano-black' and @data-midi-code=\"44\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		key=driver.findElement(By.xpath("//div[@class='virtual-piano-white' and @data-midi-code=\"48\"]"));
		key.click();
		
		driver.findElement(By.xpath("//button[@title=\"Stop Recording (R)\"]")).click();

		
		Assert.assertTrue(key.isDisplayed());

		
		/*
		// Capture the screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Define the destination path for the screenshot
		String destinationPath = "/Users/AakashAshok";

		// Copy the screenshot file to the destination path
		Files.copy(screenshotFile, new File(destinationPath));

	*/
	
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
