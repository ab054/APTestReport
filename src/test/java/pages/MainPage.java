package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by abarabash on 3/28/16.
 */
public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to("http://suzuki16.i.jaspersystems.com/atm/login.mpl?target=/atm/index.mpl%3f");
    }

    public WebElement userNameTextfield() {
        return driver.findElement(By.name("name"));

    }

    public WebElement passwordTextfield() {
        return driver.findElement(By.name("pass"));
    }

    public WebElement submitButton() {
        return driver.findElement(By.name("submit"));
    }
}
