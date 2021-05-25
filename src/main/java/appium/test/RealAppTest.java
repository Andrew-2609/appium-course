package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.RealAppPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealAppTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final RealAppPage realAppPage = new RealAppPage();

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
        realAppPage.changeToAccountsTab();

        realAppPage.setAccountName("Conta única");

        realAppPage.saveAccount();

        assertTrue(menuPage.elementExistsByText("Conta adicionada com sucesso"));
    }

    @Test
    @DisplayName("Must not create an account with repeatedName")
    public void mustNotCreateAnAccountWithRepeatedName() {
        realAppPage.changeToAccountsTab();

        realAppPage.setAccountName("Conta mesmo nome");

        realAppPage.saveAccount();

        assertTrue(menuPage.elementExistsByText("Problemas de comunicação"));
    }

    @Test
    @DisplayName("Must successfully delete an account")
    public void mustDeleteAnAccount() {
        realAppPage.changeToAccountsTab();

        realAppPage.selectAccount("Conta mesmo nome");

        realAppPage.deleteAccount();

        assertTrue(menuPage.elementExistsByText("Conta excluída com sucesso"));

        assertFalse(menuPage.elementExistsByText("Conta mesmo nome"));
    }

    @Test
    @DisplayName("Must not delete an account in use")
    public void mustNotDeleteAnAccountInUse() {
        realAppPage.changeToAccountsTab();

        realAppPage.selectAccount("Conta para movimentacoes");

        realAppPage.deleteAccount();

        assertTrue(menuPage.elementExistsByText("Conta em uso nas movimentações"));
        
        assertTrue(menuPage.elementExistsByText("Conta para movimentacoes"));
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
}
