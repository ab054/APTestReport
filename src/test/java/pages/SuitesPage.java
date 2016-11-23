package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by abarabas on 11/15/16.
 */
public class SuitesPage {

    public String controlCenterLinkXpath = "/html/body/div/div[3]/center/table/tbody/tr[12]/td/a";
    public String controlCenterLinkCSS = "html body#wholePage div#atmBody div#mainContent center table#suiteTable.sortable tbody tr td a";
    WebDriver driver;

    public SuitesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement controlCenterLink() {
        return driver.findElement(By.cssSelector(controlCenterLinkCSS));
    }
}
