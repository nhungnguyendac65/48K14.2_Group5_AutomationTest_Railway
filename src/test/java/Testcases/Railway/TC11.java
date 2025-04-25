package Testcases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.RegisterPage;

public class TC11 extends BaseTest {
    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        registerPage.enterEmail().sendKeys("nhungabaaa@gmail.com");
        registerPage.enterPersonalID().sendKeys("");
        registerPage.getbtnRegister().submit();

        String actualSuccessMsg = registerPage.getLblRegisterErrorMsg().getText();
        String expectedSuccessMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Success message is not displayed as expected");

        String actualPasswordLengthMsg = registerPage.getLblPasswordLengthErrorMsg().getText();
        String expectedPasswordLengthMsg = "Invalid password length.";
        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Invalid password length message is not displayed as expected");

        String actualIdLengthMsg = registerPage.getLblIdLengthErrorMsg().getText();
        String expectedIdLengthMsg = "Invalid ID length.";
        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Invalid ID length message is not displayed as expected");
    }
}