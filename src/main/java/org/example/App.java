package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class App 
{
    public static void main( String[] args ) throws InterruptedException {
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

        //Клик на кнопку "Проекты"
        WebElement webProjectMenu1 = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span"));
        webProjectMenu1.click();

        //Клик на кнопку "Мои проекты"
        WebElement webProjectMenu2 = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/ul/li[4]/a/span"));
        webProjectMenu2.click();

        //Клик на кнопку "Новый проект"
        WebElement webNewProject = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a"));
        webNewProject.click();

        //Ввод наименования проекта
        WebElement webProjectName = driver.findElement(By.name("crm_project[name]"));
        webProjectName.sendKeys("Тестовое наименование");

        Thread.sleep(2000);

        //Клик на кнопку "организацию", далее по умолчанию "кнопка" не указываю
        WebElement webOrganization = driver.findElement(By.xpath("//span[@class='select2-chosen']" +
                "[contains(.,'Укажите организацию')]"));
        webOrganization.click();

        //С явным ожиданием надо еще поработать, пока так с задержкой, без нее иногда не успевает появиться список
        //Thread.sleep(5000);

        //Выбор организации
        WebElement webRecordOrg = driver.findElement(By.xpath("//div[@class='select2-result-label']" +
                "[contains(.,'Alya')]"));
        webRecordOrg.click();

        //Клик на подразделение
        WebElement webSubdivision = driver.findElement(By.xpath("//select[contains(@name,'crm_project[businessUnit]')]"));
        webSubdivision.click();

        //Выбор подразделения
        WebElement webSubSelect = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]" +
                "/div/div[1]/div[2]/fieldset/div[2]/div[5]/div[2]/div/select/option[2]"));
        webSubSelect.click();

        //Клик на куратора проекта
        WebElement webCurator = driver.findElement(By.xpath("//select[contains(@name,'crm_project[curator]')]"));
        webCurator.click();

        //Выбор куратора пректа
        WebElement webCuratorSelect = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/" +
                "div[3]/div/div[1]/div[2]/fieldset/div[2]/div[6]/div[2]/div/select/option[10]"));
        webCuratorSelect.click();

        //Клик на руководителя проекта
        WebElement webLeader = driver.findElement(By.xpath("//select[contains(@name,'crm_project[rp]')]"));
        webLeader.click();

        //Выбор руководителя проекта
        WebElement webLeaderSelect = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]" +
                "/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[7]/div[2]/div/select/option[11]"));
        webLeaderSelect.click();

        //Клик на менеджер
        WebElement webMeneger = driver.findElement(By.xpath("//select[@class='crm-manager-select']"));
        webMeneger.click();

        //Выбор менеджера
        WebElement webMenegerSelect = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]" +
                "/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[9]/div[2]/div/select/option[3]"));
        webMenegerSelect.click();

        //Сохраняем и закрываем
        WebElement webSaveClose = driver.findElement(By.xpath("//button[@type='submit']" +
                "[contains(.,'Сохранить и закрыть')]"));
        webSaveClose.click();

        Thread.sleep(3000);

        //Блок удаления созданной записи
        WebElement webProjectSearchClick = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]" +
                "/div[2]/div[1]/div/div/span/div[1]/div[1]"));
        webProjectSearchClick.click();

        WebElement webProjectSearch = driver.findElement(By.xpath("//input[contains(@name,'value')]"));
        webProjectSearch.sendKeys("Тестовое наименование");

        WebElement webProjectSearchSubmit = driver.findElement(By.xpath("//button[@class='btn btn-primary " +
                "filter-update'][contains(.,'Обновить')]"));
        webProjectSearchSubmit.click();

        Thread.sleep(5000);

        WebElement webProjectSee = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div[2]" +
                "/div[2]/div[2]/div/table/tbody/tr/td[17]/div/ul/li[1]/a/i"));
        webProjectSee.click();

        Thread.sleep(5000);

        WebElement webProjectDelete = driver.findElement(By.xpath("//i[@class='icon-trash hide-text'][contains(.,'Удалить')]"));
        webProjectDelete.click();

        WebElement webProjectDeleteOk = driver.findElement(By.xpath("//a[contains(@class,'btn ok btn-primary')]"));
        webProjectDeleteOk.click();



        //driver.quit();
    }
}
