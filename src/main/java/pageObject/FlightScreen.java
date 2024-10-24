package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlightScreen {
    public static WebDriver driver;
    By oneWayButton = By.cssSelector("button[label='One-way']");
    By roundTripButton = By.cssSelector("button[label='Round-trip']");
    By flightOriginSearch = By.cssSelector("#flight-origin-search-input");
    By flightDestinationSearch = By.cssSelector("#flight-destination-search-input");
    By flightDeparture = By.cssSelector("#flight-departure");
    By flightOccupancy = By.cssSelector("#flight-occupancy");
    By addHotelCheckbox = By.cssSelector(".Box-sc-kv6pi1-0.fEqKQn  .Checkboxstyled__CheckboxInput-sc-vp5jkq-0.kOKrHS");
    By directOnlyCheckbox = By.cssSelector(".Box-sc-kv6pi1-0.gNtbSA  .Checkboxstyled__CheckboxSpan-sc-vp5jkq-2.Spanstyled__SpanStyled-sc-16tp9kb-0.bMXWRU.gwICfd.kite-js-Span");
    By searchButton = By.cssSelector(".Box-sc-kv6pi1-0.Buttonstyled__ButtonStyled-sc-5gjk6l-0.fDMIuA.iCZpGI");
    By suggestiveList = By.cssSelector("ul[role='listbox']");
    By flightOptions = By.cssSelector("ul[role='listbox'] > li[class='Suggestion Suggestion--flight Suggestion__categoryName']");
    By dateSelector = By.cssSelector(".DateSelector__PopupContent");
    static By pickerDays = By.cssSelector(".PriceSurgePicker-Day__label");
    public FlightScreen(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getOneWayButton() {
        return driver.findElement(oneWayButton);
    }
    public WebElement getRoundTripButton() {
        return driver.findElement(roundTripButton);
    }
    public WebElement getFlightOriginSearch() {
        return driver.findElement(flightOriginSearch);
    }
    public WebElement getFlightDestinationSearch() {
        return driver.findElement(flightDestinationSearch);
    }
    public WebElement getFlightDeparture() {
        return driver.findElement(flightDeparture);
    }
    public WebElement getFlightOccupancy() {
        return driver.findElement(flightOccupancy);
    }
    public WebElement getAddHotelCheckbox() {
        return driver.findElement(addHotelCheckbox);
    }
    public WebElement getDirectOnlyCheckbox() {
        return driver.findElement(directOnlyCheckbox);
    }
    public WebElement getSearchButton() {
        return driver.findElement(searchButton);
    }
    public List<WebElement> getFlightOptions() {
        return driver.findElements(flightOptions);
    }
    public WebElement getSuggestiveList() {
        return driver.findElement(suggestiveList);
    }
    public WebElement getDateSelector() {
        return driver.findElement(dateSelector);
    }
    public static List<WebElement> getPickerDays() {
        return driver.findElements(pickerDays);
    }
    public void clickOnOneWayButton() {
        if (getOneWayButton().isSelected() == false) {
            getOneWayButton().click();
        }
    }
    public void clickOnRoundTripButton() {
        if (getRoundTripButton().isSelected() == false) {
            getRoundTripButton().click();
        }
    }
    public void selectFlightOrigin(String searchKeyword, String origin) {
        boolean found = false;
        getFlightOriginSearch().sendKeys(searchKeyword);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust the timeout as needed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[role='listbox']")));
        while (!found) {
            List<WebElement> flighOriginOptions = getFlightOptions(); // Lấy lại danh sách mỗi lần
            for (WebElement flightOption : flighOriginOptions) {
                if (flightOption.isDisplayed()) { // Kiểm tra xem phần tử có hiển thị không
                    if (flightOption.getText().contains(origin)) {
                        flightOption.click();
                        found = true; // Đặt flag để thoát khỏi vòng lặp
                        break;
                    }
                }
            }
        }
    }
    public void selectFlightDestination(String searchKeyword, String destination) {
        boolean found = false;
        getFlightDestinationSearch().sendKeys(searchKeyword);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust the timeout as needed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[role='listbox']")));
        while (!found) {
            List<WebElement> flighOriginOptions = getFlightOptions(); // Lấy lại danh sách mỗi lần
            for (WebElement flightOption : flighOriginOptions) {
                if (flightOption.isDisplayed()) { // Kiểm tra xem phần tử có hiển thị không
                    if (flightOption.getText().contains(destination)) {
                        flightOption.click();
                        found = true; // Đặt flag để thoát khỏi vòng lặp
                        break;
                    }
                }
            }
        }
    }
    public void selectDepartureOrReturnDate(int daysToAdd) {
        if (getDateSelector().isDisplayed() == false){
            getDateSelector().click();
        }
        LocalDate selectedDate = LocalDate.now().plusDays(daysToAdd);
        selectDate(driver, selectedDate);

    }
    private static void selectDate(WebDriver driver, LocalDate selectdDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = selectdDate.format(formatter); // Find the date element and click it
        boolean found = false;
        while (!found){
            List <WebElement> dates = getPickerDays();
            for (WebElement date : dates){
                if (date.isDisplayed()){
                    if (date.getAttribute("data-selenium-date").equals(formattedDate)){
                        date.click();
                        found = true;
                        break;
                    }
                }
            }
        }
    }
}
