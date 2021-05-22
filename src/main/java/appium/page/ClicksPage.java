package appium.page;

import appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static appium.core.DriverFactory.getDriver;

public class ClicksPage extends BasePage {
    public void longClick() {
        new TouchAction<>(
                getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(getElementOption("//*[@text='Clique Longo']")))
                .perform();
    }

    public void doubleClick() {
        new TouchAction<>(
                getDriver())
                .tap(TapOptions.tapOptions()
                        .withElement(getElementOption("//*[@text='Clique duplo']"))
                        .withTapsCount(2))
                .perform();
    }

    public String getFieldText() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }

    private ElementOption getElementOption(String byParam) {
        return ElementOption.element(getDriver().findElement(By.xpath(byParam)));
    }
}