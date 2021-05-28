package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.RealAppPage;
import appium.page.seuBarriga.SBMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealAppTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final RealAppPage realAppPage = new RealAppPage();
    private final SBMenuPage sbMenuPage = new SBMenuPage();

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

        realAppPage.setAccountName("Conta única");

        realAppPage.saveAccount();

        assertTrue(menuPage.elementExistsByText("Conta adicionada com sucesso"));
    }

    @Test
    @DisplayName("Must not create an account with repeatedName")
    public void mustNotCreateAnAccountWithRepeatedName() {
        sbMenuPage.changeToAccountsTab();

        realAppPage.setAccountName("Conta mesmo nome");

        realAppPage.saveAccount();

        assertTrue(menuPage.elementExistsByText("Problemas de comunicação"));
    }

    @Test
    @DisplayName("Must successfully delete an account")
    public void mustDeleteAnAccount() {
        sbMenuPage.changeToAccountsTab();

        realAppPage.selectAccount("Conta mesmo nome");

        realAppPage.deleteAccount();

        assertTrue(menuPage.elementExistsByText("Conta excluída com sucesso"));

        assertFalse(menuPage.elementExistsByText("Conta mesmo nome"));
    }

    @Test
    @DisplayName("Must not delete an account in use")
    public void mustNotDeleteAnAccountInUse() {
        sbMenuPage.changeToAccountsTab();

        waitFor(2000);

        realAppPage.selectAccount("Conta com movimentacao");

        realAppPage.deleteAccount();

        assertTrue(menuPage.elementExistsByText("Conta em uso nas movimentações"));

        assertTrue(menuPage.elementExistsByText("Conta com movimentacao"));
    }

    @Test
    @DisplayName("Must make a valid account transaction")
    public void mustMakeAValidAccountTransaction() {
        realAppPage.changeToTransactionsTab();

        realAppPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Descrição é um campo obrigatório"));

        realAppPage.setTransactionDescription("Saque milionário");

        realAppPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Interessado é um campo obrigatório"));

        realAppPage.setTransactionInterested("Andrew");

        realAppPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Valor é um campo obrigatório"));

        realAppPage.setTransactionValue("1000000");

        realAppPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Conta é um campo obrigatório"));

        realAppPage.setTransactionAccount();

        realAppPage.saveTransaction();

        assertTrue(menuPage.elementExistsByText("Movimentação cadastrada com sucesso"));
    }

    @Test
    @DisplayName("Must exclude a transaction and update the balance")
    public void mustExcludeATransactionAndUpdateTheBalance() {
        realAppPage.changeToResumeTab();

        realAppPage.updateResume();

        realAppPage.swipeTransactionLeft("Movimentacao para exclusao");

        realAppPage.deleteTransaction();

        assertTrue(menuPage.elementExistsByText("Movimentação removida com sucesso!"));

        realAppPage.changeToHomeTab();

        waitFor(2500);

        realAppPage.updateHomeBalance();

        assertFalse(menuPage.elementExistsByText("Conta para movimentacoes"));
    }
}
