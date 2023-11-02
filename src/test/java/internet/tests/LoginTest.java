package internet.tests;

import internet.BaseTest;
import internet.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {

    @Test
    public void canLoginTest() {
        var loginPage = new LoginPage();
        var input1 = "tomsmith";
        var input2 = "SuperSecretPassword!";

        visit(loginPage.getUrl());

        loginPage.fillInputField1(input1);

        loginPage.fillInputField2(input2);

        loginPage.clickElement();

        var actualResultText = loginPage.getResultText();
        var expectedResultText = "Welcome to the Secure Area. When you are done click logout below.";

        Assert.assertEquals(actualResultText, expectedResultText);
    }
}