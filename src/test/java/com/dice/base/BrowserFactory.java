package com.dice.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser, Logger logger) {
        WebDriver driver;
        logger.info("Starting " + browser + " driver");
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver",
                        "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver",
                        "src/main/resources/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver",
                        "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
