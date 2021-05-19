package appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static appium.core.DriverFactory.getDriver;

public class BasePage {
    public void type(By by, String message) {
        getDriver().findElement(by).sendKeys(message);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public void clickByText(String text) {
        click(By.xpath("//*[@text='" + text + "']"));
    }

    public void selectCombo(By by, String value) {
        getDriver().findElement(by).click();
        clickByText(value);
    }

    public boolean isChecked(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean elementExistsByText(String text) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + text + "']"));
        return elements.size() > 0;
    }
}
