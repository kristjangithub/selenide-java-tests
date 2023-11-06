package internet.pages;

import internet.interfaces.IPageObject;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage implements IPageObject {

    @Override
    public String getUrl() { return "/login"; }

    public LoginPage fillInputField(String target, String value) {
        // Väli, tekst
        $(target).setValue(value);
        return this;
    }

    public LoginPage clickLogin() {
        $(".radius").click();
        return this;
    }

    public String getResultText() {
        return $("#result").getText();
    }
}