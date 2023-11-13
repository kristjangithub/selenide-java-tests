package saucedemo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import internet.interfaces.IPageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPage implements IPageObject {
    @Override
    public String getUrl() { return "/"; }

    public ShoppingPage fillUsername(String input) {
        var target = "input#user-name";
        $(target).setValue(input);
        return this;
    }

    public ShoppingPage fillPassword(String input) {
        var target = "input#password";
        $(target).setValue(input);
        return this;
    }

    public ShoppingPage clickLogin() {
        var loginButtonId = "input#login-button";
        $(loginButtonId).click();
        return this;
    }

    public ShoppingPage goToCheckout() {
        var checkoutNavigationId = "#shopping_cart_container";
        $(checkoutNavigationId).click();
        return this;
    }

    public ShoppingPage validateCart() {
        var confirmPurchase = "button#checkout";
        $(confirmPurchase).click();
        return this;
    }

    public ShoppingPage fillBuyerInfo(String firstName, String lastName, String postalCode) {
        String fieldFirstName, fieldLastName, fieldPostalCode;

        fieldFirstName  = "input#first-name";
        fieldLastName   = "input#last-name";
        fieldPostalCode = "input#postal-code";

        $(fieldFirstName).setValue(firstName);
        $(fieldLastName).setValue(lastName);
        $(fieldPostalCode).setValue(postalCode);
        return this;
    }

    public ShoppingPage proceedToPurchase() {
        String continueButtonId = "input#continue";
        $(continueButtonId).click();
        return this;
    }

    public double confirmPurchase(double expectedPrice) {
        // Veenduda, et makstud summa oli sama mis eeldatav
        double actualPrice;

        // Makse tehingu kinnitus
        String finishTransactionButtonId = "button#finish";

        // Leida hind, mida peame maksma
        SelenideElement priceElement = $(".summary_subtotal_label");
        String htmlText = priceElement.text();

        // Salvestada hind tekstina ilma valuutasümboliteta
        String priceText = htmlText.replace("Item total: $", "");

        // Lõplik hind arvuna
        actualPrice = Double.parseDouble(priceText);

        return actualPrice;
    }

    public double addCheapestListingToCart() {
        // Kõik vastavad tulemused, mis kasutavad hinnavälju
        ElementsCollection priceBars = $$(".pricebar");

        // Odavaim hind ja sellele vastav element (nupp ja selle id)
        double minPrice = Double.MAX_VALUE;
        String addToCartButtonId = "";

        for (SelenideElement priceBar : priceBars) {
            // Leida hinna klass ja salvestada väärtus
            SelenideElement priceElement = priceBar.find(".inventory_item_price");

            // Leida hind tekstivormis ilma valuuta sümbolita
            String priceText = priceElement.text().replace("$", "");

            // Teisendada hinna väärtus arvuks
            double currentPrice = Double.parseDouble(priceText);

            // Uue hinna võrdlemine eelmise kontrollitud hinnaga
            if (currentPrice < minPrice) {
                // Kui uus hind on väiksem, vahetada eelmine välja uue vastu
                minPrice = currentPrice;

                // Leida klassist nupp ja selle id ning salvestada id muutujasse
                SelenideElement buttonElement = priceBar.find(".btn_inventory");
                addToCartButtonId = "#" + buttonElement.getAttribute("id");
            }
        }
        // Lisada valitud toode ostukorvi
        $(addToCartButtonId).click();

        return minPrice;
    }
}