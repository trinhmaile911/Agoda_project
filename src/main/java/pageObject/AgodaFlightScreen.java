package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AgodaFlightScreen {
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    public AgodaFlightScreen(WebDriver driver) {
        this.driver = driver;
    }

    By expandCollapseAirlinesButton = By.cssSelector("button[role='button']");

    public WebElement getExpandCollapseAirlinesButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expandCollapseAirlinesButton));
        return driver.findElement(expandCollapseAirlinesButton);
    }

    public void expandCollapseAirlines() {
        wait.until(ExpectedConditions.visibilityOf(getExpandCollapseAirlinesButton()));
        getExpandCollapseAirlinesButton().click();
    }
}
