package appium.page;

import appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;

import static appium.core.DriverFactory.getDriver;

public class ClicksPage extends BasePage {
    public void longClick() {
        longClick(By.xpath("//*[@text='Clique Longo']"));
    }

    public void doubleClick() {
        new TouchAction<>(
                getDriver())
                .tap(TapOptions.tapOptions()
                        .withElement(getElementOption(By.xpath("//*[@text='Clique duplo']")))
                        .withTapsCount(2))
                .perform();
    }

    public String getFieldText() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}