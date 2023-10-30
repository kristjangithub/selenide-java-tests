package internet.tests;

import internet.BaseTest;
import internet.pages.KeyPressesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTest extends BaseTest {

    @Test
    public void keyPressesTest() {
        var keyPressesPage = new KeyPressesPage();
        var input = "testing";

        visit(keyPressesPage.getUrl());

        keyPressesPage
            .fillInputField(input);

        var actualResultText = keyPressesPage.getResultText();
        var expectedResultText = String.format(
            "You entered: %s",
            input.substring(input.length() - 1).toUpperCase());

        Assert.assertEquals(actualResultText, expectedResultText);
    }
}
