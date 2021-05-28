package appium.page.seuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBTransactionsPage extends BasePage {
    public void saveTransaction() {
        clickByText("SALVAR");
    }

    public void setTransactionDescription(String value) {
        type(By.xpath("//*[@text='Descrição']"), value);
    }

    public void setTransactionInterested(String value) {
        type(By.xpath("//*[@text='Interessado']"), value);
    }

    public void setTransactionValue(String value) {
        type(By.xpath("//*[@text='Valor']"), value);
    }
}
