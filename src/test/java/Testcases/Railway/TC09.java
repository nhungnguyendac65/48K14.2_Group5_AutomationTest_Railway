package Testcases.Railway;

import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.ChangePasswordPage;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.LoginPage;

public class TC09 extends BaseTest {
    @Test
    public void TC09() throws InterruptedException {
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.getTxtUsername().sendKeys(Constant.USERNAME);
        loginPage.getTxtPassword().sendKeys(Constant.PASSWORD);
        loginPage.getBtnLogin().click();

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.getTxtCurrentPassword().sendKeys(Constant.PASSWORD);
        changePasswordPage.getTxtNewPassword().sendKeys("12345678");
        changePasswordPage.getTxtConfirmPassword().sendKeys("12345678");
        changePasswordPage.getBtnChangePassword().click();

        String actualSuccessMsg = changePasswordPage.getLblChangePasswordErrorMsg().getText();
        String expectedSuccessMsg = "Your password has been updated";

        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Success message is not displayed as expected");
        Thread.sleep(10000);
    }
}