import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunBbcLocalNewsPage {
    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void shouldFindSearchResult() throws InterruptedException {
        BbcLocalNewsPage searchPage = new BbcLocalNewsPage(driver);
        searchPage.navigate();
        Thread.sleep(2000); // ...or a better wait - it's failing for me otherwise
        searchPage.searchFor("Guildford");
        searchPage.waitForResultsText("Guildford");
        assertEquals("Guildford",searchPage.getSearchResultsHeading());
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}