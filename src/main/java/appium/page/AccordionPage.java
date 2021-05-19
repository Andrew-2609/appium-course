package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {
    public void clickOnFirstOption() {
        clickByText("Opção 1");
    }

    public String getFirstOptionText() {
        return getText(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }
}
