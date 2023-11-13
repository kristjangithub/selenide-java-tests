package saucedemo.tests;

import internet.BaseTest;
import org.testng.Assert;
import saucedemo.pages.ShoppingPage;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test
    public void loginTest() {
        var shoppingPage = new ShoppingPage();

        // Info, mida sisestame sisselogimisel
        var username = "standard_user";
        var password = "secret_sauce";

        // Info makse lõpule viimise jaoks
        var firstName = "FirstName";
        var lastName = "LastName";
        var postalCode = "12345";

        double expectedPrice, actualPrice;

        visit(shoppingPage.getUrl());

        // Logida sisse
        shoppingPage
                .fillUsername(username)
                .fillPassword(password)
                .clickLogin();

        // Leida kõige odavam toode ja lisada see ostukorvi; salvestada valitud toote hind muutujasse
        expectedPrice = shoppingPage.addCheapestListingToCart();

        // Navigeerida maksmise lehele ja kinnitada ost
        shoppingPage
                .goToCheckout()
                .validateCart()
                .fillBuyerInfo(firstName, lastName, postalCode)
                .proceedToPurchase();

        // Leida hind, mille maksame toote eest pärast ostukorvi lisamist (miinus maksud)
        actualPrice = shoppingPage.confirmPurchase(expectedPrice);

        Assert.assertEquals(expectedPrice, actualPrice);
    }
}