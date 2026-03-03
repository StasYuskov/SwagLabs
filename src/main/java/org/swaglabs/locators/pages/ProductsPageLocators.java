package org.swaglabs.locators.pages;

import org.openqa.selenium.By;

public class ProductsPageLocators {
    public static final By sortDropdown = By.cssSelector(".product_sort_container");
    public static final By inventoryItem = By.cssSelector(".inventory_item");
    public static final By addToCartBtn = By.cssSelector("button[data-test^='add-to-cart']");
    public static final By goToProductCardLink = By.cssSelector("a[data-test^='item-'][data-test$='-title-link']");
    public static final By removeFromCartBtn = By.cssSelector("button[data-test^='remove']");
    public static final By inventoryItemName = By.cssSelector("div[data-test='inventory-item-name']");

}
