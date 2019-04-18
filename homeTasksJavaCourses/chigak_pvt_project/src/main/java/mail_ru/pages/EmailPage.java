package mail_ru.pages;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage extends Page {
	
	private static final int TIMEOUT = 16;

	@FindBy(xpath = "(.//span[text() = \"Написать письмо\"])[1]")
	private WebElement newEmailButton;

	@FindBy(xpath = " .//textarea[@data-original-name = \"To\"]")
	private WebElement recepientField;

	@FindBy(xpath = ".//input[@name = \"Subject\"]")
	private WebElement subjectField;

	@FindBy(xpath = ".//textarea[@name=\"Body\"]")
	private WebElement bodyField;

	@FindBy(xpath = "(.//div[@data-name=\"send\"])[1]")
	private WebElement sendButton;

	@FindBy(xpath = ".//div[@class=\"message-sent__title\"]")
	private WebElement emailIsSentMessage;
	
	@FindBy(xpath = ".//div[@data-name=\"saveDraft\"]")
	private WebElement saveDraftButton;
	
	@FindBy (xpath = ".//div[@data-mnemo=\"saveStatus\"]")
	private WebElement draftSavedMessage;
	
	@FindBy(xpath = "(.//a[@href=\"/messages/inbox/\"])[1]")
	WebElement linkToInboxFolder;
	
	@FindBy(xpath = "(.//span[text() = \"Написать письмо\"])[1]")
	private WebElement newEmailButton2;

	@FindBy(xpath = " .//textarea[@data-original-name = \"To\"]")
	private WebElement recepientField2;

	@FindBy(xpath = ".//input[@name = \"Subject\"]")
	private WebElement subjectField2;

	@FindBy(xpath = ".//textarea[@name=\"Body\"]")
	private WebElement bodyField2;

	@FindBy(xpath = "(.//div[@data-name=\"send\"])[1]")
	private WebElement sendButton2;

	@FindBy(xpath = ".//div[@class=\"message-sent__title\"]")
	private WebElement emailIsSentMessage2;

	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]/div/div[@class=\"b-checkbox__box\"])[1]")
	WebElement firstEmailCheckbox;

	@FindBy(xpath = "(.//div[@data-name=\"spam\"])[1]")
	WebElement moveToSpamButton;

	@FindBy(xpath = ".//button[@class=\"btn b-spam-confirm__btn\"]")
	WebElement confirmMoveToSpam;

	@FindBy(xpath = "(.//div[@data-group=\"letters-more\"])[1]")
	WebElement moreDropdown;

	@FindBy(xpath = ".//a[@data-name=\"flag_no\"]")
	WebElement unflagAll;

	@FindBy(xpath = "(.//div[@data-name=\"remove\"])[1]")
	WebElement deleteButton;
	
	@FindBy(xpath = "(.//div[@data-name=\"noSpam\"])[1]")
	WebElement notSpamButton;

	@FindBy(xpath = "(//*[(@data-cache-key) and not(contains(@style,\"display: none\"))]//div[@data-name=\"remove\"])[1]")
	WebElement deleteAllButton;

	@FindBy(xpath = ".//div[@data-id]/a[@href=\"/messages/spam/\"]")
	WebElement linkToSpam;

	@FindBy(xpath = "//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]")
	List<WebElement> emailCheckboxe;
	
	@FindBy(xpath = "(.//span[@class=\"b-datalist__empty__text\"])[1]")
	WebElement emptyInboxLabel;
	
	@FindBy(xpath = "//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]")
		    List<WebElement> emailCheckboxes;
	
	@FindBy(xpath = ".//div[@data-act=\"flag\" and contains(@class, \"b-flag_yes\")]")
	List<WebElement> flaggedEmails;
	
	@FindBy (xpath = ".//div[@data-act=\"flag\" and not(contains(@class, \"b-flag_yes\"))]")
	List<WebElement> notFlaggedEmails;

	public EmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void createNewEmail(String recipient, String subject, String body) {
		new WebDriverWait(driver, TIMEOUT).ignoring(ElementNotVisibleException.class).until(ExpectedConditions.visibilityOf(newEmailButton));
		newEmailButton.click();
		enterText(recepientField, recipient);
		enterText(subjectField, subject);
		enterTinyMCEText(body);
	}
	
	public boolean sendEmail() {
		sendButton.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("sendmsgok"));
		return emailIsSentMessage.isDisplayed();
	}
	
	public void saveDraft() {
		saveDraftButton.click();
	}
	
	public boolean isDraftSaved() {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(draftSavedMessage));
		return draftSavedMessage.isDisplayed();
	}
	
	public void openInboxFolder() {
		this.safe(driver -> {
			this.linkToInboxFolder.click();
			return true;
		});

		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("inbox"));
	}

	public void moveFirstEmailToSpam() {
		Actions action = new Actions(driver);
        action.moveToElement(emailCheckboxes.get(0)).build().perform();
        emailCheckboxes.get(0).click();
		moveToSpamButton.click();
		try{
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(confirmMoveToSpam));
			confirmMoveToSpam.click();
		} catch(NoSuchElementException ex) {
			ex.printStackTrace();
		}
		
	}

	public void markEmailWithFlag(int numberofEmailsToBeMarked) {

		driver.navigate().refresh();
		for (int i = 0; i <= numberofEmailsToBeMarked - 1; i++) {
			notFlaggedEmails.get(i).click();
		}
	}

	public int getNumberOfFlaggedEmails() {
		return flaggedEmails.size();
	}

	public void unflagAllInboxEmails() {
		selectAllInboxEmails();
		moreDropdown.click();
		unflagAll.click();
	}

	public void deleteAllEmailsFromInbox() {
		openInboxFolder();
		selectAllInboxEmails();
		deleteButton.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOf(emptyInboxLabel));
	}
	
	public void openSpamFolder() {
		this.safe(driver -> {
			this.linkToSpam.click();
			return true;
		});
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("spam"));
	}

	public void emptySpamFolder() {
		openSpamFolder();
		selectAllInboxEmails();
		this.safe(driver -> {
			deleteAllButton.click();
			return true;
		}

	public Boolean sendNewEmail(String recipient, String subject, String body) {
		new WebDriverWait(driver, TIMEOUT).ignoring(ElementNotVisibleException.class).until(ExpectedConditions.visibilityOf(newEmailButton));
		newEmailButton.click();
		enterText(recepientField, recipient);
		recepientField.sendKeys(Keys.ENTER);
		enterText(subjectField, subject);
		enterTinyMCEText(body);
		sendButton.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("sendmsgok"));
		return emailIsSentMessage.isDisplayed();
	}
}
