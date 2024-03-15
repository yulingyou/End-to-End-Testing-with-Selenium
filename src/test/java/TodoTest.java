import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TodoTest {
    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
    }

    // Your tests will go here!
    @Test
    void shouldLoadHomepage() {
        // Now we are on the TodoMVC homepage.
        // We'll write the rest of our code here!
        driver.get("https://todomvc.com");
        System.out.println(driver.getTitle());
        WebElement githubButton = driver.findElement(By.partialLinkText("View on GitHub"));
        System.out.println(githubButton.getText());
        WebElement javaScriptContent = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/paper-tabs/div/div/paper-tab[1]"));
        System.out.println(javaScriptContent.getText());

    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}