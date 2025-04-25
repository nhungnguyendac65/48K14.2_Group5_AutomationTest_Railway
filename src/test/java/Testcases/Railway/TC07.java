package Testcases.Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.*;

public class TC07 extends BaseTest {
    @Test
    public void TC07() throws InterruptedException {
        System.out.println("TC07 - User can create a new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String email = "test@example.com";
        String password = "password123";
        String pid = "123456789";

        registerPage.register(email, password, password, pid);
        Mess mess = new Mess();
        String congraMsg = mess.getCongraMsg().getText();
        String expectedMessage = "Thank you for registering your account";

        Assert.assertTrue(congraMsg.contains(expectedMessage), "Registration Confirmed! You can now log in to the site.");
        Thread.sleep(10000);
    }
}