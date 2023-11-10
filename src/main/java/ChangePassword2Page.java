import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ChangePassword2Page extends BasePage {

    private WebDriverWait wait;

    public ChangePassword2Page(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(css = ".skip-account > .label")
    private WebElement accountDropdown;

    @FindBy(linkText = "Log In")
    private WebElement login;

    @FindBy(id = "email")
    private WebElement user;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(css = "#send2 > span > span")
    private WebElement sendLogin;

    @FindBy(linkText ="Change Password")
    private WebElement changePassword;

    @FindBy(name= "current_password")
    private WebElement currentPassword;

    @FindBy(id = "confirmation")
    private WebElement confirmPassword;

    @FindBy(css = ".form-list:nth-child(4)")
    private WebElement saveChanges;

    @FindBy(css = ".skip-account > .label")
    private WebElement logout;


    public void clickAccountDropdown() {
        accountDropdown.click();
    }

    public void getLogin() {
        login.click();
    }

    public void setUserMail() {
        user.sendKeys("adinaianosi@gmail.com");
    }


    public void setPassword() {
        passwordField.sendKeys("thispassword");
    }
    public void getLoginSend() {
        sendLogin.click();
    }

    public void setChangePassword() {
        changePassword.click();
    }
    public void setCurrentPassword() {
        currentPassword.sendKeys("anotherpassword");
    }

    public void setConfirmPassword() {
        confirmPassword.sendKeys("anotherpassword");
    }

    public void getSaveChanges() {
        saveChanges.click();
    }

    public void getLogout() {
        logout.click();

    }



}




