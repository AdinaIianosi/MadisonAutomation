import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class LoginPage extends BasePage {
    private WebDriverWait wait;

    LoginPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 5);

    }
    @FindBy(css =".skip-account > .icon")
    private WebElement accountButton;
    @FindBy(css=".last:nth-child(6) > a")
    private WebElement last; //login from dropdown menu

    @FindBy(xpath = "//div[@class= 'page-title']")
    public  WebElement pageTitle;

    @FindBy(id = "email")
    private WebElement emailAdd;

    @FindBy(id ="pass")
    private WebElement myPassword;

    @FindBy(id ="send2")
    private WebElement clickLogin; // login with email and password

    @FindBy(css= "ul > li:nth-child(10) > a")
    private WebElement newsletter;

    @FindBy(css=".button:nth-child(2)")
    private WebElement subscribe;


    @FindBy(css=".skip-account > .icon")
    private WebElement profile;

    @FindBy(linkText = "Log Out")
    private WebElement logout;

    @FindBy(xpath ="//ul[@class= 'messages']")
    public WebElement subscriptionMessage;

     @FindBy(css = "div.page-title h1")
    public  WebElement logoutMessage;

    public void clickAccountButton(){
        accountButton.click();
    }

    public void getLoginButton(){
        last.click();
    }
    public void getEmail(String email){
        emailAdd.sendKeys(email);
    }
    public void getPassword(String password){
        myPassword.sendKeys(password);
    }

    public void getClickLogin (){
        clickLogin.click();
    }
    public void getSignInForm() {
        getEmail("adinaianosi@gmail.com");
        getPassword("anotherpassword");
    }

    public void clickNewsletter(){
        newsletter.click();
    }

    public void clickSubscribe(){
        subscribe.click();
    }

    public void clickProfile() {
        profile.click();
    }
    public void clickLogout() {
        logout.click();
    }

}