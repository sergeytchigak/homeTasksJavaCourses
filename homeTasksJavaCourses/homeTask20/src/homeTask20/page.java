package homeTask20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class page {
	
	private static final int TIMEOUT = 10;
	
	@FindBy(xpath = ".//div[@id=\"filter_price\"]/div[2]/a[1]/input[@class=\"bui-checkbox__input js-bui-checkbox__input\"]")
	private WebElement filterLowestPriceCheckbox;

	@FindBy(xpath = ".//li[@class=\" sort_category   sort_review_score_and_price \"]")
	private WebElement sortingByScoreAndPrice;

	@FindBy(xpath = ".//div[@id=\"filter_price\"]/div[2]/a[5]/input[@class=\"bui-checkbox__input js-bui-checkbox__input\"]")
	private WebElement filterHighestPriceCheckbox;

	@FindBy(xpath = ".//li[@class=\" sort_category   sort_price \"]")
	private WebElement sortingByLowestPrice;

	@FindBy(xpath = "(.//td[@class=\"roomPrice  sr_discount \"])[1]/div/strong/b")
	private WebElement priceIfTwoAdultsSelected;

	@FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[2]/div/div[2]/div/strong/div/b")
	private WebElement priceIfMoreThatTwoAdultsSelected;
	
	@FindBy(xpath = ".//input[@id=\"lastname\"]")
	private WebElement lastNameField;

	@FindBy(xpath = ".//input[@id=\"email\"]")
	private WebElement emailField;

	@FindBy(xpath = ".//input[@id=\"email_confirm\"]")
	private WebElement emailConfirmationField;

	@FindBy(xpath = ".//button[@name=\"book\"]")
	private WebElement nextStep;

	@FindBy(xpath = ".//input[@id=\"cc_number\"]")
	private WebElement cardNumberField;

	@FindBy(xpath = ".//input[@id=\"cc_cvc\"]")
	private WebElement cvcCodeField;

	@FindBy(xpath = ".//p[@id=\"bp_form_cc_number_msg\"]")
	private WebElement InvalidCardMunberMessage;
	
	@FindBy(xpath = "(.//select[@class=\"hprt-nos-select\"])[1]")
	private WebElement roomsDropdwn;

	@FindBy(xpath = ".//button[@data-tooltip-class=\"submit_holder_button_tooltip\"]")
	private WebElement reserveButton;

	@FindBy(xpath = ".//h2[@class = \"hp__hotel-name\"]")
	private WebElement hotelName;

	@FindBy(xpath = "(.//button[@id=\"hp_book_now_button\"])[2]")
	private WebElement reserveNowButton;

	@FindBy(xpath = ".//div[@id=\"available_rooms\"]")
	private WebElement availableRooms;

	@FindBy(xpath = ".//span[@data-name=\"ph-addressbook\"]")
	private WebElement linkToConacts;

	@FindBy(xpath = ".//a[@class=\"menu__option__link js-add-label\"]")
	private WebElement createGroupLink;

	@FindBy(xpath = ".//div[@class=\"form__row__widget\"]/input[@class=\"form__field js-input\"]")
	private WebElement groupNamefield;

	@FindBy(xpath = ".//button[@class=\"btn btn_main confirm-ok\"]")
	private WebElement confirmCreateGroup;

	@FindBy(xpath = ".//div[@id=\"js-add-contact\"]")
	private WebElement addContactsButton;

	@FindBy(xpath = ".//input[@id=\"emails_0\"]")
	private WebElement emailField;

	@FindBy(xpath = ".//input[@id=\"firstname\"]")
	private WebElement firstNameField;

	@FindBy(xpath = ".//div[@data-name=\"submit\"]")
	private WebElement saveButton;

	private WebElement getGroupLink(String groupName) {
		return driver.findElement(
				By.xpath("//*[contains(@href, \"/addressbook/label/\")]//*[text()=\"" + groupName + "\"]"));
	}

	public AddressBookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openAddressBook() {
		linkToConacts.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("addressbook"));
	}

	public void createContactsGroup(String groupName) {
		createGroupLink.click();
		groupNamefield.sendKeys(groupName);
		confirmCreateGroup.click();
		this.safe(driver -> {
			getGroupLink(groupName).getText();
			return true;
		});
	}

	public void addContactsToGroup(String groupName, String firstName, String email) {
		this.getGroupLink(groupName).click();
		addContactsButton.click();
		enterText(firstNameField, firstName);
		enterText(emailField, email);
		saveButton.click();
	}
	
	public HotelDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void reserveHotel() throws InterruptedException {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hotelName));
		reserveNowButton.click();
		Thread.sleep(5000);
		Select roomsDropdown = new Select(roomsDropdwn);
		roomsDropdown.getOptions().get(1).click();
		reserveButton.click();
	}
	
	public PersonalDetailsForReservationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void eneterPersonalDetails(String lastName, String email) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Your Details"));
		((JavascriptExecutor) driver).executeScript("document.getElementById('lastname').scrollIntoView(true)");
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		emailConfirmationField.sendKeys(email);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		nextStep.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Final Details"));
	}

	public boolean isInvalidCardNumberDisplayed(String cardNumber) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('cc_number').scrollIntoView(true)");
		cardNumberField.sendKeys(cardNumber);
		cvcCodeField.click();
		return driver.findElements(By.id("bp_form_cc_number_msg")).size() != 0;
	}
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> filterHotelsWithLowestPrice() {
		scrollTableToFilters();
		Actions action = new Actions(driver);
		action.moveToElement(filterLowestPriceCheckbox).click().build().perform();
		List<WebElement> searchResults = driver.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
		return searchResults;
	}

	public void scrollTableToFilters() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('filter_price').scrollIntoView(true)");
	}

	public double getPriceOfTopRatedHotel() {
		sortingByScoreAndPrice.click();
		waitForLoading();
		String priceWithCurrency = priceIfTwoAdultsSelected.getText();
		return parsePrice(priceWithCurrency);
	}
	
	public void waitForLoading() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath(".//div[@class=\"sr-usp-overlay__loading\"]")));
	}

	public void filterHotelsWithHighestPrice() {
		scrollTableToFilters();
		Actions action = new Actions(driver);
		action.moveToElement(filterHighestPriceCheckbox).click().build().perform();
		waitForLoading();
	}

	public double getPriceOfHotelWithLowestPrice() {
		sortingByLowestPrice.click();
		waitForLoading();
		String priceWithCurrency = priceIfMoreThatTwoAdultsSelected.getText();
		return parsePrice(priceWithCurrency);
	}

	public double parsePrice(String priceWithCurrency) {
		return Double.valueOf(priceWithCurrency.split(" ")[1].replace(",", ""));
	}
	
	public void openFirstHotel() {
		driver.findElement(By.xpath(".//a[@class=\"hotel_name_link url\"][1]")).click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
}
