package internet.tests;

import internet.BaseTest;
import internet.data.DraggableBox;
import internet.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static internet.data.DraggableBox.*;
import static internet.data.DraggableBox.BOX_A;
import static internet.data.DraggableBox.BOX_B;

public class DragAndDropTest extends BaseTest {

    @DataProvider(name = "dragAndDropTestDataProvider")
    private Object[][] dataProvider() {
        return new Object[][] {
            {BOX_A, BOX_B},
            {BOX_B, BOX_A}
        };
    }

    @Test(dataProvider = "dragAndDropTestDataProvider")
    public void dragAndDropTest(DraggableBox sourceColumn, DraggableBox targetColumn) {
        var dragAndDropPage = new DragAndDropPage();

        visit(dragAndDropPage.getUrl());

        dragAndDropPage
            .dragBoxTo(sourceColumn, targetColumn);

        var actualColumnAHeaderText = dragAndDropPage.getColumnHeaderText(0);

        Assert.assertEquals(actualColumnAHeaderText, "B");
    }
}
