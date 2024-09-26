import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lesson16 {

    @Test
    public void task1() {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.mts.by/");
        try {
            WebElement link = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
            link.click();
        } catch (Exception e) {
        }
        System.out.println("Тест 1.\nПроверка плейсхолдеров каждого варианта оплаты услуг.\n\n1. Домашний интернет:\n");

        WebElement pHolder = driver.findElement(By.xpath("//*[@id=\"internet-phone\"]"));
        String text = pHolder.findElement(By.xpath("//input[@placeholder='Номер абонента']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Номер абонента");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"internet-sum\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='Сумма']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Сумма");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"internet-email\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']")).getAttribute("placeholder");
        Assert.assertEquals(text, "E-mail для отправки чека");

        System.out.println(text + " - ✓\n\n2. Услуга связи:\n");

        pHolder = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='Номер телефона']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Номер телефона");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='Сумма']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Сумма");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']")).getAttribute("placeholder");
        Assert.assertEquals(text, "E-mail для отправки чека");

        System.out.println(text + " - ✓\n\n3. Рассрочка:\n");

        pHolder = driver.findElement(By.xpath("//*[@id=\"score-instalment\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='Номер счета на 44']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Номер счета на 44");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"instalment-sum\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='Сумма']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Сумма");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"instalment-email\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']")).getAttribute("placeholder");
        Assert.assertEquals(text, "E-mail для отправки чека");

        System.out.println(text + " - ✓\n\n4. Задолжность:\n");

        pHolder = driver.findElement(By.xpath("//*[@id=\"score-arrears\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='Номер счета на 2073']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Номер счета на 2073");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"arrears-sum\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='Сумма']")).getAttribute("placeholder");
        Assert.assertEquals(text, "Сумма");

        System.out.println(text + " - ✓");

        pHolder = driver.findElement(By.xpath("//*[@id=\"arrears-email\"]"));
        text = pHolder.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']")).getAttribute("placeholder");
        Assert.assertEquals(text, "E-mail для отправки чека");

        System.out.println(text + " - ✓\n\nТест пройден успешно.\n");

        driver.quit();
    }

    @Test
    public void task2() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.mts.by/");

        try {
            WebElement link = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
            link.click();
        } catch (Exception e) {
        }

        String pNumber = "297777777";
        String suma = "99.99";

        System.out.println("Тест 2.\n\nПосле заполнения варианта 'Услуги связи' и нажатия кнопки 'Продолжить', проверить корректность отображения суммы и тд.\n\nПроверка корректного отображения плейсхолдеров:\n");

        WebElement number = driver.findElement(By.id("connection-phone"));
        number.click();
        number.sendKeys(pNumber);

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.click();
        sum.sendKeys(suma);

        WebElement email = driver.findElement(By.id("connection-email"));
        email.click();
        email.sendKeys("test@gamil.com");

        WebElement commit = driver.findElement(By.className("button__default"));
        commit.click();

        Thread.sleep(10000);
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[8]/div/iframe")));

        WebElement pHolder = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
        String textM = pHolder.findElement(By.xpath("//label[text()='Номер карты']")).getText();
        Assert.assertEquals(textM, "Номер карты");

        System.out.println(textM + " - ✓");

        pHolder = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
        textM = pHolder.findElement(By.xpath("//label[text()='Срок действия']")).getText();
        Assert.assertEquals(textM, "Срок действия");

        System.out.println(textM + " - ✓");

        pHolder = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        textM = pHolder.findElement(By.xpath("//label[text()='CVC']")).getText();
        Assert.assertEquals(textM, "CVC");

        pHolder = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
        textM = pHolder.findElement(By.xpath("//label[text()='Имя держателя (как на карте)']")).getText();
        Assert.assertEquals(textM, "Имя держателя (как на карте)");

        System.out.println(textM + " - ✓\n\nПроверка корректного отображения заполненой информации (телефон/сумма):\n");

        WebElement phoneCheck = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        String phoneCorrect = phoneCheck.getText().substring(30);
        Assert.assertEquals(phoneCorrect, pNumber);

        System.out.println("Номер телефона отображается корректно - ✓");

        WebElement sumCheck = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]"));
        String sumCorrect = sumCheck.getText().substring(0, 5);
        Assert.assertEquals(sumCorrect, suma);

        System.out.println("Сумма отображается корректно - ✓");

        sumCheck = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
        sumCorrect = sumCheck.getText().substring(9, 14);
        Assert.assertEquals(sumCorrect, suma);

        System.out.println("Сумма на кнопке отображается корректно - ✓\n\nПроверка наличия иконок платежных систем:\n");

        WebElement logo = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]"));
        String logoText = logo.getAttribute("src").substring(76, 87);
        Assert.assertEquals(logoText, "visa-system");

        System.out.println("Иконка Visa пресутствует - ✓");

        logo = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]"));
        logoText = logo.getAttribute("src").substring(76, 93);
        Assert.assertEquals(logoText, "mastercard-system");

        System.out.println("Иконка Mastercard пресутствует - ✓");

        logo = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]"));
        logoText = logo.getAttribute("src").substring(76, 90);
        Assert.assertEquals(logoText, "belkart-system");

        System.out.println("Иконка Belkart пресутствует - ✓");

        logo = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]"));
        logoText = logo.getAttribute("src").substring(76,90);
        Assert.assertEquals(logoText, "maestro-system");

        System.out.println("Иконка Maestro пресутствует - ✓");

        logo = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]"));
        logoText = logo.getAttribute("src").substring(76,89);
        Assert.assertEquals(logoText, "mir-system-ru");

        System.out.println("Иконка Mir пресутствует - ✓\n\nТест пройден успешно.");

        driver.quit();
    }
}
