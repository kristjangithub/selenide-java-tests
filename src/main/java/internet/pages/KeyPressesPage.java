package internet.pages;

import internet.interfaces.IPageObject;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesPage implements IPageObject {

    @Override
    public String getUrl() {
        return "/key_presses";
    }

    public KeyPressesPage fillInputField(String value) {
        $("input#target").setValue(value);
        return this;
    }

    public String getResultText() {
        return $("#result").getText();
    }
}
