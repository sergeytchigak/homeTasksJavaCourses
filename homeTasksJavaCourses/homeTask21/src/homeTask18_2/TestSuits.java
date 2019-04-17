package homeTask18_2;

import homeTask18_2.bookingPageElements;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSuits {
	
	private WebDriver driver;
	private bookingPageElements bookingPageElements;
	
	@Before
	public void before() {
		String exePath = "/Users/s.chigak/Documents/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		bookingPageElements = new bookingPageElements(driver);
	}
	
	@Test
	public void Tast18_1() {
		driver.get("http://booking.com");
		bookingPageElements.inputDates();
		Assert.assertTrue(bookingPageElements.hotelNumberNotEmpty());
	}
	
	@Test
	public void Tast18_2() {
		driver.get("http://booking.com");
		bookingPageElements.filterBestHotel();
		Assert.assertTrue(bookingPageElements.hotelRaitingIsHigh());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
