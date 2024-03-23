import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BbcLocalNewsPage {
    protected WebDriver driver;
    private By searchBoxBy = By.id("ls-c-search__input-label");
    private By submitInputBy = By.cssSelector(".ls-c-search__submit");
    private By searchResultsHeadingBy = By.id("main-heading");

    public BbcLocalNewsPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get("https://www.bbc.co.uk/news/localnews");
    }

    public void searchFor(String searchTerm){
        WebElement searchBox = driver.findElement((searchBoxBy));
        searchBox.click();
        searchBox.sendKeys(searchTerm);
        driver.findElement(submitInputBy).click();

    }

    public String getSearchResultsHeading(){
        return driver.findElement(searchResultsHeadingBy).getText();
    }

    public void waitForResultsText(String resultsText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(searchResultsHeadingBy,resultsText));
    }

}