package com.yocket.Base;

import com.yocket.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;


    //TestBase class constructor

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/yocket/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Browser and URL initialisation

    public static void initialisation(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            String CurrentUserDir = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver",CurrentUserDir+"\\src\\main\\java\\com\\yocket\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if(browserName.equals("firefox")){
            String CurrentUserDir = System.getProperty("user.dir");
            System.setProperty("webdriver.gecko.driver",CurrentUserDir+"\\src\\main\\java\\com\\yocket\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
    }



}
