package Testcases.Railway;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.*;

public class TC06 extends BaseTest {
    @Test
    public void TC06() throws InterruptedException {
        System.out.println("TC06 - Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.getTxtUsername().sendKeys(Constant.USERNAME);
        loginPage.getTxtPassword().sendKeys(Constant.PASSWORD);
        loginPage.getBtnLogin().click();

        homePage = new HomePage();
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        boolean ticketPageIsDisplay = true;
        try {
            WebElement _lblManageTicket = Constant.WEBDRIVER.findElement(By.xpath("//*[@id='content']/h1"));
            ticketPageIsDisplay = _lblManageTicket.isDisplayed();
        } catch (NoSuchElementException e) {
            ticketPageIsDisplay = false;
        }

        Assert.assertTrue(ticketPageIsDisplay, "My ticket page is not displayed when user click My ticket tab");

        homePage = new HomePage();
        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        boolean managePasswordIsDisplay = true;
        try {
            WebElement changePasswordButton = Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Change Password']"));
            managePasswordIsDisplay = changePasswordButton.isDisplayed();
        } catch (NoSuchElementException e) {
            managePasswordIsDisplay = false;
        }

        Assert.assertTrue(managePasswordIsDisplay, "Change password page is not displayed when user click Change password tab");
        Thread.sleep(3000);
    }
}