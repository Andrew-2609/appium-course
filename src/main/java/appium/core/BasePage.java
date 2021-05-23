package appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidElementStateException;

import java.time.Duration;
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

    public String getConfirmAlertTitle() {
        return getText(By.id("android:id/alertTitle"));
    }

    public String getConfirmAlertMessage() {
        return getText(By.id("android:id/message"));
    }

    public void tapOnCoordinates(int x, int y) {
        try {
            new TouchAction<>(DriverFactory.getDriver()).tap(PointOption.point(x, y)).perform();
        } catch (InvalidElementStateException exception) {
            System.out.println("A InvalidElementStateException was thrown.\nIf it is AlertTest, this probably happened for no known reason.");
        }
    }

    public void scroll(double start, double end) {
        Dimension deviceDimension = getDriver().manage().window().getSize();

        int x = deviceDimension.getWidth() / 2;

        int startY = (int) (deviceDimension.getHeight() * start);
        int endY = (int) (deviceDimension.getHeight() * end);

        new TouchAction<>(getDriver())
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    public void scrollDown() {
        scroll(0.9, 0.1);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void swipe(double start, double end) {
        Dimension deviceDimension = getDriver().manage().window().getSize();

        int startX = (int) (deviceDimension.getWidth() * start);
        int endX = (int) (deviceDimension.getWidth() * end);

        int y = deviceDimension.getHeight() / 2;

        new TouchAction<>(getDriver())
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    public void swipeAt(double start, double end, int y) {
        Dimension deviceDimension = getDriver().manage().window().getSize();

        int startX = (int) (deviceDimension.getWidth() * start);
        int endX = (int) (deviceDimension.getWidth() * end);

        new TouchAction<>(getDriver())
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }
}
