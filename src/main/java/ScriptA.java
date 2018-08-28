import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ScriptA {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getInitFirefoxDriver();
        driver.manage().window().maximize();

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("webinar.test@gmail.com");
        WebElement passwd = driver.findElement(By.id("passwd"));
        passwd.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitLogin = driver.findElement(By.name("submitLogin"));
        submitLogin.click();

        WebElement avatarImg = driver.findElement(By.xpath("//span[@class='employee_avatar_small']//img[@class='imgm img-thumbnail']"));

            Thread.sleep(1000);

        avatarImg.click();


        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

        driver.quit();

    }
    public static WebDriver getInitFirefoxDriver(){
    System.setProperty("webdriver.gecko.driver","/Users/hs/seleniumTest/src/main/resources/geckodriver");
        return new FirefoxDriver();
    }
}
