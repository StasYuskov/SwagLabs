package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.swaglabs.pages.components.FooterComponent;
import org.swaglabs.pages.components.HeaderComponent;
import org.swaglabs.pages.components.SidebarComponent;

import java.util.List;

import static org.swaglabs.locators.pages.CheckoutStepTwoPageLocators.*;

public class CheckoutStepTwoPage extends BasePage {

    private final HeaderComponent header;
    private final FooterComponent footer;
    private final SidebarComponent sidebar;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.footer = new FooterComponent(driver);
        this.sidebar = new SidebarComponent(driver);
    }

    // ==== GETTERS ====

    public List<WebElement> getItems() {
        return findAll(cartItem);
    }

    public double getPrice( WebElement element) {
        String priceText = element.getText().replace("$", "").trim();
        return Double.parseDouble(priceText);
    }

    public double getItemPrice(WebElement item) {
        WebElement priceDiv = item.findElement(cartItemPrice);
        return getPrice(priceDiv);
    }

    public double getSumItemsPrice() {
        List<WebElement> items = getItems();
        return items.stream()
                .map(this::getItemPrice)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getTotalItemsPrice() {
        WebElement priceDiv = find(totalItemsPrice);
        String priceText = priceDiv.getText()
                .replace("Item total:", "")
                .replace("$", "")
                .trim();
        return Double.parseDouble(priceText);
    }

    public double getTaxPrice() {
        WebElement priceDiv = find(taxPrice);
        String priceText = priceDiv.getText()
                .replace("Tax:", "")
                .replace("$", "")
                .trim();
        return Double.parseDouble(priceText);
    }

    public double getTotalPrice() {
        WebElement priceDiv = find(totalPrice);
        String priceText = priceDiv.getText()
                .replace("Total:", "")
                .replace("$", "")
                .trim();
        return Double.parseDouble(priceText);
    }

    // ==== ACTIONS ====



    // ==== TRANSITIONS ====

    public CartPage clickCancel() {
        click(cancelBtn);
        return new CartPage(driver);
    }

    public FinishPage clickFinish() {
        click(finishBtn);
        return new FinishPage(driver);
    }

    // ==== CHECKS ====

    public boolean isVisibleFinishBtn() {
        return  isVisible(finishBtn);
    }

    public boolean isVisibleCancelBtn() {
        return isVisible(cancelBtn);
    }
}
