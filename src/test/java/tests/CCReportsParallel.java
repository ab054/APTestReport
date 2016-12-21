package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * Created by abarabas on 11/23/16.
 */
public class CCReportsParallel {

    WebDriver driver;

    @DataProvider(name = "teams", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
                new Object[]{"team1"},
                new Object[]{"team2"},
                new Object[]{"team3"},
                new Object[]{"team4"}
        };
    }

    @BeforeMethod
    public void setDriver() {

    }

    @Test(dataProvider = "teams")
    public void ccReportGenerateBilling(String teamName) throws InterruptedException {

        //driver = new FirefoxDriver();

        //driver.get("https://google.com");

        System.out.println("6.71");

        System.out.println(teamName);


    }

    @AfterMethod
    public void closeDriver() {
        //driver.quit();

    }


}
