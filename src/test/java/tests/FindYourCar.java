package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindYourCar extends TestBase {

    @Test
    public void findYourCarPositive() {
        app.getCar().typeCity("haifa");
        app.getCar().typeDate("11/28/2021-11/30/2021");
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
        app.getCar().selectDate2("28-30");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getCar().carsAreDisplayed());

    }

}
