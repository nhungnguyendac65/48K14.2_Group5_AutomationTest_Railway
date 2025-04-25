package Testcases.Railway;

import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.LoginPage;

public class TC01 extends BaseTest {
    @Test
    public void TC01(){
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}