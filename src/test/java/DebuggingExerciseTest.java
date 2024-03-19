import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class DebuggingExerciseTest {
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
        driver.get("https://todomvc.com/examples/react/dist/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void itemCRUD() {
        driver.get("https://todomvc.com/examples/react/dist/");
        driver.manage().window().setSize(new Dimension(1255, 814));
        driver.findElement(By.id("todo-input")).click();
        driver.findElement(By.id("todo-input")).sendKeys("Shopping");
        driver.findElement(By.id("todo-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".toggle")).click();
        driver.findElement(By.cssSelector(".destroy")).click();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
