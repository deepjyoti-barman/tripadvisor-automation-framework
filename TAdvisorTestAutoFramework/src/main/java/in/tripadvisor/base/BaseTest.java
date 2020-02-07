package in.tripadvisor.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import in.tripadvisor.pages.HomePage;
import in.tripadvisor.utils.CommonLib;
import in.tripadvisor.utils.FileLib;

/**
 * Parent of every test class. It is used to configure, setup and terminate the execution of test methods. 
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public class BaseTest implements IAutoConstant
{
    static
    {
        System.setProperty(CHROME_KEY, CHROME_VALUE);
        System.setProperty(GECKO_KEY, GECKO_VALUE);
    }
	
    public CommonLib lib = new CommonLib();
    public FileLib fLib  = new FileLib();
    public WebDriver driver;
    public HomePage tAdvisorHP;
    
    
    /**
     * Opens up the desired browser window.
     * 
     * @throws IOException
     */
    @BeforeClass
    public void openBrowser() throws IOException
    {
        String browser = fLib.getDataFromProperties("browser");
        System.out.println("------------------- Launching the browser -------------------");
	
        if (browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            System.out.println("We do not support this browser");
    }
    
    
    /**
     * Loads the required application on the browser.
     * 
     * @throws IOException
     * @throws InterruptedException 
     */
    @BeforeMethod
    public void loadApp() throws IOException, InterruptedException
    {
        System.out.println("------------------- Loading the Application -------------------");
        lib.setElementPageScriptLoadTimeout(driver, 10, 60, 10);
        driver.manage().window().maximize();
	
        tAdvisorHP = navigateToTripAdvisor();
    }
    
    
    /**
     * Closes all currently open browser windows after a delay of 10 seconds.
     * @throws InterruptedException 
     */
    @AfterClass
    public void closeBrowser() throws InterruptedException
    {
        System.out.println("------------------- Closing all browser windows -------------------");
        Thread.sleep(10000);
        driver.quit();
    }
    
    
    /**
     * Navigates to TripAdvisor (http://www.tripadvisor.in).
     * @throws IOException
     * @throws InterruptedException 
     */
    public HomePage navigateToTripAdvisor() throws IOException, InterruptedException
    {
        String url = fLib.getDataFromProperties("url");
        driver.get(url);
        // lib.waitForPageToLoadCompletely(driver);
	
        return new HomePage(driver);
    }
}