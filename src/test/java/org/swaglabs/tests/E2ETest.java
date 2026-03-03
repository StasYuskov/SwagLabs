package org.swaglabs.tests;

import org.junit.jupiter.api.Test;

import org.swaglabs.pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class E2ETest extends BaseTest {

    @Test
    void successfulLogin() {
        ProductsPage productsPage = new LoginPage(driver)
                .open()
                .login("standard_user", "secret_sauce");

        assertTrue(productsPage.isVisibleDropdown());
        assertTrue(productsPage.header.isVisibleShoppingCartBtn());
    }

    @Test
    void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver)
                .open()
                .incorrectLogin("wrong", "wrong");

        assertTrue(loginPage.isVisibleErrorMessage());
    }

    @Test
    void addAndRemoveProductFromCart() {

        ProductsPage productsPage = new LoginPage(driver)
                .open()
                .login("standard_user", "secret_sauce");

        productsPage.addCountTopProductInCart(2);

        assertEquals(2, productsPage.header.getProductsInCartCount());
        assertTrue(productsPage.header.isVisibleShoppingCartBadge());

        CartPage cartPage = productsPage.header.goToCart();

        assertEquals(2, cartPage.getCountCartItems());

        cartPage.removeAllProductFromCart();

        assertEquals(0, cartPage.getCountCartItems());
    }

    @Test
    void verifyButtonsVisibility() {

        ProductsPage productsPage = new LoginPage(driver)
                .open()
                .login("standard_user", "secret_sauce");

        assertTrue(productsPage.isVisibleDropdown());
        assertTrue(productsPage.isVisibleAllProductsCartBtn());
        assertTrue(productsPage.header.isVisibleBurgerBtn());
        assertTrue(productsPage.footer.isVisibleSocialLinks());
    }

    @Test
    void fullCheckoutFlow() {

        ProductsPage productsPage = new LoginPage(driver)
                .open()
                .login("standard_user", "secret_sauce");

        productsPage.addCountTopProductInCart(3);

        CartPage cartPage = productsPage.header.goToCart();

        assertEquals(3, cartPage.getCountCartItems());

        CheckoutPage checkoutPage = cartPage.moveToCheckout();

        checkoutPage.fillOutForm("John", "Doe", "12345");

        CheckoutStepTwoPage stepTwoPage = checkoutPage.clickContinue();

        double itemsSum = stepTwoPage.getSumItemsPrice();
        double itemsTotal = stepTwoPage.getTotalItemsPrice();
        double tax = stepTwoPage.getTaxPrice();
        double total = stepTwoPage.getTotalPrice();

        assertEquals(itemsSum, itemsTotal);
        assertEquals(itemsTotal + tax, total);

        FinishPage finishPage = stepTwoPage.clickFinish();

        assertTrue(finishPage.isVisibleBackHomeBtn());
    }
}