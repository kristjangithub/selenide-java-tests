package internet.tests;

import internet.BaseTest;
import internet.data.DraggableColumn;
import internet.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static internet.data.DraggableColumn.COLUMN_A;
import static internet.data.DraggableColumn.COLUMN_B;

public class DragAndDropTest extends BaseTest {

    @DataProvider(name = "dragAndDropTestDataProvider")
    private Object[][] dataProvider() {
        return new Object[][] {
            { COLUMN_A, COLUMN_B },
            { COLUMN_B, COLUMN_A }
        };
    }

    @Test(dataProvider = "dragAndDropTestDataProvider")
    public void dragAndDropTest(DraggableColumn sourceColumn, DraggableColumn targetColumn) {
        var dragAndDropPage = new DragAndDropPage();

        visit(dragAndDropPage.getUrl());

        dragAndDropPage
            .dragColumnTo(sourceColumn, targetColumn);

        var actualColumnAHeaderText = dragAndDropPage.getColumnHeaderText(0);

        Assert.assertEquals(actualColumnAHeaderText, "B");
    }
}
