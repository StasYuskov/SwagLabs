package org.swaglabs.pages.components;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.BasePage;

import static org.swaglabs.locators.components.FooterComponentLocators.*;
import static org.swaglabs.locators.pages.ProductsPageLocators.sortDropdown;

public class FooterComponent extends BasePage {
    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    public void goToSocialTwitter() {
        openExternalLink(socialTwitterLink);
    }

    public void goToSocialFacebook() {
        openExternalLink(socialFacebookLink);
    }

    public void goToSocialLinkedin() {
        openExternalLink(socialLinkedinLink);
    }

    public boolean isVisibleSocialLinks() {
        return  isVisible(socialTwitterLink) && isVisible(socialFacebookLink) && isVisible(socialLinkedinLink);
    }
}
