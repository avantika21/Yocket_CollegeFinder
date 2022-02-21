package com.yocket.pages;

import com.yocket.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends TestBase {

    @FindBy(id="login-user-button")
    WebElement loginButton;

    @FindBy(id="college-finder")
    WebElement CollegeFinderBtn;



    public LandingPage(){
        PageFactory.initElements(driver, this);
    }

    public String titleOfPage(){
        return driver.getTitle();
    }

    public LoginPage login(){
        loginButton.click();
        return new LoginPage();
    }

    public CollegeFinderHomePage collegefinder(){
        CollegeFinderBtn.click();
        return new CollegeFinderHomePage();
    }

}
