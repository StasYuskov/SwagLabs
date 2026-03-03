package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.components.FooterComponent;
import org.swaglabs.pages.components.HeaderComponent;
import org.swaglabs.pages.components.SidebarComponent;

import static org.swaglabs.locators.pages.ProductItemPageLocators.*;

public class ProductItemPage extends BasePage{

    public final HeaderComponent header;
    public final FooterComponent footer;
    public final SidebarComponent sidebar;

    public ProductItemPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.footer = new FooterComponent(driver);
        this.sidebar = new SidebarComponent(driver);
    }

    // ==== GETTERS ====

    public String getProductName() {
        return getText(productName);
    }

    // ==== ACTIONS ====

    public ProductItemPage addProductInCart() {
        click(addToCartBtn);
        return this;
    }

    public ProductItemPage removeProductFromCart() {
        click(removeFromCartBtn);
        return this;
    }

    // ==== TRANSITIONS ====

    public ProductsPage backToProducts() {
        click(backToProductsBtn);
        return new ProductsPage(driver);
    }

    // ==== CHECKS ====

    public boolean isVisibleProductCartBtn() {
        return  isVisible(addToCartBtn) || isVisible(removeFromCartBtn);
    }


}
