import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoMVCtest {
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
        driver.get("https://todomvc.com");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/iron-pages/div[1]/ul/li[1]/a/span[1]")).click();
        assertEquals("TodoMVC: React", driver.getTitle());
        driver.findElement((By.id("todo-input"))).click();
        driver.findElement((By.id("todo-input"))).sendKeys("Buy some milk");
        driver.findElement((By.id("todo-input"))).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement buyMilk = driver.findElement(By.xpath("/html/body/section/main/ul/li[1]/div/label"));
        assertTrue(buyMilk.isDisplayed());
        WebElement countItem = driver.findElement(By.className("todo-count"));
        assertEquals("1 item left!",countItem.getText());
        driver.findElement(By.className("toggle")).click();
        WebElement countItemafterCompleted = driver.findElement(By.className("todo-count"));
        assertEquals("0 items left!",countItemafterCompleted.getText());
        Thread.sleep(2000);

    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
