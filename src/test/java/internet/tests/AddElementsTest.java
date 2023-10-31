package internet.tests;

import internet.BaseTest;
import internet.pages.AddElementsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddElementsTest extends BaseTest {

    @DataProvider(name = "klikid")
    private Object[][] dataProvider() {
        return new Object[][] {
                { 10 },
                { 3 },
                { 15 }
        };
    }

    @Test(dataProvider = "klikid")
    public void canAddElements(int kogus) {
        var addElementsPage = new AddElementsPage();

        visit(addElementsPage.getUrl());

        addElementsPage
                .klikiMituKorda(kogus);

        var elementideKogus = addElementsPage.getDeleteButtonCount();

        Assert.assertEquals(elementideKogus, kogus);
    }
}
