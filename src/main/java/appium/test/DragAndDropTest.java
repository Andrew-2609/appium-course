package appium.test;

import appium.core.BaseTest;
import appium.page.DragAndDropPage;
import appium.page.MenuPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DragAndDropTest extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final DragAndDropPage dragAndDropPage = new DragAndDropPage();

    private final String[] initialState = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private final String[] intermediaryState = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private final String[] finalState = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    @DisplayName("Must successfully drag an element and drop it")
    public void mustPerformADragAndDrop() {
        menuPage.accessDragAndDrop();

        waitFor(1000);

        assertArrayEquals(initialState, dragAndDropPage.getElementsList());

        dragAndDropPage.drag("Esta", "e arraste para");

        assertArrayEquals(intermediaryState, dragAndDropPage.getElementsList());

        dragAndDropPage.drag("Faça um clique longo,", "é uma lista");

        assertArrayEquals(finalState, dragAndDropPage.getElementsList());
    }
}
