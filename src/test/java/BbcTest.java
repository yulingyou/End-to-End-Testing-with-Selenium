import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BbcTest {
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
        driver.get("https://www.bbc.co.uk/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void bBCtestrecording() {
        driver.get("https://www.bbc.co.uk/");
        driver.manage().window().setSize(new Dimension(948, 782));
        driver.findElement(By.cssSelector(".ssrcss-17egjfr-ConsentButton")).click();
        driver.findElement(By.linkText("GB News shows hosted by MPs broke Ofcom rules")).click();
        driver.findElement(By.linkText("The WhatsApp group that saved trafficked women")).click();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
