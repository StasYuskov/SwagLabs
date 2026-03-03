package org.swaglabs.pages.components;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.BasePage;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductsPage;

import static org.swaglabs.locators.components.SidebarComponentLocators.*;

public class SidebarComponent extends BasePage {
    public SidebarComponent(WebDriver driver) {
        super(driver);
    }

    // ==== ACTIONS ====

    public ProductsPage clickNavAllItems() {
        click(allItemsMenuItem);
        return new ProductsPage(driver);
    }

    public void clickNavAbout() {
        openExternalLink(aboutMenuItem);
    }

    public LoginPage clickNavLogout() {
        click(logoutMenuItem);
        return new LoginPage(driver);
    }

    public SidebarComponent resetApp() {
        click(resetAppMenuItem);
        return this;
    }

    // ==== CHECKS ====

    public boolean isVisibleNavMenuItems() {
        return isVisible(allItemsMenuItem) && isVisible(aboutMenuItem) && isVisible(logoutMenuItem) && isVisible(resetAppMenuItem);
    }

}
