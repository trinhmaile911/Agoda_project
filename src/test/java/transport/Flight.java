package transport;

import base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.FlightScreen;
import pageObject.HomeScreen;

import java.io.IOException;

public class Flight extends BasePage {
    public Flight() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() {
        driver = getDriver();
        driver.get(getUrl());
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        driver = null;
    }
    @Test
    public void selectRoundTripFlight() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(driver);
        FlightScreen flightScreen = new FlightScreen(driver);
        homeScreen.getTransportLink().click();
        homeScreen.getFlightOption().click();
        flightScreen.clickOnRoundTripButton();
        flightScreen.selectFlightOrigin("New York", "New York (NY)");
        flightScreen.selectFlightDestination("Paris", "Paris, France");
        flightScreen.selectDepartureOrReturnDate(5);
        flightScreen.selectDepartureOrReturnDate(6);
    }
}
