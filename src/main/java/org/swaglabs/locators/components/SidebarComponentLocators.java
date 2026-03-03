package org.swaglabs.locators.components;

import org.openqa.selenium.By;

public class SidebarComponentLocators {
    public static final By resetAppMenuItem = By.cssSelector("a[data-test='reset-sidebar-link']");
    public static final By allItemsMenuItem = By.cssSelector("a[data-test='inventory-sidebar-link']");
    public static final By aboutMenuItem = By.cssSelector("a[data-test='about-sidebar-link']");
    public static final By logoutMenuItem = By.cssSelector("a[data-test='logout-sidebar-link']");

}
