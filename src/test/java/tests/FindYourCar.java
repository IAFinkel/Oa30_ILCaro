package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FindYourCar extends TestBase {

    @Test
    public void findYourCarPositive() {
        app.getCar().typeCity("haifa");
        app.getCar().typeDate("11/29/2021-11/30/2021");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getCar().carsAreDisplayed());

    }

    @Test
    public void findYourCarPositive2() {
        app.getCar().typeCity("haifa");
        app.getCar().selectDate();
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getCar().carsAreDisplayed());

    }

    @Test
    public void findYourCarPositive3() {
        app.getCar().typeCity("haifa");
        app.getCar().selectDate2("29-30");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getCar().carsAreDisplayed());

    }

    @Test
    public void searchTests() {
        app.getCar().fillSearchForm("Haifa", "12/15/2021", "03/10/2022");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getCar().carsAreDisplayed());

    }

    @Test
    public void searchTestYear(){
        app.getCar().typeCity("Haifa");
        app.getCar().selectPeriodVersion2("12/12/2021","06/06/2022");
        app.getCar().pause(5000);
    }

    @AfterMethod
    public void post() {
        app.getCar().returnToMainPage();
    }

}
