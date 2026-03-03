package org.swaglabs.locators.pages;

import org.openqa.selenium.By;

public class CheckoutStepTwoPageLocators {
    public static final By finishBtn = By.cssSelector("[data-test='finish']");
    public static final By cancelBtn = By.cssSelector("button[data-test='cancel']");
    public static final By cartItem = By.cssSelector("[data-test='inventory-item']");
    public static final By cartItemPrice = By.cssSelector("[data-test='inventory-item-price']");
    public static final By totalItemsPrice = By.cssSelector("[data-test='subtotal-label']");
    public static final By taxPrice = By.cssSelector("[data-test='tax-label']");
    public static final By totalPrice = By.cssSelector("[data-test='total-label']");
}
