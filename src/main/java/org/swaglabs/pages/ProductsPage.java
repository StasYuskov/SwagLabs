package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.swaglabs.pages.components.FooterComponent;
import org.swaglabs.pages.components.HeaderComponent;
import org.swaglabs.pages.components.SidebarComponent;

import java.util.List;
import java.util.stream.Collectors;

import static org.swaglabs.locators.pages.ProductsPageLocators.*;

public class ProductsPage extends BasePage {

    public final HeaderComponent header;
    public final FooterComponent footer;
    public final SidebarComponent sidebar;

    // ==== CONSTRUCTOR ====

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.footer = new FooterComponent(driver);
        this.sidebar = new SidebarComponent(driver);
    }

    // ==== GETTERS ====

    private List<WebElement> getInventoryItems() {
        return findAll(inventoryItem);
    }

    public List<String> getProductNames() {
        return getInventoryItems()
                .stream()
                .map(inventoryItem -> inventoryItem.findElement(inventoryItemName).getText())
                .collect(Collectors.toList());
    }

    // ==== ACTIONS ====

    public ProductsPage applySorted(String value) {
        List<String> oldState = getProductNames();

        Select select = new Select(find(sortDropdown));
        select.selectByValue(value);

        wait.until(driver -> {
            List<String> newState = getProductNames();
            return !newState.equals(oldState);
        });
        return this;
    }

    public ProductsPage addCountTopProductInCart(int count) {

        List<WebElement> products = getInventoryItems();

        if (count > products.size()) {
            count = products.size() - 1;
        }

        for (int i = 0; i < count; i++) {
            products.get(i).findElement(addToCartBtn).click();
        }

        return this;
    }

    public ProductsPage removeAllProductFromCart() {

        List<WebElement> products = getInventoryItems();

        for (WebElement product: products) {
            product.findElement(removeFromCartBtn).click();
        }

        return this;
    }

    // ==== TRANSITIONS ====

    public ProductItemPage goToProductByIndex(int index) {
        List<WebElement> products = getInventoryItems();
        if (index > products.size()) {
            index = products.size() - 1;
        }
        click(products.get(index), goToProductCardLink);
        return new ProductItemPage(driver);
    }

    // ==== CHECKS ====

    public boolean isVisibleDropdown() {
        return  isVisible(sortDropdown);
    }

    public boolean isVisibleAllProductsCartBtn() {
        List<WebElement> products = getInventoryItems();
        System.out.println(products);
        int visibleCount = 0;
        for (WebElement product: products) {
            if (isVisible(product, addToCartBtn) || isVisible(product, removeFromCartBtn)) {
               visibleCount += 1;
            }
        }
        return visibleCount == products.size();
    }
}
