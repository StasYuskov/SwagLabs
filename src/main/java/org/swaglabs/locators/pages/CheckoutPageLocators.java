package org.swaglabs.locators.pages;

import org.openqa.selenium.By;

public class CheckoutPageLocators {
    public static final By continueBtn = By.cssSelector("[data-test='continue']");
    public static final By cancelBtn = By.cssSelector("button[data-test='cancel']");
    public static final By firstNameInput = By.cssSelector("[data-test='firstName']");
    public static final By lastNameInput = By.cssSelector("[data-test='lastName']");
    public static final By codeInput = By.cssSelector("[data-test='postalCode']");
    public static final By errorMessage = By.cssSelector("[data-test='error']");
    public static final By closeErrorMessageBtn = By.cssSelector("data-test='error-button'");

}
