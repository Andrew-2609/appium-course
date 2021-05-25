package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static appium.core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    public void enterWebContext() {
        Set<String> contextHandles = getDriver().getContextHandles();
        getDriver().context(contextHandles.toArray()[1].toString());
    }

    public void setEmail(String value) {
        getDriver().findElement(By.cssSelector("#email")).sendKeys(value);
    }

    public void setPassword(String value) {
        getDriver().findElement(By.cssSelector("#senha")).sendKeys(value);
    }

    public void logIn() {
        click(By.cssSelector("button[type='submit']"));
    }

    public String getSuccessMessage() {
        return getText(By.cssSelector("div[class='alert alert-success']"));
    }

    public void quitWebContext() {
        getDriver().context(getDriver().getContextHandles().toArray()[0].toString());
    }
}
