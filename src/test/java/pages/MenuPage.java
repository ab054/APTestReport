package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static browserTests.TestBase.scr;


/**
 * Created by abarabas on 11/15/16.
 */
public class MenuPage {

    public String suitesLinkXpath = "/html/body/div/div/div/div[2]/ul/li[6]/a";
    public String reportingMenuXpath = "/html/body/div/div[3]/div/div/table/tbody/tr[4]/td/a";
    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {

        scr.menuPage.suitesLink().click();

    }

    public WebElement suitesLink() {
        return driver.findElement(By.xpath(suitesLinkXpath));
    }


    public WebElement ReportingMenu() {
        return driver.findElement(By.xpath(reportingMenuXpath));
    }
}
