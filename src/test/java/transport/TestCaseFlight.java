package transport;

import base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.AgodaFlightScreen;
import pageObject.SearchFlightScreen;
import pageObject.HomeScreen;

import java.io.IOException;

public class TestCaseFlight extends BasePage {
    public TestCaseFlight() throws IOException {
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
        SearchFlightScreen searchFlightScreen = new SearchFlightScreen(driver);
        AgodaFlightScreen agodaFlightScreen = new AgodaFlightScreen(driver);
        homeScreen.getTransportLink().click();
        homeScreen.getFlightOption().click();
        searchFlightScreen.clickOnRoundTripButton();
        searchFlightScreen.selectFlightOrigin("New York", "New York (NY)");
        searchFlightScreen.selectFlightDestination("Paris", "Paris, France");
        searchFlightScreen.selectDepartureOrReturnDate(5);
        searchFlightScreen.selectDepartureOrReturnDate(6);
        searchFlightScreen.selectOccupancy(1, 1, 1);
        searchFlightScreen.clickSearchFlightButton();
        agodaFlightScreen.expandCollapseAirlines();

    }
}
