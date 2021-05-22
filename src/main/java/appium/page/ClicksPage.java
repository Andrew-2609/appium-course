package appium.page;

import appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static appium.core.DriverFactory.getDriver;

public class ClicksPage extends BasePage {
    public void longClick() {
        new TouchAction<>(
                getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))))
                .perform();
    }

    public String getFieldText() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
