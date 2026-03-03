package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.components.FooterComponent;
import org.swaglabs.pages.components.HeaderComponent;
import org.swaglabs.pages.components.SidebarComponent;

import static org.swaglabs.locators.pages.CheckoutPageLocators.*;

public class CheckoutPage extends BasePage{

    private final HeaderComponent header;
    private final FooterComponent footer;
    private final SidebarComponent sidebar;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.footer = new FooterComponent(driver);
        this.sidebar = new SidebarComponent(driver);
    }

    // ==== GETTERS ====



    // ==== ACTIONS ====

    public CheckoutPage fillOutForm(String firstName, String lastName, String code) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(codeInput, code);
        return this;
    }

    public CheckoutPage closeErrorMessage() {
        click(closeErrorMessageBtn);
        return this;
    }

    // ==== TRANSITIONS ====

    public CartPage clickCancel() {
        click(cancelBtn);
        return new CartPage(driver);
    }

    public CheckoutStepTwoPage clickContinue() {
        click(continueBtn);
        return new CheckoutStepTwoPage(driver);
    }

    // ==== CHECKS ====

    public boolean isVisibleContinueBtn() {
        return  isVisible(continueBtn);
    }

    public boolean isVisibleCancelBtn() {
        return isVisible(cancelBtn);
    }

    public boolean isVisibleFirstNameInput() {
        return isVisible(firstNameInput);
    }

    public boolean isVisibleLastNameInput() {
        return isVisible(lastNameInput);
    }

    public boolean isVisibleCodeInput() {
        return isVisible(codeInput);
    }

    public boolean isVisibleErrorMessage() {
        return isVisible(errorMessage);
    }

}
