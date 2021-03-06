package com.main;


	import java.io.File;

	import java.io.IOException;
	import java.util.Iterator;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Cookie;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriver.Navigation;
	import org.openqa.selenium.WebDriver.Window;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverAPI {

		//example of navtgation interface

		static void navidateEx()
		{
			WebDriver driver = new FirefoxDriver();
			Navigation navigate = driver.navigate();
			navigate.to("http://www.ebay.com/");
			driver.findElement(By.linkText("Motors")).click();
			navigate.back();
			navigate.forward();
			navigate.refresh();
		}
		
		static void timeout()
		{
			WebDriver driver = new FirefoxDriver();
			Navigation navigate = driver.navigate();
			navigate.to("http://www.ebay.com/");
			long startTime = System.currentTimeMillis();
		   // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = driver.findElement(By.linkText("Fashion")); 
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, "Fashion"));
		
			
			long endTime = System.currentTimeMillis();
			long timeElapsed = endTime - startTime;
			System.out.println(timeElapsed);
			element.click();
		}
		
		static void windows()
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.pinterest.com/");
			Iterator<String> windows = driver.getWindowHandles().iterator();
			while(windows.hasNext())
			{
				String child = windows.next();
				driver.switchTo().window(child);
			}
			Window window = driver.manage().window();
			window.maximize();
			System.out.println("the size of window is : " + window.getSize() + " the postion is : " + window.getPosition());
			Dimension paramDimension = new Dimension(300, 300);
			window.setSize(paramDimension);
			Point paramPoint = new Point(100, 100);
			window.setPosition(paramPoint);
			System.out.println("the size of window is : " + window.getSize() + " the postion is : " + window.getPosition());
			
		}
		
		
		public static void manageAlerts()
		{
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.navigate().to("file:///C:/Users/Sampath/tryIt.html");
			
			WebElement element = driver.findElement(By.id("myID"));
			element.click();
			
			Alert alert   = driver.switchTo().alert();
			alert.accept();
			alert.dismiss();
			System.out.println("the text on alert is : " + alert.getText());
			
			
		}
		
		static void manageDragAndDrop()
		{
			WebDriver driver = new FirefoxDriver();
			driver.navigate().to("file:///C:/Users/Sampath/tryIt.html");
			
			WebElement from = driver.findElement(By.id("myID"));//our own html, not launched yet
			//WebElement to = driver.findElement(By.linkText("Fashion"));
			
			Actions builder = new Actions(driver);
			
			Action dragAndDrop = builder.clickAndHold(from).moveByOffset(600, 600).release().build();
			//builder.d
			dragAndDrop.perform();
		}
		static void managecookies(){
			WebDriver driver=new FirefoxDriver();
			driver.get("http://www.ebay.com/");
			Iterator<Cookie>cookies=driver.manage().getCookies().iterator();
			while(cookies.hasNext()){
				Cookie cookie=cookies.next();
				System.out.println(cookie.getName()+" "+cookie.getValue());
			}
			Cookie cookiess=new Cookie("why","me");
			driver.manage().addCookie(cookiess);
		}
		
		static void manageCookies()
		{
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("http://www.ebay.com/");
			Iterator<Cookie> cookies = driver.manage().getCookies().iterator();
			while(cookies.hasNext())
			{
				Cookie cookie = cookies.next();
				System.out.println("Name : " + cookie.getName() + "value : " + cookie.getValue());
			}
			
			Cookie newCookie = new Cookie("webdriver", "whitebox");
			driver.manage().addCookie(newCookie);
		
		
			
		}
		static void manageselect1(){
			WebDriver driver=new FirefoxDriver();
			driver.get("https://accounts.google.com/SignUp?service=mail&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-en");
			
            driver.findElement(By.xpath(".//*[@id='BirthMonth']/div")).click();
            driver.findElement(By.xpath(".//*[@id=':a']/div")).click();
          //  driver.findElement(By.xpath(".//*[@id='BirthMonth']/div[1]")).getText();
			
		driver.findElement(By.xpath(".//*[@id='BirthMonth']/div[1]")).click();
	System.out.println(driver.findElement(By.xpath("//div[@id=':6']")).getText());
		;
		}
		static void manageSelect11(){
			WebDriver driver = new FirefoxDriver();
			driver.get("https://edit.yahoo.com/registration?.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com&.src=ym&fsredirect=1&fs=bALLgXyHafCjd6TnH8rsz5dEb1rnJ6GSFSgBh7ddAdvdvhrzHcRgHga77oA9tL0_b6WxSA5B");
			 WebElement dropdown=driver.findElement(By.xpath("//*[@id='month']"));
			Select select = new Select(dropdown);
			select.selectByValue("1");
			File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			if(file.exists())
			{
				try {
					FileUtils.copyFile(file, new File("//Users//mns//Desktop//Innovapath//screen1.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		static void manageSelect()
		{
			WebDriver driver = new FirefoxDriver();
			driver.navigate().to("file:///C:/Users/Sampath/tryIt.html");//to be used for running a site on local machine, when its not yet launched
			WebElement dropDown = driver.findElement(By.name("users"));
			Select select = new Select(dropDown);
			select.selectByValue("tarandeep");
			
		}
		
		
		static void manageScreenShot() throws IOException
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("http://www.ebay.com/");
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			if(file.exists())
			{
				FileUtils.copyFile(file, new File("C:\\Users\\Sampath\\screen1.png"));}
			}
		
		public static void main(String[] args) throws IOException{
			manageSelect11();
			//managecookies();
			//manageScreenShot();
			//manageSelect();
			 //manageCookies();
			//manageDragAndDrop();
			//manageAlerts();
			//windows();
			//timeout();
			//navidateEx();
		//	System.out.println("the url of page is " + driver.gehttp://www.ebay.com/motorstCurrentUrl());
			//System.out.println("the page source of the website is : " + driver.getPageSource());
			//System.out.println("The title of page is : " + driver.getTitle());
			
			/*List<WebElement> elements = driver.findElements(By.cssSelector("#mainMenu li a"));
			System.out.println("the elemnt size : " + elements.size());
			for(WebElement element : elements)
			{
				System.out.println("the attribute values are : " + element.getAttribute("href"));
				System.out.println("the text on the element : " + element.getText());
				System.out.println("the size of the element : " + element.getSize());
				System.out.println("the location of an element is : " + element.getLocation());
				System.out.println("the css value of an element is : " + element.getCssValue("color"));
				System.out.println("the tag name of an element is : " + element.getTagName());
				
			} */
			
			
		}
		
	}



