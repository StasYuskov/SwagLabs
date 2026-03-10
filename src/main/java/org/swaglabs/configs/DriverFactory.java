package org.swaglabs.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverFactory {


    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {

    }

    public static WebDriver createDriver(String browser) {

        if (browser == null) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();

                // Отключаем сохранение пароля
                options.addArguments("--guest");
                options.addArguments("--headless=new"); // обязательно для Linux-контейнера
                options.addArguments("--no-sandbox");   // часто требуется в Docker
                options.addArguments("--disable-dev-shm-usage"); // для маленькой shared memory
                options.addArguments("--remote-allow-origins=*"); // для последних версий ChromeDriver
                driver.set(new ChromeDriver(options));
                break;
            }
            case "firefox": {
                driver.set(new FirefoxDriver());
                break;
            }
            default: {
                throw new IllegalArgumentException("This browser not supported" + browser);
            }
        }
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
