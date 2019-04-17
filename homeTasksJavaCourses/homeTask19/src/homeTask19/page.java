package homeTask19;

public class page {
	
	private WebDriver driver;
	
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

	@FindBy(xpath = ".//input[@type=\"search\"]")
	private WebElement searchField;

	@FindBy(xpath = ".//span[@class=\"xp__guests__count\"]")
	private WebElement guests;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]/div/div[2]/span[@class=\"bui-stepper__display\"]")
	private WebElement adultsCounter;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-add-button\"]")
	private WebElement plusButtonForAdults;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-subtract-button\"]")
	private WebElement minusButtonForAdults;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]/div/div[2]/span[@class=\"bui-stepper__display\"]")
	private WebElement roomsCounter;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-add-button\"]")
	private WebElement plusButtonForRooms;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-subtract-button\\")
	private WebElement minusButtonForRooms;

	@FindBy(xpath = ".//button[@class=\"sb-searchbox__button  \"]")
	private WebElement searchButton;

	@FindBy(xpath = ".//div[@class=\"xp__dates xp__group\"]")
	private WebElement datePicker;
	
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

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setCity(String city) {
		enterText(searchField, city);
	}

	private void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void setDatesRange() {
		datePicker.click();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 3);
		Date startDate = calendar.getTime();
		calendar.add(Calendar.DATE, 7);
		Date endDate = calendar.getTime();
		findDateElement(formatDate(startDate)).click();
		findDateElement(formatDate(endDate)).click();
	}

	public String formatDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	private WebElement findDateElement(String date) {
		return driver.findElement(By.xpath(".//td[@data-date=\"" + date + "\"]"));
	}

	public void setAdults(int numberOfAdults) {
		guests.click();
		int defaultNumberOfAdults = Integer.parseInt(adultsCounter.getText());
		int adultsDelta = defaultNumberOfAdults - numberOfAdults;
		if (adultsDelta < 0) {
			while (Integer.parseInt(adultsCounter.getText()) < numberOfAdults) {
				plusButtonForAdults.click();
			}

		} else if (adultsDelta > 0) {
			while (Integer.parseInt(adultsCounter.getText()) > numberOfAdults) {
				minusButtonForAdults.click();
			}
		}
	}

	public void performSearch(String city) {
		searchButton.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains(city));

	}

	public void setRooms(int numberOfRooms) {
		int defaultNumberOfRooms = Integer.parseInt(roomsCounter.getText());
		int roomsDelta = defaultNumberOfRooms - numberOfRooms;
		if (roomsDelta < 0) {
			while (Integer.parseInt(roomsCounter.getText()) < numberOfRooms) {
				plusButtonForRooms.click();
			}

		} else if (roomsDelta > 0) {
			while (Integer.parseInt(roomsCounter.getText()) > numberOfRooms) {
				minusButtonForRooms.click();
			}
		}
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
	

	public double parsePrice(String priceWithCurrency) {
		return Double.valueOf(priceWithCurrency.split(" ")[1].replace(",", ""));
	}
	
	public void openFirstHotel() {
		driver.findElement(By.xpath(".//a[@class=\"hotel_name_link url\"][1]")).click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
}
