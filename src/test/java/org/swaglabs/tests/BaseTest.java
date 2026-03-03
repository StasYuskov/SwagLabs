package org.swaglabs.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.swaglabs.configs.DriverFactory;

import java.util.Map;

import static org.swaglabs.configs.Configs.BASE_URL;
import static org.swaglabs.configs.Configs.BROWSER;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver(BROWSER);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", Map.of(
                    "credentials_enable_service", false,
                    "profile.password_manager_enabled", false
        ));
        driver.get(BASE_URL);
    }

    @AfterEach
    void quit() {
        DriverFactory.quitDriver();
    }
}
