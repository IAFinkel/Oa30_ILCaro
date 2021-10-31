package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase {
    //is logged?--->precondition
    // open form
    //fill form + model Car
    //attach photo
    //submit form

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLoginPresent()) {
            app.getHelperUser().login(new User().withEmail("goodwin49@mail.ru").withPassword("Car12345"));
        }
    }

    @Test
    public void addNewCarTestPositive() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 36000);
        Car car = Car.builder()
                .adress("Tel Aviv")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("2")
                .seats("2")
                .clasS("C")
                .fuelConsumption("10")
                .carRegNumber("100-55-" + i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type")
                .about("Nice car")

                .build();

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto();
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getCar().carAddedSuccessfull());


    }
}
