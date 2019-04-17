package core;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps {
	private WebDriver driver;
	private HomePage homePage;

	public BookingSteps() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	}

	@Given("^I am on main page$")
	public void openMainPage() {
		driver.get(URL);
	}

	@When("^I type \"([^\"]*)\" in search field$")
	public void typeCity(String city) {
		homePage.typeCity(city);
	}

	@And("^I select \"([^\"]*)\" of adults$")
	public void selectNumberOfAdults(int adultsNumber) {
		homePage.setAdults(adultsNumber);
	}

	@And("^I select \"([^\"]*)\" of rooms$")
	public void selectNumberOfRooms(int roomsNumber) {
		homePage.setRooms(roomsNumber);
	}

	@And("^I click Search button$")
	public void search() {
		homePage.performSearch();
	}

	@Then("^I see hotels in search results$")
	public void ifSearchReturnedResults() {
		Assert.assertTrue(searchResultsPage.getSearchResults().size() > 0);
		driver.quit(); 
	}

	@And("^I select sorting by stars descending$")
	public void setSortingByStarsDesc() {
		searchResultsPage.setSortingByStarsDesc();
	}

	@And("^I open details of first hotel$")
	public void openFirstHotelDetails() {
		searchResultsPage.openTopRatedHotel();
	}

	@Then("^I see that hotel rating is higher than \"([^\"]*)\"$")
	public void compareHotelRating(double rating) {
		Assert.assertTrue(hotelDetailsPage.getRating() >= rating);
		driver.quit(); 
	}
}
