package com.yocket.pages;

import com.yocket.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CollegeFinderMasters extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement enterCountry;

    @FindBy(xpath = "//input[@placeholder='Select Major']")
    WebElement enterCourse;


    //Step 1 Object repo
    @FindBy(xpath = "//span[normalize-space()= 'United Kingdom']")

    WebElement selectCountry;

    @FindBy(xpath = "//li[@id='vs2__option-0']")
    WebElement selectCourse;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement step1NextBtn;

    @FindBy(id = "zsiq_agtpic")
    WebElement chatBtn;

    @FindBy(xpath = "//div[@class='win_close sqico-larrow']")
    WebElement closeChat;

    //Step 2 Object Repo
    @FindBy(xpath = "//input[@placeholder='Select College']")
    WebElement enterCollege;

    @FindBy(xpath = "//li[@id='vs4__option-0']")
    WebElement selectCollege;

    @FindBy(xpath = "//input[@placeholder='Select Major']")
    WebElement enterMajor;

    @FindBy(xpath = "//li[@id='vs6__option-0']")
    WebElement selectMajor;

    @FindBy(id = "marks")
    WebElement enterGPA;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement step2NextBtn;

    //Define String IELTS
    @FindBy(xpath = "//div[contains(text(),'IELTS')]")
    WebElement engishTest;

    @FindBy(id = "ielts_overall_score")
    WebElement enterScore;

    @FindBy(xpath = "//div[contains(text(),'GMAT')]")
    WebElement aptitudeTaken;

    @FindBy(id = "total_gmat_score")
    WebElement aptitudeScore;

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement step3NextBtn;

    @FindBy(id = "work_exp")
    WebElement workEx;

    @FindBy(xpath = "//div[contains(text(),'National')]")
    WebElement researchPaper;

    @FindBy(id = "project")
    WebElement projectNum;

    @FindBy(xpath = "//button[normalize-space()='Find Universities']")
    WebElement findUnivBtn;

    @FindBy(xpath = "//div[@class='grid grid-cols-2 gap-6 mt-8']//div[1]//span//span")
    WebElement countryErrorMsg;

    @FindBy(xpath = "//div[@class='grid grid-cols-2 gap-6 mt-8']//div[2]//span[1]//span[1]")
    WebElement courseErrorMsg;

    @FindBy(xpath="//div[@class='grid grid-cols-2 gap-6 mt-8']/div[1]/span[1]/span[1]")
    WebElement collegeErrorMsg;

    @FindBy (xpath ="//div[@class='grid grid-cols-2 gap-6 mt-8']//div[3]//span[1]//span[1]")
    WebElement majorErrorMsg;

    @FindBy (xpath ="//div[@class='grid grid-cols-2 gap-6 mt-8']//div[4]//span[1]//span[1]")
    WebElement GPAErrorMsg;


    public CollegeFinderMasters() {
        PageFactory.initElements(driver, this);
    }

    public void fillStep1Details(String Country, String Course) {
        enterCountry.sendKeys(Country);
        wait.until(ExpectedConditions.visibilityOf(selectCountry));
        selectCountry.click();
        enterCourse.sendKeys(Course);
        wait.until(ExpectedConditions.visibilityOf(selectCourse));
        selectCourse.click();
        step1NextBtn.click();
    }

    public void fillStep2Details(String College, String Major, String GPA) {
        enterCollege.sendKeys(College);
        wait.until(ExpectedConditions.visibilityOf(selectCollege));
        selectCollege.click();
        enterMajor.sendKeys(Major);
        wait.until(ExpectedConditions.visibilityOf(selectMajor));
        selectMajor.click();
        enterGPA.sendKeys(GPA);
        step2NextBtn.click();
    }

    public void fillStep3Details(String englishScore, String aptiScore) {
        engishTest.click();
        enterScore.sendKeys(englishScore);
        aptitudeTaken.click();
        aptitudeScore.sendKeys(aptiScore);
        step3NextBtn.click();
    }

    public MastersResultPage fillStep4Details(String workExNo, String projectNo) {
        workEx.sendKeys(workExNo);
        researchPaper.click();
        projectNum.sendKeys(projectNo);
        findUnivBtn.click();
        return new MastersResultPage();
    }


    public void invalidCountry(String Country) {
        enterCountry.sendKeys(Country);
        step1NextBtn.click();
        wait.until(ExpectedConditions.visibilityOf(countryErrorMsg));
    }

    public void invalidCourse(String Country, String Course) {

        enterCountry.sendKeys(Country);
        wait.until(ExpectedConditions.visibilityOf(selectCountry));
        selectCountry.click();
        enterCourse.sendKeys(Course);
        step1NextBtn.click();
    }

    public void invalidCollege(String College) {
        enterCollege.sendKeys(College);
        step2NextBtn.click();
    }

    public void invalidMajor(String College, String Major) {

        enterCollege.sendKeys(College);
        wait.until(ExpectedConditions.visibilityOf(selectCollege));
        selectCollege.click();
        enterMajor.sendKeys(Major);
        step2NextBtn.click();
    }

    public void invalidGPA(String College, String Major, String GPA) {
        enterCollege.sendKeys(College);
        wait.until(ExpectedConditions.visibilityOf(selectCollege));
        selectCollege.click();
        enterMajor.sendKeys(Major);
        wait.until(ExpectedConditions.visibilityOf(selectMajor));
        selectMajor.click();
        enterGPA.sendKeys(GPA);
        step2NextBtn.click();
    }

    public String getCountryErrorMsg(){
        return countryErrorMsg.getText();
    }

    public String getCourseErrorMsg(){
        return courseErrorMsg.getText();
    }

    public String getCollegeErrorMsg(){
        return collegeErrorMsg.getText();
    }

    public String getMajorErrorMsg(){
        return majorErrorMsg.getText();
    }

    public String getGPAErrorMsg(){
        return GPAErrorMsg.getText();
    }


}
