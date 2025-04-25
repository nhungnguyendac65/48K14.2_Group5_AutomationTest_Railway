package Testcases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.LoginPage;

public class TC08 extends BaseTest {
    @Test
    public void TC08() throws InterruptedException {
        System.out.println("TC08 - User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.getTxtUsername().sendKeys("invaliduser@gmail.com");
        loginPage.getTxtPassword().sendKeys("invalid password");
        loginPage.getBtnLogin().click();

        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
        Thread.sleep(10000);
    }
}