package in.tripadvisor.testscripts;

import org.testng.annotations.Test;

import in.tripadvisor.base.BaseTest;
import in.tripadvisor.pages.HotelReviewPage;
import in.tripadvisor.pages.SearchResultsPage;
import in.tripadvisor.pages.UserReviewEditPage;

/**
 * Test class which will contain test methods to write a review on desired hotels.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public class WriteAReviewTest extends BaseTest
{
    /* Test to write a review on "Club Mahindra" in TripAdvisor with 5-star ratings and submit it */
    @Test
    public void tc_001_writeAndSubmitReview() throws InterruptedException
    {
        String hotelName = "Club Mahindra";
            
        SearchResultsPage tAdvisorSRP  = tAdvisorHP.search(hotelName);
        HotelReviewPage tAdvisorHRP    = tAdvisorSRP.clickOnFirstOption();
        UserReviewEditPage tAdvisorREP = tAdvisorHRP.writeAReview();
            
        tAdvisorREP.rateWith5Stars("Outstanding Experience", "Great location, tasty meals and really pleasant and clean rooms - everything that one requires");
    }
}
