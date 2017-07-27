package com.aroma.automation;





import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Rizwana
 */
public class Main {
    private WebDriver driver;

    @Before
    public void startWebDriver() {
    	//System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
    	System.setProperty("webdriver.chrome.driver", "/Users/rizwana/Documents/chromedriver");
    	driver = new ChromeDriver();
        
       // driver.navigate().to("http://localhost/stockadjustmentproj/index.php/auth/login/");
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }



    // Checks name field validation
    @Test
    public void Login() throws InterruptedException {
        driver.get("http://ec2-54-66-188-209.ap-southeast-2.compute.amazonaws.com/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("shamim7777@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("do")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-header")));

        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.className("page-header")).getText(), "Home" );
    }


  




    @After
    public void closeWebDriver(){
        driver.close();
    }
}