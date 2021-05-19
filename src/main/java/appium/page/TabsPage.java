package appium.page;

import appium.core.BasePage;

public class TabsPage extends BasePage {
    public boolean isOnFirstTab() {
        return elementExistsByText("Este é o conteúdo da Aba 1");
    }

    public boolean isOnSecondTab() {
        return elementExistsByText("Este é o conteúdo da Aba 2");
    }

    public void selectSecondTab() {
        clickByText("ABA 2");
    }
}
