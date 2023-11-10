// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.io.FileNotFoundException;
import java.util.*;

public class ChangePassword2Test extends Hooks{
    private ChangePassword2Page changePassword2Page ;

    //private String actualPassword = "anotherpassword";


    @Before
    public void setupPageObject() {
        changePassword2Page = new ChangePassword2Page(driver);
        driver.manage().window().maximize();
    }

   @Test
    public void changePassword2() throws InterruptedException, FileNotFoundException {
        changePassword2Page.clickAccountDropdown();
        changePassword2Page.getLogin();
        changePassword2Page.setUserMail();
        changePassword2Page.setPassword();
        changePassword2Page.getLoginSend();
        Thread.sleep(2500);
        changePassword2Page.setChangePassword();
        changePassword2Page.setCurrentPassword();
        changePassword2Page.setConfirmPassword();
        changePassword2Page.getSaveChanges();
        changePassword2Page.getLogout();


    }
}