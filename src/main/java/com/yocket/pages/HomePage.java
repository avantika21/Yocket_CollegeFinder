package com.yocket.pages;

import com.yocket.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends TestBase {

    @FindBy(id="college-finder")
    WebElement collegeFinderBtn;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public CollegeFinderHomePage clickCollegeFinderBtn(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(collegeFinderBtn));
        collegeFinderBtn.click();
        return new CollegeFinderHomePage();
    }


}
