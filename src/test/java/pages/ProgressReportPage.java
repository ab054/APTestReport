package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by abarabas on 11/21/16.
 */
public class ProgressReportPage {

    public String summaryResultTableClassName = "atm_dataTable";
    public String summaryResultTableXpath = "/html/body/div[2]/div[3]/table/tbody/tr/td/ul[3]/table";
    WebDriver driver;

    public ProgressReportPage(WebDriver driver) {
        this.driver = driver;
    }


}
