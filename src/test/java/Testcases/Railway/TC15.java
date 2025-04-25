package Testcases.Railway;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.HomePage;
import pageobjects.Railway.LoginPage;
import pageobjects.Railway.TimeTablePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC15 extends BaseTest {
    @Test
    public void TC15() throws InterruptedException {
        System.out.println("TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        TimeTablePage trainTimetablePage = homePage.gotoTrainTimetablePage();
        trainTimetablePage.SelectbookTicketClick();
        Thread.sleep(2000);

        Select DepartFrom = new Select(Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[2]/select")));
        Select ArriveStation = new Select(Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"ArriveStation\"]/select")));

        ArrayList<String> compare = new ArrayList<String>();
        compare.add(DepartFrom.getFirstSelectedOption().getText());
        compare.add(ArriveStation.getFirstSelectedOption().getText());

        List<String> expectedInfo = Arrays.asList("Sài Gòn", "Huế");
        Assert.assertEquals(compare, expectedInfo, "Booking information doesn't match");
    }
}