package Testcases.Railway;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Railway.HomePage;

public class TC04 extends BaseTest {
    @Test
    public void TC04() throws InterruptedException {
        System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
        HomePage homePage = new HomePage();
        homePage.open();

        if (!homePage.isUserLoggedIn()) {
            homePage.gotoLoginPage();
        }
        homePage.gotoBookTicketPage();

        // Kiểm tra xem trang đăng nhập có hiển thị không
        boolean isLoginPageDisplayed = true;
        try {
            WebElement usernameTextbox = Constant.WEBDRIVER.findElement(By.id("username"));
            WebElement passwordTextbox = Constant.WEBDRIVER.findElement(By.id("password"));
            WebElement loginButton = Constant.WEBDRIVER.findElement(By.xpath("//input[@value='login']"));

            isLoginPageDisplayed = usernameTextbox.isDisplayed() && passwordTextbox.isDisplayed() && loginButton.isDisplayed();
        }
        catch (NoSuchElementException e) {
            // Nếu không tìm thấy các phần tử của trang đăng nhập, thì trang không hiển thị
            isLoginPageDisplayed = false;
        }

        // Kiểm tra xem trang đăng nhập có hiển thị sau khi nhấn vào tab "Book ticket" không
        Assert.assertFalse(isLoginPageDisplayed, "Login page is not displayed when un-logged User clicks on 'Book ticket' tab");
        Thread.sleep(5000);
    }
}