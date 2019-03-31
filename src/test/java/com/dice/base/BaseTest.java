package com.dice.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger;

    @BeforeClass(alwaysRun = true)
    protected void setUpClass(ITestContext context) {
        String testName = context.getCurrentXmlTest().getName();
        logger = Logger.getLogger(testName);
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    protected void methodSetUp(String browser) {
        logger.info("Method set up");
        driver = BrowserFactory.getDriver(browser, logger);
    }

    @AfterMethod(alwaysRun = true)
    protected void methodTearDown() {
        logger.info("Method tear down");
        driver.quit();
    }
}
