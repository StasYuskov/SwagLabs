package org.swaglabs.locators.pages;

import org.openqa.selenium.By;

public class CartPageLocators {
    public static final By CartItem = By.cssSelector("[data-test='inventory-item']");
    public static final By CartItemName = By.cssSelector("[data-test='inventory-item-name']");
    public static final By removeFromCartBtn = By.cssSelector("button[data-test^='remove']");
    public static final By continueShoppingBtn = By.cssSelector("button[data-test='continue-shopping']");
    public static final By checkoutBtn = By.cssSelector("button[data-test='checkout']");
}
