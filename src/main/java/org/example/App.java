package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://dnev-nik.ru/");

        WebElement webLogin = driver.findElement(By.name("login"));
        webLogin.sendKeys("bmv50");

        WebElement webPass = driver.findElement(By.name("parol"));
        webPass.sendKeys("123456");

        WebElement webSubmit = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div/input[2]"));
        webSubmit.click();

        //driver.quit();
    }
}
