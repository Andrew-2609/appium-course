package appium.page.seuBarriga;

import appium.core.BasePage;

public class SBMenuPage extends BasePage {
    public void changeToAccountsTab() {
        clickByText("CONTAS");
    }

    public void changeToTransactionsTab() {
        clickByText("MOV...");
    }

    public void changeToResumeTab() {
        clickByText("RESUMO");
    }
}
