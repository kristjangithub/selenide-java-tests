package internet.tests;

import com.codeborne.selenide.Condition;
import internet.BaseTest;
import internet.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        var loginPage = new LoginPage();

        // Info, mida sisestame
        var username = "tomsmith";
        var password = "SuperSecretPassword!";

        // Väljad, mida täita
        var fieldUserName = "input#username";
        var fieldPassword = "input#password";

        // Element, mida võrdleme tulemusega
        var flashElement = $("#flash");

        visit(loginPage.getUrl());

        loginPage.fillInputField(fieldUserName, username);
        loginPage.fillInputField(fieldPassword, password);

        loginPage.clickLogin();

        // Ootame, kuni element ära laeb
        flashElement.shouldBe(Condition.visible);

        String actualMessage = flashElement.text();
        String expectedMessage = "You logged into a secure area!";

        // Ligikaudne võrdlus (ilma reavahetusteta jne)
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}