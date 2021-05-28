package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.RealAppPage;
import appium.page.seuBarriga.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SBNativeTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final RealAppPage realAppPage = new RealAppPage();
    private final SBMenuPage sbMenuPage = new SBMenuPage();
    private final SBAccountsPage sbAccountsPage = new SBAccountsPage();
    private final SBTransactionsPage sbTransactionsPage = new SBTransactionsPage();
    private final SBHomePage sbHomePage = new SBHomePage();
    private final SBResumePage sbResumePage = new SBResumePage();

    @BeforeEach
    public void setUp() {
        menuPage.accessNativeSB();
        realAppPage.setLoginName("andrew@email");
        realAppPage.setLoginPassword("senha");
        realAppPage.login();
        realAppPage.resetData();
    }

    @Test
    @DisplayName("Must create a valid account")
    public void mustCreateAValidAccount() {
        sbMenuPage.changeToAccountsTab();

        sbAccountsPage.setAccountName("Conta única");

        sbAccountsPage.saveAccount();

        assertTrue(menuPage.elementExistsByText("Conta adicionada com sucesso"));
    }

    @Test
    @DisplayName("Must not create an account with repeatedName")
    public void mustNotCreateAnAccountWithRepeatedName() {
        sbMenuPage.changeToAccountsTab();

        sbAccountsPage.setAccountName("Conta mesmo nome");

        sbAccountsPage.saveAccount();

        assertTrue(menuPage.elementExistsByText("Problemas de comunicação"));
    }

    @Test
    @DisplayName("Must successfully delete an account")
    public void mustDeleteAnAccount() {
        sbMenuPage.changeToAccountsTab();

        sbAccountsPage.selectAccount("Conta mesmo nome");

        sbAccountsPage.deleteAccount();

        assertTrue(menuPage.elementExistsByText("Conta excluída com sucesso"));

        assertFalse(menuPage.elementExistsByText("Conta mesmo nome"));
    }

    @Test
    @DisplayName("Must not delete an account in use")
    public void mustNotDeleteAnAccountInUse() {
        sbMenuPage.changeToAccountsTab();

        waitFor(2000);

        sbAccountsPage.selectAccount("Conta com movimentacao");

        sbAccountsPage.deleteAccount();

        assertTrue(menuPage.elementExistsByText("Conta em uso nas movimentações"));

        assertTrue(menuPage.elementExistsByText("Conta com movimentacao"));
    }

    @Test
    @DisplayName("Must make a valid account transaction")
    public void mustMakeAValidAccountTransaction() {
        sbMenuPage.changeToTransactionsTab();

        sbTransactionsPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Descrição é um campo obrigatório"));

        sbTransactionsPage.setTransactionDescription("Saque milionário");

        sbTransactionsPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Interessado é um campo obrigatório"));

        sbTransactionsPage.setTransactionInterested("Andrew");

        sbTransactionsPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Valor é um campo obrigatório"));

        sbTransactionsPage.setTransactionValue("1000000");

        sbTransactionsPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Conta é um campo obrigatório"));

        sbTransactionsPage.setTransactionAccount();

        sbTransactionsPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Movimentação cadastrada com sucesso"));
    }

    @Test
    @DisplayName("Must exclude a transaction and update the balance")
    public void mustExcludeATransactionAndUpdateTheBalance() {
        assertEquals("534.00", sbHomePage.getBalanceFromAccount("Conta para saldo"));

        sbMenuPage.changeToResumeTab();

        sbResumePage.updateResume();

        sbResumePage.swipeTransactionLeftAndDelete("Movimentacao 3, calculo saldo");

        assertTrue(menuPage.elementExistsByText("Movimentação removida com sucesso!"));

        sbMenuPage.changeToHomeTab();

        waitFor(2500);

        sbHomePage.updateHomeBalance();

        assertEquals("-1000.00", sbHomePage.getBalanceFromAccount("Conta para saldo"));
    }

    @AfterEach
    public void tearDown() {
        sbMenuPage.changeToHomeTab();
        realAppPage.resetData();
    }
}
