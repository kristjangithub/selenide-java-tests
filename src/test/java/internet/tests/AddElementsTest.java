package internet.tests;

import internet.BaseTest
import org.testng.Assert;

public class AddElementsTest extends BaseTest {


@Test
public void canAddElements(){
var addElementsPage = new AddRemoveElementsPage();

visit(addElementsPage.getUrl());

addElementsPage
        .clickElement();
.clickElement();
.clickElement();
.clickElement();
.clickElement();
.clickElement();

var elementideKogus = addElementsPage.getDeleteButtonCount();
        Assert.assertEquals(elemtideKogus, 5);
}

}




