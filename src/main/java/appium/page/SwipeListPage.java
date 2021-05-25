package appium.page;

import appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import static appium.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public int getOptionYCoordinateByText(String text) {
        return getDriver().findElement(By.xpath("//*[@text='" + text + "']/..")).getCenter().y;
    }

    public void swipeOptionLeft(String option) {
        int optionYCoordinate = getOptionYCoordinateByText(option);
        swipeAt(0.9, 0.1, optionYCoordinate);
    }

    public void swipeOptionRight(String option) {
        int optionYCoordinate = getOptionYCoordinateByText(option);
        swipeAt(0.1, 0.9, optionYCoordinate);
    }

    public void clickOnOptionPlusMinusText(String option, String plusOrMinus) {
        Point buttonCoordinates = getDriver().findElement(By.xpath("//*[@text='" + option + "']/../../following-sibling::android.view.ViewGroup//android.widget.TextView[@text='(" + plusOrMinus + ")']")).getLocation();
        new TouchAction<>(getDriver()).tap(PointOption.point(buttonCoordinates)).perform();
    }

    public String getOptionText(String option) {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, '" + option + "')]"));
    }
}
