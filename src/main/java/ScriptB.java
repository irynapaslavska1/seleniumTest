import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScriptB {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getInitFirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("webinar.test@gmail.com");
        WebElement passwd = driver.findElement(By.id("passwd"));
        passwd.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitLogin = driver.findElement(By.name("submitLogin"));
        submitLogin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-AdminDashboard")));
        WebElement dashboardTab = driver.findElement(By.id("tab-AdminDashboard"));
        dashboardTab.click();

        WebElement activeTab = driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]"));
        System.out.println(activeTab.getText());
        driver.navigate().to(driver.getCurrentUrl());

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-AdminDashboard")));    doesn't work - the element is no longer attached to the DOM -  need help!!!
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText(), "Dashboard");

        WebElement ordersTab = driver.findElement(By.id("subtab-AdminParentOrders"));
        ordersTab.click();
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText());
        driver.navigate().to(driver.getCurrentUrl());
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText(), "Заказы");

        WebElement catalogTab = driver.findElement(By.id("subtab-AdminCatalog"));
        catalogTab.click();
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,\"link-levelone -active\")]")).getText());
        driver.navigate().to(driver.getCurrentUrl());
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,\"link-levelone -active\")]")).getText(), "Каталог");

        WebElement customersTab = driver.findElement(By.xpath("//a/span[contains(text(),'Клиенты')]"));
        customersTab.click();
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText());
        driver.navigate().to(driver.getCurrentUrl());
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText(), "Клиенты");

        WebElement supportTab = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
        supportTab.click();
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText());
        driver.navigate().to(driver.getCurrentUrl());
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText(), "Служба поддержки");

        WebElement statisticTab = driver.findElement(By.id("subtab-AdminStats"));
        statisticTab.click();
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText());
        driver.navigate().to(driver.getCurrentUrl());
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,\"maintab active\")]")).getText(), "Статистика");
        driver.quit();

    }
    public static WebDriver getInitFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver","/Users/hs/seleniumTest/src/main/resources/geckodriver");
        return new FirefoxDriver();
    }
}
