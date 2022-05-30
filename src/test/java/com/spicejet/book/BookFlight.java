package com.spicejet.book;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookFlight {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{

		FileInputStream file = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook book = WorkbookFactory.create(file);
		String fromName = book.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		String destName = book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(fromName);
		System.out.println(destName);
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver(opt);
		driver1.manage().window().maximize();
		driver1.get("https://www.spicejet.com/");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1otgn73' and @data-testid='round-trip-radio-button']")).click();
		driver1.findElement(By.xpath("//div[.='From']/following-sibling::div/input[@type='text']")).sendKeys(fromName);
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[.='To']/following-sibling::div/input[@type='text']")).sendKeys(destName);
		Thread.sleep(2000);        
		driver1.findElement(By.xpath("//div[.='20']")).click();     //departure date
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//div[@data-testid='undefined-month-June-2022']//div[.='20']")).click();    	//return date
		driver1.findElement(By.xpath("//div[.='Passengers']")).click();
        driver1.findElement(By.xpath("//div[.='Children']/../../div/div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid']")).click();
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
		Thread.sleep(1000);
		//driver1.findElement(By.xpath("//div[.='Search Flight']/following-sibling::div")).click();
		driver1.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		Thread.sleep(1000);
		
		//driver1.findElement(By.xpath("//div[@data-testid='spiceflex-flight-select-radio-button-2']")).click();
		for(int i=0;i<3;i++) 
		{
			JavascriptExecutor js = (JavascriptExecutor)driver1;
			js.executeScript("window.scrollBy(0,500)");
		}
		
		
		
		 //driver1.findElement(By.xpath("//div[.='SG 537']/../../../..//div[@data-testid='spicemax-flight-select-radio-button-3']")).click();

		 driver1.findElement(By.xpath("//div[@data-testid='continue-search-page-cta']")).click();
	 
		
		
		//booking
	   /* driver1.findElement(By.xpath("//div[@data-testid='title-contact-detail-card']")).click();
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[.='Miss']")).click();
		driver1.findElement(By.xpath("//input[@type='text' and @data-testid='first-inputbox-contact-details']")).sendKeys("Roopa");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//input[@type='text' and @data-testid='last-inputbox-contact-details']")).sendKeys("TM");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//input[@type='text' and @data-testid='contact-number-input-box']")).sendKeys("9481567751");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//input[@type='text' and @data-testid='emailAddress-inputbox-contact-details']")).sendKeys("abc1@gmail.com");
		Thread.sleep(1000);
		//driver1.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//div[.='India']")).click();
		for(int i=0;i<2;i++) 
		{
			JavascriptExecutor js = (JavascriptExecutor)driver1;
			js.executeScript("window.scrollBy(0,500)");
		}
		
		driver1.findElement(By.xpath("//div[@data-testid='traveller-0-title-field']")).click();
		driver1.findElement(By.xpath("//div[.='Miss']")).click();
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@data-testid='traveller-0-first-traveller-info-input-box']")).sendKeys("sree");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@data-testid='traveller-0-last-traveller-info-input-box']")).sendKeys("M");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@data-testid='sc-member-mobile-number-input-box']")).sendKeys("8478378388");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[.='Select']")).click();
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[.='Miss']")).click();
		driver1.findElement(By.xpath("//div[@data-testid='traveller-1-first-traveller-info-input-box']")).sendKeys("varshitha");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@data-testid='traveller-1-last-traveller-info-input-box']")).sendKeys("s");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@data-testid='traveller-info-continue-cta']")).click();*/
		
}
}
