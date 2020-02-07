package in.tripadvisor.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.tripadvisor.utils.CommonLib;

/**
 * Object repository of TripAdvisor User Review Edit Page.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class UserReviewEditPage
{
    /* Defining all WebElements of the page */
    @FindBy(id="bubble_rating")
    private WebElement overallRatingBubble;
	
    @FindBy(id="ReviewTitle")
    private WebElement reviewTitleTB;
	
    @FindBy(id="ReviewText")
    private WebElement reviewTextTA;
	
    @FindBy(id="DQ_RATINGS")
    private WebElement hotelRatingsHeader;
	
    @FindBy(xpath="(//div[@class='ratingBubbleTable']//span)[position()<=3]")
    private List<WebElement> visuallyRateableBubbles;
	
    @FindBy(xpath="//div[text()='Submit your review']")
    private WebElement submitReviewHeader;
	
    @FindBy(id="noFraud")
    private WebElement certifyReviewCB;
	
    /* Defining other members of the class */
    private WebDriver driver;
    CommonLib lib = new CommonLib();
	
	
    /* Initialize all the elements of the page */
    public UserReviewEditPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
    /* Actions to be performed on the page */
    /**
     * Click on the 5th star of 'Your overall rating of this property' bubble, write the given texts in 'Title of your review' and 'Your review' textboxes, scroll down till 'Hotel Ratings' section, rate all the option available under the section with 5 stars on each bubble, scroll down once again till 'Submit your review' section and finally click on the certify review checkbox. 
     * 
     * @param title Title text to be written on the 'Title of your review' textbox
     * @param text Descriptive text to be written on the 'Your review' textbox
     */
    public void rateWith5Stars(String title, String text)
    {
        lib.hoverOnElementAndClick(driver, overallRatingBubble, 50, 0);
        reviewTitleTB.sendKeys(title);
        reviewTextTA.sendKeys(text);
        lib.scrollToElement(driver, hotelRatingsHeader);
            
        for (WebElement bubble : visuallyRateableBubbles)
        {
            lib.hoverOnElementAndClick(driver, bubble, 50, 0);
        }
            
        lib.scrollToElement(driver, submitReviewHeader);
        certifyReviewCB.click();
    }
}