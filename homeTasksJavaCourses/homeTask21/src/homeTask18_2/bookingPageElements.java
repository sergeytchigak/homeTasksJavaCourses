package homeTask18_2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bookingPageElements {
	
private WebDriver driver;
	
	private WebDriverWait wait;
	
	public bookingPageElements (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"ss\"]")
	WebElement cityField;
	
	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div")
	WebElement dateField;
	
	@FindBy(xpath = ".//td [@data-date = \"2019-04-10\"]")
	WebElement fromField;
	
	@FindBy(xpath = ".//td [@data-date = \"2019-04-20\"]")
	WebElement toField;
	
	@FindBy(xpath = ".//button[@data-sb-id=\"main\"]")
	WebElement searchButton;
	
	@FindBy(xpath = ".//button[@data-sb-id=\"main\"]")
	WebElement hotelNumber;
	
	@FindBy(xpath = ".//button[@id='sortbar_dropdown_button']")
	WebElement raitingDropdown;
	
	@FindBy(xpath = ".//a[@data-category='bayesian_review_score']")
	WebElement raitingButton;
	
	@FindBy(xpath=".//div[@id='sr_notice_minimum_number_of_reviews']")
	WebElement verificationElement;
	
	@FindBy(xpath="//*[@id=\"right\"]/div[2]/ul/li[1]/a")
	WebElement verificationLink;
	
	@FindBy(xpath="//a[@class='hotel_name_link url']")
	List<WebElement> listOfHotels;
	
	public void inputDates() {
		cityField.sendKeys("Москва");
		dateField.click();
		fromField.click();
		toField.click();
		searchButton.click();
	}
	
	public boolean hotelNumberNotEmpty() {
		return hotelNumber.isDisplayed();
	}
	
	public void filterBestHotel() {
		inputDates();
		raitingDropdown.click();
		raitingButton.click();
		wait.until(ExpectedConditions.visibilityOf(verificationElement));
	    WebElement topHotel = listOfHotels.get(0);
		topHotel.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOf(verificationLink));
	}
	
	public boolean hotelRaitingIsHigh() {
		List<WebElement> ratingList = driver.findElements(By.xpath(".//*[@class='bui-review-score__badge']"));
		WebElement TopHotelRating = ratingList.get(0);
		double raiting = (Double.valueOf(TopHotelRating.getText().replace(",", ".")));
		return (raiting >= 9);
	}

}
