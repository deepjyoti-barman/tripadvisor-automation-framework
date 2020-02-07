package in.tripadvisor.base;

/**
 * Interface that contains all the final static constants to be used throughout the framework.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public interface IAutoConstant
{
    String CHROME_KEY   = "webdriver.chrome.driver";
    String CHROME_VALUE = "./src/main/resources/drivers/chromedriver.exe";
    String GECKO_KEY    = "webdriver.gecko.driver";
    String GECKO_VALUE  = "./src/main/resources/drivers/geckodriver.exe";
	
    long IMPLICIT_TIMEOUT = 20;
    long EXPLICIT_TIMEOUT = 20;
	
    String DEFAULT_PROPERTIES_PATH = "./src/main/resources/commondata/webapp_config.properties";
}
