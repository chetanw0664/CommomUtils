
	package CommonUtils;

	import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



	public class BaseClass1 {
		
		
		WebDriver d= new ChromeDriver();

		PropertyFileUtils putil=new PropertyFileUtils();// to getting data from property file
		WebDriverUtil wutil= new WebDriverUtil();// to getting created method of webDriver
		
		@BeforeSuite
		public void BS() {
			System.out.println("Connect to Database ");
			
		}
		
		@BeforeClass
		public void BC() throws IOException{
			//@Before Class using to launching application
			String URL = putil.getDataFromPropertyFile("url");

			
					 wutil.maximize(d);
			 wutil.implicitwait(d);
			 d.get(URL);
			
		}
		@BeforeMethod
		public void BM() throws IOException {
			String USERNAME = putil.getDataFromPropertyFile("username");
			String PASSWORD = putil.getDataFromPropertyFile("Password");

			
			d.findElement(By.name("user_name")).sendKeys(USERNAME);
			d.findElement(By.name("user_password")).sendKeys(PASSWORD);
			d.findElement(By.id("submitButton")).click();
		}
		@AfterMethod
			public void AM() throws InterruptedException {
			//@After method is used to sign out from the application
			Thread.sleep(2000);
			WebElement signout = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wutil.mousehover(d, signout);
			// to click on sign Out
			d.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
			}
		@AfterClass
		public void AC() {
			//@After class is used to close the browser
			d.quit();
			
		
		}
		@AfterSuite
		public void AS() {
			System.out.println("Disconect from Database");
			
		}

	}


