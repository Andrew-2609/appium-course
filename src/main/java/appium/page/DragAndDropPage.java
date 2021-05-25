package appium.page;

import appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.List;

import static appium.core.DriverFactory.getDriver;

public class DragAndDropPage extends BasePage {
    public void drag(String origin, String destination) {
        MobileElement originElement = getDriver().findElement(By.xpath("//*[@text='" + origin + "']"));
        MobileElement destinationElement = getDriver().findElement(By.xpath("//*[@text='" + destination + "']"));

        new TouchAction<>(getDriver()).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(originElement)))
                .moveTo(PointOption.point(destinationElement.getLocation()))
                .release()
                .perform();
    }

    public String[] getElementsList() {
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String[] returnList = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            returnList[i] = elements.get(i).getText();
        }
        return returnList;
    }
}
