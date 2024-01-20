package pages;

import  org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    @FindBy(how = How.CLASS_NAME , using = "login-website-logo")
    WebElement loginImageEl;
    @FindBy(how = How.CLASS_NAME , using = "sign-in-heading")
    WebElement loginHeadingEl;
    @FindBy(how = How.CLASS_NAME , using = "input-label")
    List<WebElement> labelElements;
    @FindBy(how = How.CLASS_NAME , using = "login-button")
    WebElement loginBtnEl;
    @FindBy(how = How.ID , using = "usernameInput")
    WebElement usernameInputEl;
    @FindBy(how = How.ID , using = "passwordInput")
    WebElement passwordInputEl;
    @FindBy(how = How.CLASS_NAME , using = "error-message")
    WebElement errorMsgEl;


    WebDriver driver ;
    WebDriverWait wait;


    public LoginPage (WebDriver driver){
        this.driver = driver ;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);
    }

    public WebElement findLoginImageEl(){
        return loginImageEl;
    }
    public String findLoginHeadingEl(){
        return loginHeadingEl.getText();
    }
    public String getLabelTextAt(int index){
        return labelElements.get(index).getText();
    }
    public void enterUsername(String username){
        usernameInputEl.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInputEl.sendKeys(password);
    }
    public Boolean displayLoginBtn(){
        return loginBtnEl.isDisplayed();
    }
    public void clickOnLoginBtn(){
        loginBtnEl.click();
    }

    public void loginToApplication(String username , String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginBtn();
    }

    public String getErrorMsgEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMsgEl.getText();
    }
}
