package org.swaglabs.locators.pages;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By userNameInput = By.id("user-name");
    public static final By passwordInput = By.id("password");
    public static final By loginButton = By.id("login-button");
    public static final By closeErrorMessageBtn = By.cssSelector("[data-test='error-button']");
    public static final By errorMessage = By.cssSelector("[data-test='error']");
}
