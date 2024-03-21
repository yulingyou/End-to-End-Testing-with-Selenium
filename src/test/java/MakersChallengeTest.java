import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MakersChallengeTest {
    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Your tests will go here!
    @Test
    void shouldLoadHomepage() throws InterruptedException {
        // Now we are on the TodoMVC homepage.
        // We'll write the rest of our code here!
        driver.get(" https://makers.tech");
        Thread.sleep(2000);
        assertTrue(driver.getTitle().contains("Building The Future"));
        driver.findElement(By.linkText("Accept All")).click();
        WebElement pageLinkCodeOfConduct = driver.findElement(By.linkText("Code of Conduct"));
        Thread.sleep(2000);
        assertTrue(pageLinkCodeOfConduct.getText().contains("Code of Conduct"));
        pageLinkCodeOfConduct.click();
        assertEquals("https://makers.tech/code-of-conduct",driver.getCurrentUrl());
        assertEquals("Code of conduct",driver.getTitle());
        driver.findElement(By.cssSelector("img[src='https://makers.tech/hubfs/Maker_Sep_2023/images/Group%202591.svg']")).click();
        Thread.sleep(2000);
        WebElement faqsPage = driver.findElement(By.linkText("FAQs"));
        faqsPage.click();
        assertEquals("https://faq.makers.tech/en/knowledge", driver.getCurrentUrl());
        WebElement searchBox = driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div[2]/div/form/input"));
        Thread.sleep(2000);
        searchBox.click();
        searchBox.sendKeys("badger");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);
        WebElement resultPage = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[2]/div/h1"));
        assertEquals("No results for \"badger\"", resultPage.getText());
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}