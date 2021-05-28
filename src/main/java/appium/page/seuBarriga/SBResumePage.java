package appium.page.seuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

import static appium.core.DriverFactory.getDriver;

public class SBResumePage extends BasePage {
    public void updateResume() {
        clickByText("ATUALIZAR");
    }

    public void swipeTransactionLeftAndDelete(String transactionName) {
        int transactionYCoordinate = getDriver().findElement(By.xpath("//*[@text='" + transactionName + "']/../..")).getCenter().y;
        swipeAt(0.9, 0.1, transactionYCoordinate);
        clickByText("Del");
    }
}
