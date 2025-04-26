package Testcases.Railway;

import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.LoginPage;

public class TC05 extends BaseTest {
    @Test
    public void TC05() throws InterruptedException {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        for (int i = 0; i < 4; i++) {
            loginPage.login(Constant.USERNAME, "invalidPassword");
        }

        loginPage.login(Constant.USERNAME, "invalidPassword");
        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
        Thread.sleep(10000);
    }
}