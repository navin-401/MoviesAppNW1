package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage {
    @FindBy(how = How.CLASS_NAME , using = "account-heading")
    WebElement accountPageHeadingEl;
    @FindBy(how = How.CSS , using = "div.membership-container>:first-child")
    WebElement membershipHeadingEl;
    @FindBy(how = How.CSS , using = "div.plan-container>:first-child")
    WebElement plandetailsHeadingEl;
    @FindBy(how = How.CLASS_NAME , using = "membership-username")
    WebElement membershipUsernameHeadingEl;
    @FindBy(how = How.CLASS_NAME , using = "membership-password")
    WebElement membershipPasswordHeadingEl;
    @FindBy(how = How.CLASS_NAME , using = "plan-paragraph")
    WebElement planParagraphHeadingEl;
    @FindBy(how = How.CLASS_NAME , using = "plan-details")
    WebElement planDetailsEl;
    @FindBy(how = How.CLASS_NAME , using = "logout-button")
    WebElement accountLogoutBtnEl;

    WebDriver driver;
    WebDriverWait wait;

    public AccountsPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);
    }

    public String accountPageHeading(){
        return accountPageHeadingEl.getText();
    }
    public String memberShipHeading(){
        return membershipHeadingEl.getText();
    }
    public String planDetailsHeading(){
        return plandetailsHeadingEl.getText();
    }
    public String membershipUsernameHeading(){
        return membershipUsernameHeadingEl.getText();
    }
    public String membershipPasswordHeading(){
        return membershipPasswordHeadingEl.getText();
    }
    public String planParagraphHeading(){
        return planParagraphHeadingEl.getText();
    }
    public String planDetails(){
        return planDetailsEl.getText();
    }
    public void clickOnAccountLogout(){
        accountLogoutBtnEl.click();
    }
}
