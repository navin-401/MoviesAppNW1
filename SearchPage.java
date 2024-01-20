package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    @FindBy(how = How.CLASS_NAME , using = "search-empty-button")
    WebElement emptySearchBtnEl;
    @FindBy(how = How.ID , using = "search")
    WebElement searchInputEl;
    @FindBy(how = How.CLASS_NAME , using = "search-button")
    WebElement searchBtnEl;
    @FindBy(how = How.CLASS_NAME , using = "movie-icon-item")
    List<WebElement> searchedResultItemsEl;

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);
    }

    public void clickOnEmptySearchBtn(){
        emptySearchBtnEl.click();
    }
    public void clickOnSearchInput(){
        searchInputEl.click();
    }
    public void enterMovieNameInSearch(){
        searchInputEl.sendKeys("Titanic");
    }
    public void clickOnSearchBtn(){
        searchBtnEl.click();
    }
    public int searchedResultItems(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
        return searchedResultItemsEl.size();
    }
}
