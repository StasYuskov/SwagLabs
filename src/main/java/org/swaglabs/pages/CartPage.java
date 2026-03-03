package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.swaglabs.pages.components.FooterComponent;
import org.swaglabs.pages.components.HeaderComponent;
import org.swaglabs.pages.components.SidebarComponent;

import java.util.List;
import java.util.stream.Collectors;

import static org.swaglabs.locators.pages.CartPageLocators.*;

public class CartPage extends BasePage {

    private final HeaderComponent header;
    private final FooterComponent footer;
    private final SidebarComponent sidebar;

    public CartPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.footer = new FooterComponent(driver);
        this.sidebar = new SidebarComponent(driver);
    }

    // ==== GETTERS ====

    public List<WebElement> getCartItems() {
        return findAllNow(CartItem);
    }

    public int getCountCartItems() {
        return getCartItems().size();
    }

    public List<String> getProductNames() {
        return getCartItems()
                .stream()
                .map(inventoryItem -> inventoryItem.findElement(CartItemName).getText())
                .collect(Collectors.toList());
    }

    // ==== ACTIONS ====

    public CartPage removeAllProductFromCart() {
        List<WebElement> products = getCartItems();
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return this;
        }
        for (WebElement product: products) {
            product.findElement(removeFromCartBtn).click();
        }
        return this;
    }

    public CartPage removeProductFromCartByIndex(int index) {
        List<WebElement> products = getCartItems();
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return this;
        }
        if (index > products.size()) {
            index = products.size() - 1;
        }
        products.get(index).findElement(removeFromCartBtn).click();
        return this;
    }

    // ==== TRANSITIONS ====

    public ProductsPage continueShopping() {
        click(continueShoppingBtn);
        return new ProductsPage(driver);
    }

    public CheckoutPage moveToCheckout() {
        click(checkoutBtn);
        return new CheckoutPage(driver);
    }

    // ==== CHECKS ====

    public boolean isVisibleContinueShoppingBtn() {
        return isVisible(continueShoppingBtn);
    }

    public boolean isVisibleRemoveCartBtn() {
        return  isVisible(removeFromCartBtn);
    }

    public boolean isVisibleCheckoutBtn() {
        return isVisible(checkoutBtn);
    }

}
