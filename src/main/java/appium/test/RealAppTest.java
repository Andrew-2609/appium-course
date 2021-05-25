package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.RealAppPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealAppTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final RealAppPage realAppPage = new RealAppPage();

    @BeforeEach
    public void setUp() {
        menuPage.accessNativeSB();
        realAppPage.setName("andrew@email");
        realAppPage.setPassword("senha");
        realAppPage.logIn();
        realAppPage.resetData();
    }

    @Test
    @DisplayName("Must create a valid account")
    public void mustCreateAValidAccount() {
        assertTrue(menuPage.elementExistsByText("HOME"));

        realAppPage.changeToAccountsTab();

        realAppPage.setAccountName("Conta única");

        realAppPage.saveAccount();

        assertTrue(menuPage.elementExistsByText("Conta adicionada com sucesso"));
    }
}
