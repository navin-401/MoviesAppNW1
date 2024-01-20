package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    @FindBy(how = How.CLASS_NAME , using = "movie-icon-item")
    List<WebElement> moviesItemList;

    WebDriver driver;
    WebDriverWait wait;


    public PopularPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);
    }

    public int moviesItemListCount(){
        return moviesItemList.size();
    }
}
