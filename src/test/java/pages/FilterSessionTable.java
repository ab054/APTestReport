package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by abarabas on 11/15/16.
 */
public class FilterSessionTable {

    public String buildListXpath = "/html/body/div[3]/form/div/div[2]/table/tbody/tr[2]/td[2]/select";
    public String teamNameXpath = "/html/body/div[3]/form/div/div[2]/table/tbody/tr[4]/td[2]/select";
    public String teamNameName = "VAR_team";
    public String applyListSettingsButtonName = "apply";
    WebDriver driver;

    public FilterSessionTable(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBuildNumberAs(String buildNumber) {

        Select buildNumberSelect = new Select(driver.findElement(By.xpath(buildListXpath)));

        buildNumberSelect.deselectAll();

        buildNumberSelect.selectByValue(buildNumber);
    }

    public void selectTeamByName(String teamName) {

        Select teamNameSelect = new Select(driver.findElement(By.name(teamNameName)));
        teamNameSelect.deselectAll();
        teamNameSelect.selectByVisibleText(teamName);

    }

    public WebElement applyListSettings() {
        return driver.findElement(By.name(applyListSettingsButtonName));
    }
}
