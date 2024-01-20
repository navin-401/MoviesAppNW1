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

public class HomePageTest {
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
    public void testHomePageHeadings(){
        Assert.assertEquals(homePage.getHomePageMoviesListHeadings(0) , "Trending Now" , "Movies List Heading text One doesnot match");
        Assert.assertEquals(homePage.getHomePageMoviesListHeadings(1) , "Originals" , "Movies List Heading text Second doesnot match");
        Assert.assertTrue(homePage.playBtnDisplay().isDisplayed() , "PlayButton is not Displayed");
        Assert.assertEquals(homePage.trendingSectionCount() , 20 , "Incorrect");
        Assert.assertEquals(homePage.contactUsTextHeading() , "Contact Us" , "Contact Us section doesnot match");
    }
}
