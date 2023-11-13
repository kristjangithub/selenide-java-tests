package saucedemo.pages;

import internet.interfaces.IPageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ErrorPage implements IPageObject {
    @Override
    public String getUrl() { return "/"; }

    public ErrorPage fillUsername(String input) {
        var target = "input#user-name";
        $(target).setValue(input);
        return this;
    }

    public ErrorPage fillPassword(String input) {
        var target = "input#password";
        $(target).setValue(input);
        return this;
    }

    public ErrorPage clickLogin() {
        var loginButtonId = "input#login-button";
        $(loginButtonId).click();
        return this;
    }

    public ErrorPage addListing() {
        var buttonId = ".btn_inventory";
//        add-to-cart-sauce-labs-backpack
        $(buttonId).click();

        return this;
    }

    public ErrorPage goToCheckout() {
        var checkoutNavigationId = "#shopping_cart_container";
        $(checkoutNavigationId).click();
        return this;
    }

    public ErrorPage validateCart() {
        var confirmPurchase = "button#checkout";
        $(confirmPurchase).click();
        return this;
    }

    public ErrorPage confirmCheckout() {
        String continueButtonId = "input#continue";
        $(continueButtonId).click();
        return this;
    }

    public String checkForErrorMessage() {
        String errorMessage;
        errorMessage = $(".error-message-container.error h3[data-test='error']").text();
        return errorMessage;
    }

    public int checkForRedFields() {
        int errorCount;
        errorCount = $$(".error_icon").size();
        return errorCount;
    }
}
