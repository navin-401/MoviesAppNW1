import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;
import java.util.List;

public class PopularPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "D:\\Getting started with Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        popularPage = new PopularPage(driver);

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
    public void popularPageCount(){
        homePage.clickonNavbarPopularItem();
        Assert.assertEquals(popularPage.moviesItemListCount() , 30 , "Popular tab items list doesnot displayed");
        /*List<WebElement> populatItems = driver.findElements(By.className("movie-icon-item"));
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        if(populatItems.size() == 30){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }*/
    }
}
