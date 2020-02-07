package in.tripadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.tripadvisor.utils.CommonLib;

/**
 * Object repository of TripAdvisor Search Results Page.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class SearchResultsPage
{
    /* Defining all WebElements of the page */
    @FindBy(xpath="//span[contains(.,'Top result matching')]/ancestor::div[@class='search-results-list']/div[2]//div[@class='result-title']/span")
    private WebElement topResultOption1;
	
    /* Defining other members of the class */
    private WebDriver driver;
    CommonLib lib = new CommonLib();
	
	
    /* Initialize all the elements of the page */
    public SearchResultsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
    /* Actions to be performed on the page */
    /**
     * Click on the top most result (i.e. option) found on the webpage and switches the control to next window.
     * 
     * @return The reference of next page to be loaded
     */
    public HotelReviewPage clickOnFirstOption()
    {
        topResultOption1.click();
        lib.switchToLastChildWindow(driver);

        return new HotelReviewPage(driver);
    }
}
