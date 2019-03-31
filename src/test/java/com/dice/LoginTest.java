package com.dice;

import com.dice.base.BaseTest;
import com.dice.base.CsvDataProvider;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test(priority = 1, groups = {"positive", "broken"})
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver, logger);
        // String expectedPageTitle = "Seeker Dashboard - Profile";
        String expectedPageTitle = "Create Profile";
        String correctProfileName = "Igor Lipko";
        // Open dice login page
        loginPage.openLoginPage();
        // Fill out login and password
        loginPage.fillOutEmailAndPassword("igor_lipko@mail.ru", "gbuh100co_CE");
        // Push login button and wait for profile page to load
        ProfilePage profilePage = loginPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();
        logger.info("Verifications");
        // - Verify the title of the page is correct
        String actualPageTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualPageTitle),
                "Page title is not expected \nExpected: " + expectedPageTitle + " \nActual: "
                        + actualPageTitle);
        // - Verify correct name on the profile page
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName),
                "Profile name is not expected");
    }

    @Test(priority = 1, groups = {"negative"}, dataProvider = "CsvDataProvider",
            dataProviderClass = CsvDataProvider.class)
    public void negativeLoginTest(Map<String, String> testData) {
        String expectedErrorMessage = "Email and/or password incorrect.";
        String number = testData.get("number");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        logger.info("Test N " + number + " for " + description + ". Where \nemail: " + email
                + " \npassword: " + password);

        LoginPage loginPage = new LoginPage(driver, logger);
        // Open dice login page
        loginPage.openLoginPage();
        // Fill out login and password
        loginPage.fillOutEmailAndPassword(email, password);
        // Push login button
        loginPage.pushSignInButton();
        String actualErrorMessage = loginPage.getLogInErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Error message is not expected \nExpected:" + expectedErrorMessage + " \nActual:"
                        + actualErrorMessage);
    }
}
