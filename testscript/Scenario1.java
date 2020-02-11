package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",".//driver//geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
	   driver.get("https://www.flipkart.com/");
	   
	   //Close the login popup window
	   driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	   
	   //search the item
	   driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("VU TV");
	   
	   //click on the search button
	   driver.findElement(By.xpath("//body/div[@id='container']/div/div[@class='_3ybBIU']/div[@class='_1tz-RS']/div[@class='_3pNZKl']/div[@class='Y5-ZPI']/form[@class='_1WMLwI header-form-search']/div[@class='col-12-12 _2tVp4j']/button[@class='vh79eN']/*[1]")).click();
	   
	 //Print the price of the item
	   Thread.sleep(4000);
	   WebElement Text= driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[1]//div[1]//a[1]//div[2]//div[2]//div[1]//div[1]//div[1]"));
		String price=Text.getText();
	    System.out.println("Price of the item :" + price);
	   
	  
	   //Select the first item
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//div[contains(text(),'Vu Pixelight 138cm (55 inch) Ultra HD (4K) LED Sma')]")).click();
	   
	   //Add the item to the cart
	   String parent=driver.getWindowHandle();
		 Thread.sleep(4000);
		 for(String child:driver.getWindowHandles())
		   {
			 driver.switchTo().window(child);
			}
	     	Thread.sleep(2000);
	   driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
	    
	    //Increase the quantity of the item by one
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//button[text()='+']")).click();
	    
	    //Print the price of the item after increasing the quantity
	    Thread.sleep(2000);
	    WebElement Text1= driver.findElement(By.xpath("//span[@class='pMSy0p XU9vZa']"));
		String price1=Text1.getText();
	    System.out.println("Price of the item :" + price1);
	    
	}

}
