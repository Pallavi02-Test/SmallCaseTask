package testscript;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keywords {
	static  FirefoxDriver driver;
	static Properties prop;
	static  FileInputStream file;
	public void openbrowser()throws Exception {
		System.setProperty("webdriver.gecko.driver",".//driver//geckodriver.exe");
		driver=new FirefoxDriver();
		file=new FileInputStream("C:\\Users\\Pavan\\eclipse-workspace\\SmallCase\\src\\Objectrepository\\ObjectRepository.properties");
		prop=new Properties();
		prop.load(file);	
	}
	public void navigate(String Data) throws InterruptedException {
		driver.get(Data);
	}
	public void click(String objectName) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
	}
	public void input(String objectName,String Data) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(Data);
	}
	public void switchwindow(String objectName) throws InterruptedException {
		 Thread.sleep(2000);
		 String parent=driver.getWindowHandle();
		 Thread.sleep(4000);
		 for(String child:driver.getWindowHandles())
		   {
			 driver.switchTo().window(child);
			}
	     	Thread.sleep(2000);
		    driver.findElement(By.xpath(prop.getProperty(objectName))).click();
	}
	public void gettext(String objectName) throws InterruptedException {
		Thread.sleep(6000);
		WebElement Text= driver.findElement(By.xpath(prop.getProperty(objectName)));
		String price=Text.getText();
	    System.out.println("Price of the item :" + price);
	}
	public void navigateTo(String Data)throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		driver.get(Data);
	}	
	public void comparePrice(){
		WebElement price1=driver.findElementByXPath("//span[@class='pMSy0p XU9vZa']");
		String p1=price1.getText();
		int a=Integer.parseInt(p1);
		WebElement price2=driver.findElementByXPath("//div[@class='a-row a-spacing-micro']//span[contains(text(),'28,900.00')]");
		String p2=price2.getText();
		int b=Integer.parseInt(p2);
		if(a < b) {
			System.out.println("The Item from the flipkart is cheaper" +a);
		}
		else {
			System.out.println("The Item from the amazon is cheaper" +b);
		}
	}
}
	
	
	


