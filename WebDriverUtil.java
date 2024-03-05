package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	
	public WebDriver d; //make it d as globle variable because we want work in 
	// this method for maximize the window
	public void maximize(WebDriver d) { //in created method pass the parameter
		d.manage().window().maximize();
	}
	// this method for implicit wait
	public void implicitwait(WebDriver d) {// in created method we can pass the parameter
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	// this method for select class drop down
	public void handledropdown(WebElement element,String targetedelement) {
		Select s=new Select(element);
		s.selectByVisibleText(targetedelement);

	}
	public void mousehover(WebDriver d,WebElement element) {
		Actions a= new Actions(d);
		a.moveToElement(element);
		a.perform();
		 
		
	}
	public void switchWindow(WebDriver d, String expectedurl ) {
		Set<String> ids = d.getWindowHandles();
		for(String a:ids) {
			String actualurl = d.switchTo().window(a).getCurrentUrl();
			
			if(actualurl.contains(expectedurl)) {
				break;
		}
		}
	}
			public File screenshot(WebDriver d,String ScreenShotName) throws IOException {
				TakesScreenshot ts= (TakesScreenshot)d;
				File tempfile=ts.getScreenshotAs(OutputType.FILE);
				File destfile= new File("./ScreenShot/"+ScreenShotName+".png");
				FileUtils.copyFile(tempfile, destfile);
				return destfile;
				
				
			}
			
	

	}

