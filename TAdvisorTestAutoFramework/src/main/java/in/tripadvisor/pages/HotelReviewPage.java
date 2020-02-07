package in.tripadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.tripadvisor.utils.CommonLib;

/**
 * Object repository of TripAdvisor Hotel Review Page.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class HotelReviewPage
{
    /* Defining all WebElements of the page */
    @FindBy(xpath="//h1[@id='HEADING']/../..//span[contains(text(), 'reviews')]")
    private WebElement linkToReviewsSection;
	
    @FindBy(xpath="//a[text()='Write a review']")
    private WebElement writeAReviewBtn;
	
    /* Defining other members of the class */
    private WebDriver driver;
    CommonLib lib = new CommonLib();
	
	
    /* Initialize all the elements of the page */
    public HotelReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
    /* Actions to be performed on the page */
    /**
     * Click on the Reviews Count link (i.e. 3457 Reviews) to get down to 'Reviews' Section, click on the 'Write a review' button and switches the control to the next window.
     * @return The reference of next page to be loaded
     */
    public UserReviewEditPage writeAReview()
    {
        linkToReviewsSection.click();
        writeAReviewBtn.click();
        lib.switchToLastChildWindow(driver);
		
        return new UserReviewEditPage(driver);
    }
}
