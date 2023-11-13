package saucedemo.tests;

import internet.BaseTest;
import org.testng.Assert;
import saucedemo.pages.ErrorPage;
import org.testng.annotations.Test;

public class ErrorTest extends BaseTest {
    @Test
    public void emptyTest() {
        var errorPage = new ErrorPage();

        // Info, mida sisestame sisselogimisel
        var username = "standard_user";
        var password = "secret_sauce";

        // Mis veateade tuleb ette
        String actualMessage, expectedMessage = "Error: First Name is required";

        // Mitu punast välja peab tekkima
        int actualErrorCount, expectedErrorCount = 3;

        visit(errorPage.getUrl());

        // Logida sisse
        errorPage
                .fillUsername(username)
                .fillPassword(password)
                .clickLogin()
                .addListing();

        // Navigeerida kassasse ja jätta vahele info täitmine
        errorPage
                .goToCheckout()
                .validateCart()
                .confirmCheckout();

        actualMessage = errorPage.checkForErrorMessage();
        actualErrorCount = errorPage.checkForRedFields();

        Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertEquals(expectedErrorCount, actualErrorCount);
    }
}
