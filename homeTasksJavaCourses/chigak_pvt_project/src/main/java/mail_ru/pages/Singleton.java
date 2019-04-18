package mail_ru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {

	public static WebDriver driver;
	
	private Singleton() {
		
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}
	public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }
}
