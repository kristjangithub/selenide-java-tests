package internet.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public String getUrl() {
        return "/login";
    }

    public LoginPage fillInputField1(String value) {
        $(By.cssSelector("input#username")).setValue(value);
        return this;
    }

    public LoginPage fillInputField2(String value) {
        $(By.cssSelector("input#password")).setValue(value);
        return this;
    }

    public LoginPage clickElement() {
        $(By.cssSelector("button")).click();
        return this;
    }

    public String getResultText() {
        return $(By.cssSelector(".subheader")).getText();
    }
}
