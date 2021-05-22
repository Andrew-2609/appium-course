package appium.page;

import appium.core.BasePage;

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
        clickByText("Opção bem escondida");
    }

    public void accessSwipe() {
        clickByText("Swipe");
    }
}
