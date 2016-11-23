package pages;

import browserTests.TestBase;
import org.openqa.selenium.WebDriver;


/**
 * Created by abarabash on 3/28/16.
 */
public class BasePage extends TestBase {

    public MainPage mainPage;
    public MenuPage menuPage;
    public SuitesPage suitesPage;
    public ReportPage reportPage;
    public FilterSessionTable filterSessionTable;
    public ProgressReportPage progressReportPage;


    public BasePage(WebDriver driver) {
        mainPage = new MainPage(driver);
        menuPage = new MenuPage(driver);
        suitesPage = new SuitesPage(driver);
        reportPage = new ReportPage(driver);
        filterSessionTable = new FilterSessionTable(driver);
        progressReportPage = new ProgressReportPage(driver);
    }
}
