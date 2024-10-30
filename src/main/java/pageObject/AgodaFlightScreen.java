package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By airlines = By.cssSelector("label[data-element-name='flight-filter-airline-item']");

    public WebElement getExpandCollapseAirlinesButton()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expandCollapseAirlinesButton));
        return driver.findElement(expandCollapseAirlinesButton);
    }
    public WebElement getSelectAllAirlinesToggle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectAllAirlinesToggle));
        return driver.findElement(selectAllAirlinesToggle);
    }
    public List<WebElement> getAirlines() {
        return driver.findElements(airlines);
    }

    public void expandCollapseAirlines() {
        getExpandCollapseAirlinesButton().click();
    }
    public void selectAllAirlines() {
        if(getSelectAllAirlinesToggle().getAttribute("data-airline-toggle-state").equals("false")) {
            getSelectAllAirlinesToggle().click();
        }
    }
    public void selectAirlines(String airlineName) {
        List<WebElement> airlines = getAirlines();
        for (WebElement airline : airlines) {
            if (airline.getAttribute("data-element-value").equals(airline)) {
                airline.click();
                System.out.println("Selected Airline : " + airline.getAttribute("data-element-value"));
            }
        }
    }

}
