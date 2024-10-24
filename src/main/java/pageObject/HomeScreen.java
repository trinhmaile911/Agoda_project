package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeScreen {
    public WebDriver driver;
    By transportLink = By.cssSelector("a[data-element-name='header-transportation-links']");
    By flightOption = By.cssSelector("[data-element-name='header-flights-links']");
    public HomeScreen(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getTransportLink() {
        return driver.findElement(transportLink);
    }
    public WebElement getFlightOption() {
        return driver.findElement(flightOption);
    }
}
