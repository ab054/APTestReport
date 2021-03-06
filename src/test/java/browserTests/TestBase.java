package browserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.BasePage;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by abarabash on 7/18/16.
 */
public class TestBase {

    public static WebDriver driver;
    public static BasePage scr;

    @DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
                new Object[]{"firefox", "46", "OS X 10.9"},
                new Object[]{"firefox", "46", "Windows 8.1"},
                new Object[]{"firefox", "46", "Windows 7"},
                new Object[]{"chrome", "35", "OS X 10.9"},
        };
    }

    @BeforeMethod()
    public void beforeMethod() {
        driver = new FirefoxDriver();
        scr = new BasePage(driver);
    }

    @AfterMethod
    public void afterAllTests() {

        driver.quit();

    }

    private void setUpGeckoDriver() {

        String userdir = System.getProperty("user.dir");

        String path = userdir + "/src/test/resources/geckodriver";

        System.setProperty("webdriver.gecko.driver", path);

    }

    public WebDriver createSauseLabsBrowser(String browser, String version, String os, Method method) throws MalformedURLException {

        String USERNAME = "abarabash";
        String ACCESS_KEY = "56f0639b-4260-4600-873b-f118205efa4c";

        String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, browser);
        caps.setCapability("platform", os);
        caps.setCapability("version", version);

        caps.setCapability("name", method.getName());

        System.out.println("Launching " + method.getName() + " at " + URL);
        return new RemoteWebDriver(new URL(URL), caps);


    }


}
