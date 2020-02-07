package in.tripadvisor.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository of TripAdvisor Home Page.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class HomePage
{
    /* Defining all WebElements of the page */
    @FindBy(xpath="//span[text()='Search']")
    private WebElement searchNavIcon;
	
    @FindBy(id="mainSearch")
    private WebElement dynamicSearchTB1;
	
    @FindBy(xpath="(//input[@name='q'])[3]")
    private WebElement dynamicSearchTB2;
	
    @FindBy(id="SEARCH_BUTTON_CONTENT")
    private WebElement searchBtn;
	
    /* Defining other members of the class */
    private WebDriver driver;
	
	
    /* Initialize all the elements of the page */
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
    /* Actions to be performed on the page */
    /**
     * Write the given name in search textbox and click on the 'Search' button to find the desired product.
     * 
     * @param hotelName Name of the hotel to be searched
     * @return The reference of next page to be loaded
     */
    public SearchResultsPage search(String hotelName)
    {
        try
        {
            searchNavIcon.click();
            dynamicSearchTB1.sendKeys(hotelName);
            searchBtn.click();
        }
        catch (NoSuchElementException e)
        {
            dynamicSearchTB2.sendKeys(hotelName, Keys.ENTER);
        }
	
        return new SearchResultsPage(driver);
    }
}
