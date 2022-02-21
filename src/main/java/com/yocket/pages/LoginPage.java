package com.yocket.pages;

import com.yocket.Base.TestBase;
import com.yocket.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage extends TestBase {

    TestUtil testUtil;

    //Object repository
    @FindBy(id="phone")
    WebElement phoneNumber;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement getOTPbutton;

    @FindBy(id="otp")
    WebElement otpField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement verifyOTPButton;

    @FindBy(id = "college-finder")
    WebElement collegeFinder;


    //Initialising Page Objects
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions

    public HomePage login (String phNum) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        //testUtil.switchFrame();
        wait.until(ExpectedConditions.visibilityOf(phoneNumber));
        phoneNumber.sendKeys(prop.getProperty("phoneNumber"));
       // testUtil.switchFrame();
        getOTPbutton.click();
        wait.until((ExpectedCondition<Boolean>) driver -> otpField.getAttribute("value").length() == 6);
        verifyOTPButton.click();
        return new HomePage();

    }

}
