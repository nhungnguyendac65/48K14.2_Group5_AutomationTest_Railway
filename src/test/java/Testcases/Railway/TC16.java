package Testcases.Railway;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.BookTicketPage;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.LoginPage;
import pageobjects.Railway.MyTicketPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TC16 extends BaseTest {
    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        String username = Constant.USERNAME;
        String pass = Constant.PASSWORD;
        loginPage.login(username, pass);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        LocalDate currentDate = LocalDate.now().plusDays(4);
        String departDate = currentDate.format(DateTimeFormatter.ofPattern("d"));

        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectDepartFrom("Sài Gòn");
        bookTicketPage.selectArriveStation("Nha Trang");
        bookTicketPage.selectSeatType("Soft bed with air conditioner");
        bookTicketPage.selectTicketAmount("1");
        bookTicketPage.clickBookTicketButton();

        String url = Constant.WEBDRIVER.getCurrentUrl();
        String[] urls = url.split("id=");
        String delete = urls[1];
        String xp = "//input[@onclick='DeleteTicket(" + delete + ");']";

        MyTicketPage ticket = homePage.gotoMyTicketPage();
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ticket.clickCancelButton(xp);
        Constant.WEBDRIVER.switchTo().alert().accept();

        boolean isTicketDisplayed = true;
        try {
            WebElement CancelButtonElement = Constant.WEBDRIVER.findElement(By.xpath(xp));
            isTicketDisplayed = CancelButtonElement.isDisplayed();
        }
        catch (NoSuchElementException e) {
            isTicketDisplayed = false;
        }

        Assert.assertFalse(isTicketDisplayed, "The ticket does not disappear");
    }
}