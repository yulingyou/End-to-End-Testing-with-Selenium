import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class BbcLocalNewsTest {
    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Your tests will go here!
    @Test
    void shouldLoadSearchResult() throws Exception {
        // Now we are on the TodoMVC homepage.
        // We'll write the rest of our code here!
        driver.get("https://www.bbc.co.uk/news/localnews");
        System.out.println(driver.getTitle());
        WebElement enterTownOrCity = driver.findElement(By.id("ls-c-search__input-label"));
        Thread.sleep(2000);
        enterTownOrCity.click();
        enterTownOrCity.sendKeys("Guildford");
        driver.findElement(By.cssSelector(".ls-c-search__submit")).click();
        Thread.sleep(2000);
        takeScreenshot(driver, "guildford.png");
        WebElement guildford = driver.findElement(By.id("main-heading"));
        System.out.println(guildford.getText());
        driver.findElement(By.linkText("More Local News")).click();
        Thread.sleep(2000);
        takeScreenshot(driver, "localNews.png");
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
