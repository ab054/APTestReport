package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by abarabas on 11/15/16.
 */
public class ReportPage {

    public String filterSessionTableButtonXpath = "/html/body/div[3]/div/ul/li/a";
    public String toggleAllcheckboxName = "sessList-toggleAll";
    public String generateReportButtonName = "generateReport";
    WebDriver driver;

    public ReportPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement filterSessionTableButton() {
        return driver.findElement(By.xpath(filterSessionTableButtonXpath));
    }

    public WebElement toggleAllcheckbox() {
        return driver.findElement(By.name(toggleAllcheckboxName));
    }

    public WebElement generateReportButton() {
        return driver.findElement(By.name(generateReportButtonName));
    }
}
