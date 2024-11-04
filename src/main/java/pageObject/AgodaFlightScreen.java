package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AgodaFlightScreen {
    public WebDriver driver;
    public WebDriverWait wait;
    public AgodaFlightScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    By expandCollapseAirlinesButton = By.cssSelector("button[role='button']");
    By selectAllAirlinesToggle = By.cssSelector("label[data-element-name='flight-filter-airline-toggle']");
    By airlineList = By.cssSelector("label[data-element-name='flight-filter-airline-item']");
    By stopList = By.cssSelector("label[data-element-name='flight-filter-stops-item']");

    public WebElement getExpandCollapseAirlinesButton()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expandCollapseAirlinesButton));
        return driver.findElement(expandCollapseAirlinesButton);
    }
    public WebElement getSelectAllAirlinesToggle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectAllAirlinesToggle));
        return driver.findElement(selectAllAirlinesToggle);
    }
    public List<WebElement> getAirlineList() {
        return driver.findElements(airlineList);
    }
    public List<WebElement> getStopList() {
        return driver.findElements(stopList);
    }

    public void expandCollapseAirlines() {
        getExpandCollapseAirlinesButton().click();
    }
    public void selectAllAirlines() {
        if(getSelectAllAirlinesToggle().getAttribute("data-airline-toggle-state").equals("false")) {
            getSelectAllAirlinesToggle().click();
        }
    }
    public void selectAirlines(String... airlineNames) {
        List<WebElement> airlines = getAirlineList();
        wait.until(ExpectedConditions.visibilityOfAllElements(airlines));
        for (String airlineName : airlineNames){
            for (WebElement airline : airlines) {
                if (airline.getAttribute("data-element-value").equals(airlineName)) {
                    airline.click();
                    break;
                }
            }
        }
    }
    public void selectStops(String... stopNames) {
        List<WebElement> stops = getStopList();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfAllElements(stops));
        js.executeScript("arguments[0].scrollIntoView(true);", getExpandCollapseAirlinesButton());
        for (String stopName : stopNames){
            for (WebElement stop : stops) {
                if (stop.getAttribute("data-element-value").equals(stopName)) {
                    stop.click();
                    break;
                }
            }
        }
    }

}
