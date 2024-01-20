import org.openqa.selenium.By;
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
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "D:\\Getting started with Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);

        loginPage.loginToApplication("rahul" , "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void clickOnEmptySearchBtn(){
        searchPage.clickOnEmptySearchBtn();
        searchPage.clickOnSearchInput();
        searchPage.enterMovieNameInSearch();
        searchPage.clickOnSearchBtn();

        Assert.assertEquals(searchPage.searchedResultItems() , 1 , "Searches Movies Doesnot matches");
    }
}
