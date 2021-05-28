package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appium.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {
    public void accessForm() {
        clickByText("Formulário");
    }

    public void accessSplash() {
        clickByText("Splash");
    }

    public void accessAlert() {
        clickByText("Alertas");
    }

    public void accessTabs() {
        clickByText("Abas");
    }

    public void accessAccordion() {
        clickByText("Accordion");
    }

    public void accessClicks() {
        clickByText("Cliques");
    }

    public void accessWellHiddenOption() {
        explicitlyWaitForFormElementToBePresent();
        scrollDown();
        clickByText("Opção bem escondida");
    }

    public void accessSwipe() {
        clickByText("Swipe");
    }

    public void accessSwipeList() {
        explicitlyWaitForFormElementToBePresent();
        scrollDown();
        clickByText("Swipe List");
    }

    public void accessDragAndDrop() {
        explicitlyWaitForFormElementToBePresent();
        scrollDown();
        clickByText("Drag and drop");
    }

    public void accessHybridSB() {
        clickByText("SeuBarriga Híbrido");
    }

    public void accessNativeSB() {
        clickByText("SeuBarriga Nativo");
    }

    private void explicitlyWaitForFormElementToBePresent() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
    }
}
