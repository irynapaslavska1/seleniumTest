import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'категории')]")));
        categories.click();

        WebElement addCategory = driver.findElement(By.id("page-header-desc-category-new_category"));
        addCategory.click();

        WebElement categoryName = driver.findElement(By.id("name_1"));
        categoryName.sendKeys("Iryna_category");

        WebElement submitNewCatBtn = driver.findElement(By.id("category_form_submit_btn"));
        submitNewCatBtn.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(successMessage.isDisplayed());

        WebElement categoryNameFilter = driver.findElement(By.xpath("//input[@name='categoryFilter_name']"));
        categoryNameFilter.sendKeys("Iryna_category");

        WebElement submitCatFilterBtn = driver.findElement(By.id("submitFilterButtoncategory"));
        submitCatFilterBtn.click();

        List<WebElement> categoriesFilteresult = driver.findElements(By.xpath("//td[contains(text(),'Iryna_category')]"));
        int numElements = categoriesFilteresult.size();
        Assert.assertTrue("Created new category is displayed", categoriesFilteresult.get(numElements - 1).isDisplayed());

        driver.quit();
    }

    public static WebDriver getInitFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", Lecture_3.class.getResource("geckodriver").getPath());
        return new FirefoxDriver();
    }
}
