import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lesson15 {

    @Test
    public void task1() {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.mts.by/");
        WebElement text = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElements(text));

        Assert.assertEquals(text.getText(), "Онлайн пополнение\n" + "без комиссии");

        System.out.println("Тест 1, результаты.\n\nНазвание указанного блока соответствует ожидаемому:\n" + text.getText());

        driver.quit();
    }

    @Test
    public void task2() {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.mts.by/");

        WebElement logos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]"));
        String altText = logos.findElement(By.tagName("img")).getAttribute("alt");
        Assert.assertEquals(altText, "Visa");

        System.out.println("\nТест 2, результаты.\n\n" + altText);

        logos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]"));
        altText = logos.findElement(By.tagName("img")).getAttribute("alt");
        Assert.assertEquals(altText, "Verified By Visa");

        System.out.println(altText);

        logos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]"));
        altText = logos.findElement(By.tagName("img")).getAttribute("alt");
        Assert.assertEquals(altText, "MasterCard");

        System.out.println(altText);

        logos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]"));
        altText = logos.findElement(By.tagName("img")).getAttribute("alt");
        Assert.assertEquals(altText, "MasterCard Secure Code");

        System.out.println(altText);

        logos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]"));
        altText = logos.findElement(By.tagName("img")).getAttribute("alt");
        Assert.assertEquals(altText, "Белкарт");

        System.out.println(altText);

        driver.quit();
    }

    @Test
    public void task3() {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.mts.by/");

        try {
            WebElement link = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
            link.click();
        } catch (Exception e) {
        }
        WebElement link = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/a"));
        link.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("\nТест 3, результаты.\n\nссылка <Подробнее о сервисе> работает исправно.");

        driver.quit();
    }

    @Test
    public void task4() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.mts.by/");

        try {
            WebElement link = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
            link.click();
        } catch (Exception e) {
        }

        WebElement number = driver.findElement(By.id("connection-phone"));
        number.click();
        number.sendKeys("297777777");

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.click();
        sum.sendKeys("99");

        WebElement email = driver.findElement(By.id("connection-email"));
        email.click();
        email.sendKeys("test@gamil.com");

        WebElement commit = driver.findElement(By.className("button__default"));
        commit.click();
        Thread.sleep(5000);

        System.out.println("\nТест 4, резултаты.\n\nВсе поля заполнены корректно\nКнопка <Продолжить> работает исправно.");

        driver.quit();
    }
}
