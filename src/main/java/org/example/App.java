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

        WebElement webSubmitAuth = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div/input[2]"));
        webSubmitAuth.click();

        WebElement webNewRecord = driver.findElement(By.name("title"));
        webNewRecord.sendKeys("Новая запись");

        WebElement webRadio = driver.findElement(By.xpath("//*[@id=\"form54\"]/form/div/div/label[2]/input"));
        webRadio.click();

        WebElement webRecord = driver.findElement(By.name("text"));
        webRecord.sendKeys("Тестовая запись");

        WebElement webSubmitRecord = driver.findElement(By.xpath("//*[@id=\"form54\"]/form/input[4]"));
        webSubmitRecord.click();

        //driver.quit();
    }
}
