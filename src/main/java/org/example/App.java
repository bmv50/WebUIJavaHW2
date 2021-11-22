package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class App 
{
    public static void main( String[] args ) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );

        //Тут все понятно
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://crm.geekbrains.space/user/login");

        /*Неявные ожидания: (ожидания полной загрузки страницы — pageLoadTimeout();
                             ожидания появления элемента на странице — implicitlyWait();
                             ожидания выполнения асинхронного запроса — setScriptTimeout();
        */
        driver.manage().timeouts().pageLoadTimeout(10000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5000,
                TimeUnit.MILLISECONDS);

        //Ввод логина
        WebElement webLogin = driver.findElement(By.id("prependedInput"));
        webLogin.sendKeys("Applanatest1");

        //Ввод пароля
        WebElement webPass = driver.findElement(By.id("prependedInput2"));
        webPass.sendKeys("Student2020!");

        //Клик по кнопке войти
        WebElement webSubmitAuth = driver.findElement(By.id("_submit"));
        webSubmitAuth.click();

        //Клик на кнопку "Контрагенты"
        WebElement webProjectMenu1 = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Контрагенты')]"));
        webProjectMenu1.click();

        //Клик на кнопку "Контакты"
        WebElement webProjectMenu2 = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Контактные лица')]"));
        webProjectMenu2.click();

        //Клик на кнопку "Создать новый контакт"
        WebElement webNewContact = driver.findElement(By.xpath("//a[contains(@title,'Создать контактное лицо')]"));
        webNewContact.click();

        //Ввод фамилии
        WebElement webContactFamily = driver.findElement(By.xpath("//input[contains(@name,'crm_contact[lastName]')]"));
        webContactFamily.sendKeys("Баранов");

        //Ввод имени
        WebElement webContactName = driver.findElement(By.xpath("//input[contains(@name,'crm_contact[firstName]')]"));
        webContactName.sendKeys("Максим");

        //Клик на организация
        WebElement webOrganization = driver.findElement(By.xpath("//span[@class='select2-chosen']" +
                "[contains(.,'Укажите организацию')]"));
        webOrganization.click();

        //Выбор организации
        WebElement webOrganizationSelect = driver.findElement(By.xpath("//div[@class='select2-result-label']" +
                "[contains(.,'Alya')]"));
        webOrganizationSelect.click();

        //Thread.sleep(5000);

        //Клик на должность
        WebElement webPosition = driver.findElement(By.xpath("//input[contains(@name,'crm_contact[jobTitle]')]"));
        webPosition.sendKeys("QA Engineer");

        //Сохраняем и закрываем
        WebElement webSaveClose = driver.findElement(By.xpath("//button[@type='submit']" +
                "[contains(.,'Сохранить и закрыть')]"));
        webSaveClose.click();

        //Удаление созданной записи в веб интерфейсе отсутствует.

        //driver.quit();
    }
}
