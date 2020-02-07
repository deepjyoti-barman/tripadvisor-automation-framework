package in.tripadvisor.utils;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import in.tripadvisor.base.IAutoConstant;

/**
 * It is collection of commonly used methods throughout the framework.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public class CommonLib implements IAutoConstant
{	
    /**
     * Set the waiting time for loading a page, loading an element and loading a script.
     * 
     * @param driver Current driver reference in use 
     */
    public void setElementPageScriptLoadTimeout(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }
	
	
    /**
     * Set the waiting time for loading a page, loading an element and loading a script taking parameters from user.
     * 
     * @param driver Current driver reference in use
     * @param iwTimeoutInSecs Implicit wait timeout in seconds
     * @param plTimeoutInSecs Page load timeout in seconds
     * @param sTimeoutInSecs Script timeout in seconds
     */
    public void setElementPageScriptLoadTimeout(WebDriver driver, long iwTimeoutInSecs, long plTimeoutInSecs, long sTimeoutInSecs)
    {
        driver.manage().timeouts().implicitlyWait(iwTimeoutInSecs, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(plTimeoutInSecs, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(sTimeoutInSecs, TimeUnit.SECONDS);
    }
	
	
    /**
     * Make the script wait until the page loading process is complete.
     * 
     * @param driver Current driver reference in use
     * @throws InterruptedException
     */
    public void waitForPageToLoadCompletely(WebDriver driver) throws InterruptedException
    {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
            
        while (true)
        {
            String loadProgress = jse.executeScript("return document.readyState").toString();
                
            if (loadProgress.equalsIgnoreCase("complete"))
                break;
            else
                Thread.sleep(500);
        }
    }
	
	
    /**
     * Switch the control to last child window open in browser.
     * 
     * @param driver Current driver reference in use
     */
    public void switchToLastChildWindow(WebDriver driver)
    {
        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> windowList = new ArrayList<String>(windows);

        driver.switchTo().window(windowList.get(windowList.size() - 1));
    }
	
	
    /**
     * Move the mouse cursor to the given web element and click on it.
     * 
     * @param driver Current driver reference in use
     * @param element Element to hover mouse to 
     */
    public void hoverOnElementAndClick(WebDriver driver, WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
	
	
    /**
     * Move the mouse cursor to the given web element, then move towards given offset towards x-axis and y-axis and click on it.
     * 
     * @param driver Current driver reference in use
     * @param element Element to hover mouse to
     * @param x Offset towards the x-axis from top-left corner
     * @param y Offset towards the y-axis from top-left corner
     */
    public void hoverOnElementAndClick(WebDriver driver, WebElement element, int x, int y)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element, x, y).click().build().perform();
    }
	
	
    /**
     * Scroll down until the given element comes on top of the viewport.
     * 
     * @param driver Current driver reference in use
     * @param element Element to scroll down to
     */
    public void scrollToElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", element);
    }
}
