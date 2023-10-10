package myTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;
	WebElement ack;
	WebElement srch;
	WebElement prod;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//driver.get("https://www.amazon.in/Apple-iPhone-13-128GB-Starlight/dp/B09G99CW2N/ref=sr_1_3?qid=1696590162&refinements=p_89%3AApple%2Cp_n_pct-off-with-tax%3A2665399031&rnid=2665398031&s=electronics&sr=1-3&th=1");
	}
	
	@Test
	public void test0() {
		System.out.println("Actual Title : "+driver.getTitle());
		String expTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(driver.getTitle(), expTitle);
		
	}
			
	@Test
	public void test1() {
		driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]")).click();
		driver.findElement(By.xpath("//a[@href=\"/gp/bestsellers/automotive/ref=zg_bs_nav_automotive_0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"B077BFH786\"]/a[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"newAccordionRow_1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		
		ack=driver.findElement(By.xpath("//div[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]"));
		
		Assert.assertTrue(ack.isDisplayed());
		
	}
	
	@Test
	public void test2() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id=\"nav-global-location-popover-link\"]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id=\"GLUXZipUpdateInput\"]")).sendKeys("671542");
		driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void test3() throws InterruptedException {
		srch=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		srch.sendKeys("Airpods Pro");
		srch.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		prod= driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"][contains(text(),\"Apple AirPods Pro (2nd Generation) ​​​​​​​\")])[2]"));
		
		String mainWindowHandle = driver.getWindowHandle();
        prod.click();
        
        Set <String> handles=driver.getWindowHandles();
		for (String handle : handles) {
            if (!handle.equals(mainWindowHandle)) {
               driver.switchTo().window(handle);
               
       		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

               driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
       		
       		   driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
//       		 
               //driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
	    	   //ack=driver.findElement(By.xpath("//a[@class='a-link-normal sc-product-link' and contains(text(), 'Apple AirPods Pro (2nd Generation)')]"));

               //Assert.assertTrue(ack.isDisplayed());
           
//       		
	    	   Thread.sleep(7000);
	    		
               driver.close();
               driver.switchTo().window(mainWindowHandle);
               
               driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
               
       		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	    	   ack=driver.findElement(By.xpath("//img[@src=\"https://m.media-amazon.com/images/I/61SUj2aKoEL._AC_AA180_.jpg\"]"));

               Assert.assertTrue(ack.isDisplayed());
            }
         }
	}
	
	@Test
	public void test4() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]")).click();
		driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-base\"][normalize-space()=\"Apple\"]")).click();
		
		prod = driver.findElement(By.xpath("//span[normalize-space()='Apple iPhone 13 (128GB) - Midnight']"));
		
		String mainWindowHandle = driver.getWindowHandle();
        prod.click();
        
        Set <String> handles=driver.getWindowHandles();
		for (String handle : handles) {
            if (!handle.equals(mainWindowHandle)) {
               driver.switchTo().window(handle);
               
       		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       		   
       		   driver.findElement(By.xpath("//img[@alt=\"(PRODUCT) RED\"]")).click();

       		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


               driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
               driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
       		
       		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//       		 
               //driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
	    	   //ack=driver.findElement(By.xpath("//a[@class='a-link-normal sc-product-link' and contains(text(), 'Apple AirPods Pro (2nd Generation)')]"));

               //Assert.assertTrue(ack.isDisplayed());
//       		
	    	   Thread.sleep(5000);
	    		
               driver.close();
               driver.switchTo().window(mainWindowHandle);
               
               driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
               
       		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	    	   ack=driver.findElement(By.xpath("//img[@src=\"https://m.media-amazon.com/images/I/71gm8v4uPBL._AC_AA180_.jpg\"]"));

               Assert.assertTrue(ack.isDisplayed());
            }
         }
	}	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}


