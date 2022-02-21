package com.yocket.pages;

import com.yocket.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MastersResultPage extends TestBase {

    @FindBy(xpath = "//select")
    WebElement sortDropdown;

    @FindBy(xpath = "//div[2]//div//div[1]//span[1]//span[1]//span[1]")
    List<WebElement> sortedList;

    @FindBy(xpath = "//div[1]/div[1]/div[3]/div[2]/div/div/p[1]/a")
    List<WebElement> shortlistedUnivName ;

    @FindBy(xpath = "//a[2]/div[1]/span[1]/span[1]/*[name()='svg'][1]")
    WebElement applicationBtn;

    @FindBy(xpath = "//div[@class='py-4 rounded-md space-y-4 bg-gray-100 shadow-md']/div/div/div/div/a")
    List<WebElement> actualUnivName;

    public MastersResultPage(){
        PageFactory.initElements(driver, this);
    }

    public void sortAndShortlist(){
        Select dropDown = new Select(sortDropdown);
        dropDown.selectByValue("1");
    }

    public String getUnivName(){
        return shortlistedUnivName.get(0).getText();
    }

    public String getActualUnivName(){
        applicationBtn.click();
        return actualUnivName.get(0).getText();
    }










}
