package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.components.FooterComponent;
import org.swaglabs.pages.components.HeaderComponent;
import org.swaglabs.pages.components.SidebarComponent;

import static org.swaglabs.locators.pages.FinishPageLocators.*;

public class FinishPage extends BasePage{

    private final HeaderComponent header;
    private final FooterComponent footer;
    private final SidebarComponent sidebar;

    public FinishPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.footer = new FooterComponent(driver);
        this.sidebar = new SidebarComponent(driver);
    }

    // ==== TRANSITIONS ====

    public ProductsPage clickBackHome() {
        click(backBtn);
        return new ProductsPage(driver);
    }

    // ==== CHECKS ====

    public boolean isVisibleBackHomeBtn() {
        return isVisible(backBtn);
    }

}
