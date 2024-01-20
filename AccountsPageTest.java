import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class AccountsPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AccountsPage accountsPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "D:\\Getting started with Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);

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
    public void testUIElementsOnAccountPage(){
        homePage.clickOnAvatarBtnAccount();
        Assert.assertEquals(accountsPage.accountPageHeading() , "Account" , "AccountsPage Heading doesnot match");
        Assert.assertEquals(accountsPage.memberShipHeading() , "Member ship" , "Membership Heading doesnot match");
        Assert.assertEquals(accountsPage.planDetailsHeading() , "Plan details" , "Plandetails Heading doesnot match");
        Assert.assertEquals(accountsPage.planParagraphHeading() , "Premium" , "PlanParagraph Heading doesnot match");
        Assert.assertEquals(accountsPage.planDetails() , "Ultra HD" , "PlanDetails doesnot match");

    }
    @Test(priority = 2)
    public void testLogOutFunctionality(){
        homePage.clickOnAvatarBtnAccount();
        accountsPage.clickOnAccountLogout();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        Assert.assertEquals(actualUrl , expectedUrl , "HomePage Navigation Doesnot matches");
    }
}
