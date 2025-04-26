package Testcases.Railway;

import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.BookTicketPage;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.LoginPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class TC14 extends BaseTest {
    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        LocalDate currentDate = LocalDate.now().plusDays(4);
        String departDate = currentDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectDepartFrom("Sài Gòn");
        bookTicketPage.selectArriveStation("Nha Trang");
        bookTicketPage.selectSeatType("Soft bed with air conditioner");
        bookTicketPage.selectTicketAmount("1");
        bookTicketPage.clickBookTicketButton();

        String expectedMsg = "Ticket booked successfully!";
        String actualMsg = bookTicketPage.getLblBookTicketSuccessMsg().getText();
        Assert.assertEquals(actualMsg, expectedMsg, "Success message doesn't match");

        List<String> bookingInfo = bookTicketPage.getBookingInformation();
        String expectedDepartDate = currentDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
        List<String> expectedInfo = Arrays.asList("Sài Gòn", "Nha Trang", "Soft bed with air conditioner", expectedDepartDate, "1");

        Assert.assertEquals(bookingInfo, expectedInfo, "Booking information doesn't match");
    }
}