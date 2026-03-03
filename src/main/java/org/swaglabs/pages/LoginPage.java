package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import static org.swaglabs.configs.Configs.BASE_URL;
import static org.swaglabs.locators.pages.LoginPageLocators.*;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String patch = "/";

    // ==== ACTION ====

    public LoginPage open() {
        driver.get(BASE_URL + patch);
        return this;
    }

    public LoginPage incorrectLogin(String user, String pass) {
        type(userNameInput, user);
        type(passwordInput, pass);
        click(loginButton);
        return this;
    }

    public ProductsPage login(String user, String pass) {
        type(userNameInput, user);
        type(passwordInput, pass);
        click(loginButton);
        return new ProductsPage(driver);
    }

    public LoginPage closeErrorMessage() {
        click(closeErrorMessageBtn);
        return this;
    }

    // ==== CHECKS ====

    public boolean isVisibleErrorMessage() {
        return isVisible(errorMessage);
    }

    public boolean isVisibleUserNameInput() {
        return isVisible(userNameInput);
    }

    public boolean isVisiblePasswordInput() {
        return isVisible(passwordInput);
    }

    public boolean isVisibleLoginBtn() {
        return isVisible(loginButton);
    }
}
