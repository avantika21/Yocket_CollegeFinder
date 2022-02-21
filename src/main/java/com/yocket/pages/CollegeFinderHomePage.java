package com.yocket.pages;

import com.yocket.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CollegeFinderHomePage extends TestBase {

    @FindBy(xpath = "//button[normalize-space()='Masters']")
    WebElement mastersBtn;

    @FindBy(xpath = "//button[normalize-space()='Bachelors']")
    WebElement bachelorsBtn;

    public CollegeFinderHomePage(){
        PageFactory.initElements(driver, this);
    }

    public CollegeFinderMasters clickMasters(){

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(mastersBtn));

        mastersBtn.click();

        return new CollegeFinderMasters();
    }

    public CollegeFinderBachelors clickBachelors(){

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(bachelorsBtn));

        bachelorsBtn.click();

        return new CollegeFinderBachelors();
    }


}
