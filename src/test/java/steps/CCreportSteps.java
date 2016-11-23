package steps;

import browserTests.TestBase;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * Created by abarabas on 11/16/16.
 */
public class CCreportSteps extends TestBase {

    public static void navigateToMainPage() {
        scr.mainPage.navigate();
    }

    public static void login() {
        scr.mainPage.userNameTextfield().sendKeys("aptestreport");
        scr.mainPage.passwordTextfield().sendKeys("jasper2006");
        scr.mainPage.submitButton().click();

        waitForElementXpath("/html/body/div/div/div/div[2]/ul/li[6]/a");
    }

    public static void goToSuits() {
        scr.menuPage.navigate();

        waitForElementXpath(scr.suitesPage.controlCenterLinkXpath);
    }

    public static void choseControlCenter() {
        driver.navigate().to("http://suzuki16.i.jaspersystems.com/atm/index.mpl?suite=Control_Center");

        // scr.suitesPage.controlCenterLink().click();
    }

    public static void clickOnReporting() {
        scr.menuPage.ReportingMenu().click();

        waitForElementXpath(scr.reportPage.filterSessionTableButtonXpath);
    }

    public static void clickOnFilterSession() {

        try {
            scr.reportPage.filterSessionTableButton().click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        waitForElementXpath(scr.filterSessionTable.buildListXpath);

    }

    public static void selectBuildNumberAs(String buildNumber) {
        scr.filterSessionTable.selectBuildNumberAs(buildNumber);
    }

    public static void selectTeamByName(String teamName) {
        scr.filterSessionTable.selectTeamByName(teamName);
    }

    public static void clickOnApplyListSettings() {
        scr.filterSessionTable.applyListSettings().click();
    }

    public static void selectAllTestSets() {
        scr.reportPage.toggleAllcheckbox().click();
    }

    public static void clickOnGenerateReportButton() {
        scr.reportPage.generateReportButton().click();
    }

    public static void saveSummaryTable(String teamName) {
        Object lastWindowHandle = driver.getWindowHandles().toArray()[1];
        driver.switchTo().window(lastWindowHandle.toString());

        waitForElementClassName(scr.progressReportPage.summaryResultTableClassName);

        Document report = Jsoup.parse(driver.getPageSource());

        Element smallernoborder = report.getElementsByClass("smallernoborder").get(0);

        Element atmDataTable = smallernoborder.getElementsByClass("atm_dataTable").get(0).parent();

        writeToFile(atmDataTable, "report/" + teamName + ".html");
    }

    public static void writeToFile(Element elementName, String fileName) {
        try {
            FileUtils.writeStringToFile(new File(fileName), elementName.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementXpath(String xpath) {

        WebDriverWait wait = new WebDriverWait(driver, 15);

        By desiredElement = By.xpath(xpath);

        wait.until(ExpectedConditions.visibilityOfElementLocated(desiredElement));
    }

    public static void waitForElementClassName(String className) {

        WebDriverWait wait = new WebDriverWait(driver, 15);

        By desiredElement = By.className(className);

        wait.until(ExpectedConditions.visibilityOfElementLocated(desiredElement));
    }
}
