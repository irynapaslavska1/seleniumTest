import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Lecture_3 {
    public static void main(String[] args) {

        WebDriver driver = getInitFirefoxDriver();
        driver.manage().window().maximize();

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("webinar.test@gmail.com");
        WebElement passwd = driver.findElement(By.id("passwd"));
        passwd.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitLogin = driver.findElement(By.name("submitLogin"));
        submitLogin.click();

        WebElement catalogTab = driver.findElement(By.id("subtab-AdminCatalog"));
        Actions builder = new Actions(driver);
        builder.moveToElement(catalogTab).perform();
        WebElement categories = driver.findElement(By.xpath("//a[contains(text(),'категории')]"));
        categories.click();
    }

    public static WebDriver getInitFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver","/Users/hs/seleniumTest/src/main/resources/geckodriver");
        return new FirefoxDriver();
    }
}
