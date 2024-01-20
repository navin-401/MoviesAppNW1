import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HeaderSectionTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "D:\\Getting started with Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.loginToApplication("rahul" , "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void headerSectionUiTesting(){
        Assert.assertTrue(homePage.homePageLogoDisplay().isDisplayed() , "HomePage Logo is Not Displayed");
        Assert.assertEquals(homePage.getNavbarListItems(0) , "Home" , "Navbar list item Home Doesnot match");
        Assert.assertEquals(homePage.getNavbarListItems(1) , "Popular" , "Navbar list item Popular Doesnot match");
    }
    @Test(priority = 2)
    public  void testingHeaderSectionPopularFunctionalities(){
        homePage.clickonNavbarPopularItem();
        String expectedurl = "https://qamoviesapp.ccbp.tech/popular";
        String acutualUrl = driver.getCurrentUrl();
        Assert.assertEquals(acutualUrl , expectedurl , "Popular navbar item Url doesnot match");
    }
    @Test(priority = 3)
    public  void testingHeaderSectionHomeFunctionalities(){
        homePage.clickonNavbarHomeItem();
        String expectedurl = "https://qamoviesapp.ccbp.tech/";
        String acutualUrl = driver.getCurrentUrl();
        Assert.assertEquals(acutualUrl , expectedurl , "Home navbar item Url doesnot match");
    }
    @Test(priority = 4)
    public void navigatingToAccountPage(){
        homePage.clickOnAvatarBtnAccount();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl , expectedUrl , "Account Page Navigation Doesnot Match");
    }
}
