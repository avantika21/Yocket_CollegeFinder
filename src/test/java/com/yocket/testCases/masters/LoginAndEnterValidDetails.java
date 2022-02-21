package com.yocket.testCases.masters;

import com.yocket.Base.TestBase;
import com.yocket.pages.*;
import com.yocket.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginAndEnterValidDetails extends TestBase {
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    CollegeFinderHomePage collegeFinderHomePage;
    CollegeFinderMasters collegeFinderMasters;
    MastersResultPage mastersResultPage;

    String sheetName = "mastersDetails";

    //To initialise TestBase constructor first
    public LoginAndEnterValidDetails() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        landingPage = new LandingPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        collegeFinderHomePage = new CollegeFinderHomePage();
        collegeFinderMasters = new CollegeFinderMasters();
    }
    @DataProvider
    public Object[][] getTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;

    }

    @Test(dataProvider = "getTestData")
    public void loginAndValidDetails(String Country, String Course,
                                     String College, String Major, String GPA, String englishScore,
                                     String aptiScore, String workExNo, String projectNo) throws InterruptedException {
        loginPage = landingPage.login();
        homePage = loginPage.login(prop.getProperty("phoneNumber"));
        collegeFinderHomePage = homePage.clickCollegeFinderBtn();
        collegeFinderMasters = collegeFinderHomePage.clickMasters();
        collegeFinderMasters.fillStep1Details(Country,Course);
        collegeFinderMasters.fillStep2Details(College,Major,GPA);
        collegeFinderMasters.fillStep3Details(englishScore,aptiScore);
        mastersResultPage = collegeFinderMasters.fillStep4Details(workExNo,projectNo);
        mastersResultPage.sortAndShortlist();
        String expectedUnivName = mastersResultPage.getUnivName();
        String actualUnivName = mastersResultPage.getActualUnivName();
        Assert.assertEquals(expectedUnivName, actualUnivName);

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

}