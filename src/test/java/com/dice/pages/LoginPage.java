package com.dice.pages;

import com.dice.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject<LoginPage> {
    private static final String URL = "https://www.dice.com/dashboard/login";

    private By emailField = By.xpath("//*[@id='email']");
    private By passwordField = By.xpath("//*[@id='password']");
    private By signInButton = By.xpath("//*[@id='loginDataSubmit']/div[3]/div/button");
    private By errorMessage = By.xpath("//*[@id='loginDataSubmit']/div[2]/div[1]/div/div/span[1]");

    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openLoginPage() {
        getPage(URL);
    }

    public void fillOutEmailAndPassword(String email, String password) {
        logger.info("Filling up email and password");
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage pushSignInButton() {
        logger.info("Clicking on a sign in button");
        click(signInButton);
        return new ProfilePage(driver, logger);
    }

    public String getLogInErrorMessage() {
        waitForVisibilityOf(errorMessage, 10);
        return getText(errorMessage);
    }
}
