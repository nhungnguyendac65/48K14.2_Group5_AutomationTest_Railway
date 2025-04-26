package Testcases.Railway;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.*;

public class TC13 extends BaseTest {
    @Test
    public void TC13() {
        System.out.println("TC13 - Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPasswordPage forgotPasswordPage = homePage.gotoForgotPasswordPage();

        forgotPasswordPage.getTxtEmailAddress().sendKeys("nhungnguyendac652004@gmail.com");
        forgotPasswordPage.getBtnSendInstructors().click();

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        boolean managePasswordIsDisplay = true;
        try {
            WebElement changePasswordButton = Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Change Password']"));
            managePasswordIsDisplay = changePasswordButton.isDisplayed();
        } catch (NoSuchElementException e) {
            managePasswordIsDisplay = false;
        }

        Assert.assertTrue(managePasswordIsDisplay, "Could not reset password. Please correct the errors and try again.");

        changePasswordPage.getTxtCurrentPassword().sendKeys("12345678");
        changePasswordPage.getTxtNewPassword().sendKeys("123456789");
        changePasswordPage.getTxtConfirmPassword().sendKeys("123456789");
        changePasswordPage.getBtnChangePassword().click();

        String actualSuccessMsg = changePasswordPage.getLblChangePasswordErrorMsg().getText();
        String expectedSuccessMsg = "Could not reset password. Please correct the errors and try again.";

        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Error message is not displayed as expected");
    }
}