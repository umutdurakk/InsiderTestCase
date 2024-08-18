package insider.umutd.driver;

import insider.umutd.utils.ConfigReader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver driver;

    ConfigReader configReader;

    public BaseTest() {
        configReader = new ConfigReader();
    }

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                configReader.getFilePath("pathChromeDriver"));

        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();

        driver.get(configReader.getFilePath("baseUrl"));
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notification");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-certificate-errors-spki-list");
        chromeOptions.addArguments("--suppress-message-center-popups");
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
