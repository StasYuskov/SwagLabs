package org.swaglabs.locators.pages;

import org.openqa.selenium.By;

public class ProductItemPageLocators {
    public static final By productName = By.cssSelector("div[data-test='inventory-item-name']");
    public static final By addToCartBtn = By.cssSelector("button[data-test='add-to-cart']");
    public static final By removeFromCartBtn = By.cssSelector("button[data-test='remove']");
    public static final By backToProductsBtn = By.cssSelector("button[data-test='back-to-products']");
}
