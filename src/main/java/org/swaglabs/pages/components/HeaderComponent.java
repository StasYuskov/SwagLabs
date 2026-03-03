package org.swaglabs.pages.components;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.BasePage;
import org.swaglabs.pages.CartPage;

import static org.swaglabs.locators.components.HeaderComponentLocators.*;

public class HeaderComponent extends BasePage {
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    // ==== GETTERS ====

    public int getProductsInCartCount() {
        try {
            return Integer.parseInt(find(shoppingCartBadge).getText());
        } catch (NullPointerException e) {
            return 0;
        }
    }

    // ==== ACTIONS ====

    public SidebarComponent openSidebar() {
        click(burgerMenuOpenBtn);
        return new SidebarComponent(driver);
    }

    public HeaderComponent closeSidebar() {
        click(burgerMenuCloseBtn);
        return new HeaderComponent(driver);
    }

    // ==== TRANSITIONS ====

    public CartPage goToCart() {
        click(shoppingCartLink);
        return new CartPage(driver);
    }

    // ==== CHECKS ====

    public boolean isVisibleShoppingCartBtn() {
        return  isVisible(shoppingCartLink);
    }

    public boolean isVisibleShoppingCartBadge() {
        return  isVisible(shoppingCartBadge);
    }

    public boolean isVisibleBurgerBtn() {
        return  isVisible(burgerMenuOpenBtn);
    }
}
