import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "D:\\Getting started with Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLoginPageUI() {
        Assert.assertTrue(loginPage.findLoginImageEl().isDisplayed() , "Login Image is not displayed");
        Assert.assertEquals(loginPage.findLoginHeadingEl() , "Login" , "Login Page Heading Does't Match");
        Assert.assertEquals(loginPage.getLabelTextAt(0) , "USERNAME" , "Username label text doesnot match");
        Assert.assertEquals(loginPage.getLabelTextAt(1) , "PASSWORD" , "Password label text doesnot match");
        Assert.assertEquals(loginPage.displayLoginBtn() , true , "Login Button Not Displayed");
    }

    @Test(priority = 1)
    public void testLoginWithEmptyInputs(){
        loginPage.clickOnLoginBtn();
        String actualErrorMsg = loginPage.getErrorMsgEl();
        Assert.assertEquals(actualErrorMsg , "*Username or password is invalid" , "Error Message doesnot match");
    }

    @Test(priority = 2)
    public void testLoginWithEmptyUsername(){
        loginPage.loginToApplication("" , "rahul@2021");
        String actualErrorMsg = loginPage.getErrorMsgEl();
        Assert.assertEquals(actualErrorMsg ,"*Username or password is invalid" , "Error Text with empty Username doesnot match");
    }

    @Test(priority = 3)
    public void testLoginWithEmptyPassword(){
        loginPage.loginToApplication("rahul" , "");
        String actualErrorMsg = loginPage.getErrorMsgEl();
        Assert.assertEquals(actualErrorMsg ,"*Username or password is invalid" , "Error Text with empty Password doesnot match");
    }

    @Test(priority = 4)
    public void testLoginWithInValidCrediantials(){
        loginPage.loginToApplication("rahul" , "rahul2021");
        String actualErrorMsg = loginPage.getErrorMsgEl();
        Assert.assertEquals(actualErrorMsg ,"*username and password didn't match" , "Error Text with invalid Password doesnot match");
    }

    @Test(priority = 5)
    public void testLoginWithValidCrediantials(){
        loginPage.loginToApplication("rahul" , "rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");
    }
}
