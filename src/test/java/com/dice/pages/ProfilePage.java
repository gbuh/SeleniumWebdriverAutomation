package com.dice.pages;

import com.dice.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {

    private By loginName = By.xpath("//*[@id='dice-login-customer-name']");
    // private By thirdPartyYesButton = By.xpath("//*[@id='thirdPartyYes']");
    // private By profileContactNameText = By.xpath("//*[@id='dice-login-customer-name']");

    public ProfilePage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void waitForProfilePageToLoad() {
        logger.info("Wait for profile page to load");
        waitForVisibilityOf(loginName);
        // waitForVisibilityOf(thirdPartyYesButton, 10);
        // click(thirdPartyYesButton);
    }

    public boolean isCorrectProfileLoaded(String correctProfileName) {
        if (getText(loginName).equals(correctProfileName)) {
            return true;
        } else {
            return false;
        }
    }
}
