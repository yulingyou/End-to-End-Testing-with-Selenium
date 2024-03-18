import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GovUkCarTax {
    private static ChromeDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Your tests will go here!
    @Test
    void shouldPrintPageTitle() {
        driver.get("https://www.gov.uk/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void loadCarTaxPage() throws Exception {
        driver.get("https://www.gov.uk/");
        Thread.sleep(2000);
//        driver.findElement(By.id("search-main-4e3eb7e5")).click();
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/form/div/div/input"));
        searchBox.click();
        searchBox.sendKeys("Car tax");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/form/div/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Tax your vehicle")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/button[1]")).click();
        takeScreenshot(driver, "tax_noBanner.png");

//        driver.findElement(By.cssSelector(".gem-c-search__submit")).click();
//        driver.findElement(By.id("search-main-4e3eb7e5")).sendKeys("car tax");
//
//        driver.findElement(By.cssSelector(".ssrcss-17egjfr-ConsentButton")).click();
//        driver.findElement(By.linkText("GB News shows hosted by MPs broke Ofcom rules")).click();
//        driver.findElement(By.linkText("The WhatsApp group that saved trafficked women")).click();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    public static void takeScreenshot(WebDriver webdriver, String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}