package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class HomePage {
    @FindBy(how = How.CLASS_NAME , using = "movies-list-heading")
    List<WebElement> homepageMoviesListHeadingEl;
    @FindBy(how = How.TAG_NAME , using = "button")
    WebElement playBtnEl;
    @FindBy(how = How.CLASS_NAME , using = "slick-slide")
    List<WebElement> trendingSectionEl;
    @FindBy(how = How.CLASS_NAME , using = "contact-us-paragraph")
    WebElement contactUsEl;
    @FindBy(how = How.CLASS_NAME , using = "website-logo")
    WebElement homePageLogoEl;
    @FindBy(how = How.XPATH , using = "//ul[@class=\"nav-menu-list\"]//li//a")
    List<WebElement> navbarListEl;
    @FindBy(how = How.XPATH , using = "//a[text() = \"Popular\"]")
    WebElement navbarItemPopularEl;
    @FindBy(how = How.XPATH , using = "//a[text() = \"Home\"]")
    WebElement navbarItemHomeEl;
    @FindBy(how = How.CLASS_NAME , using = "avatar-button")
    WebElement avatarBtnEl;
    @FindBy(how = How.XPATH , using = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[1]")
    WebElement oneMovieSelectionEl;
    @FindBy(how = How.CLASS_NAME , using = "movie-title")
    WebElement movieTitleHeadingEl;

    WebDriver driver;
    WebDriverWait wait;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);
    }

    public String getHomePageMoviesListHeadings(int index){
        return homepageMoviesListHeadingEl.get(index).getText();
    }
    public WebElement playBtnDisplay(){
        return playBtnEl;
    }
    public int trendingSectionCount(){
        return trendingSectionEl.size();
    }
    public String contactUsTextHeading(){
        return contactUsEl.getText();
    }
    public WebElement homePageLogoDisplay(){
        return homePageLogoEl;
    }
    public String getNavbarListItems(int index){
        return navbarListEl.get(index).getText();
    }
    public void clickonNavbarPopularItem(){
        navbarItemPopularEl.click();
    }
    public void clickonNavbarHomeItem(){
        navbarItemHomeEl.click();
    }
    public void clickOnAvatarBtnAccount(){
        avatarBtnEl.click();
    }
    public void clickOnOneMovie(){
        oneMovieSelectionEl.click();
    }
    public String movieTitleHeading(){
        return movieTitleHeadingEl.getText();
    }
}

