package Testcases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.RegisterPage;

public class TC10 extends BaseTest {
    @Test
    public void TC10() throws InterruptedException {
        System.out.println("TC10 - User can't create account with Confirm password is not the same with Password");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        registerPage.enterEmail().sendKeys("nhungnguyendac652004@gmail.com");
        registerPage.enterPassword().sendKeys("12345678");
        registerPage.enterConfirmPassword().sendKeys("87654321");
        registerPage.enterPersonalID().sendKeys("123456789");
        registerPage.getbtnRegister().submit();

        String actualSuccessMsg = registerPage.getLblRegisterErrorMsg().getText();
        String expectedSuccessMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Success message is not displayed as expected");
        Thread.sleep(10000);
    }
}