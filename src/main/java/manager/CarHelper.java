package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarHelper extends HelperBase {
    public CarHelper(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        if (isCarCreationFormPresent()) {
            typeLocation(car.getAdress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());

            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());

            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber());
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceIncluded());
            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"), car.getAbout());


        }
    }

    public void select(By locator, String option) {
        //new Select(wd.findElement(locator)).selectByIndex(2);
        new Select(wd.findElement(locator)).selectByValue(option);
//        new Select(wd.findElement(locator)).selectByVisibleText("");

    }

    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public boolean isCarCreationFormPresent() {
        Boolean isForm = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement
                        (wd.findElement(By.cssSelector("h2")),
                                "Write some details about your car to rent it out"));
        return isForm;
    }

    public void attachedPhoto() {
        wd.findElement(By.id("photos")).sendKeys("C:\\Users\\gorbu\\Documents\\GitHub\\Oa30_ILCaro\\auto.jpeg");

    }

    public boolean carAddedSuccessfull() {
        return isElementPresent(By.xpath("//div//h2[contains(.,'successful')]"));
    }

    public void ClickAddAnotherCar() {
        click(By.xpath("//div//button[text()='Add another car']"));
    }

    public void logOut() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void typeCity(String address) {
        pause(5000);
        type(By.xpath("//input[@id='city']"), address);
        click(By.cssSelector("div.pac-item"));
        pause(5000);
    }

    public void typeDate(String date) {
        if (date != null && !date.isEmpty()) {
            WebElement element = wd.findElement(By.xpath("(//input[@id='dates'])[1]"));
            element.sendKeys(date);

        }

    }

    public boolean carsAreDisplayed() {
        return isElementPresent(By.cssSelector(".car-img-container.ng-star-inserted"));
    }

    public void selectDate() {
        WebElement element = wd.findElement(By.xpath("(//input[@id='dates'])[1]"));
        element.click();
        click(By.xpath("//div[text()= 10 ]"));
        click(By.xpath("//div[text()= 15 ]"));

    }

    public void selectDate2(String date) {//"28-30"

        WebElement element = wd.findElement(By.xpath("(//input[@id='dates'])[1]"));
        element.click();

        String[] str = date.split("-");
        WebElement date1 = wd.findElement(By.xpath("//div[text()= " + str[0] + " ]"));

        if (date1.isEnabled()) {
            date1.click();
        }

        WebElement date2 = wd.findElement(By.xpath("//div[text()= " + str[1] + " ]"));
        if (date2.isEnabled()) {
            date2.click();
        }

    }


    public void fillSearchForm(String city, String from, String to) {
        typeCity(city);
        selectPeriod(from, to);

    }

    private void selectPeriod(String from, String to) {
        String[] dataFrom = from.split("/");
        String[] dataTo = to.split("/");
        click((By.xpath("(//input[@id='dates'])[1]")));


        int diffStart = 0;
        if (LocalDate.now().getMonthValue() != Integer.parseInt(dataFrom[0])) {
            diffStart = Integer.parseInt(dataFrom[0]) - LocalDate.now().getMonthValue();
            if (diffStart < 0) {
                diffStart = diffStart + 12;
            }
            //разница между текущей датой и датой которую нужно выбрать
        }

        int diffEnd = 0;
        if (Integer.parseInt(dataFrom[0]) != Integer.parseInt(dataTo[0])) {
            diffEnd = Integer.parseInt(dataTo[0]) - Integer.parseInt(dataFrom[0]);
            if (diffEnd < 0) {
                diffEnd = diffEnd + 12;
            }

        }

        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));

        }
        String locator3 = String.format("//div[.=' %s ']", dataFrom[1]);
        click(By.xpath(locator3));

        for (int i = 0; i < diffEnd; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }

//        String locator = "//div[.=' 25 ']";
//        String locator2 ="//div[.=' "+dataFrom[1]+" '";
//        String locator3 = String.format("//div[.=' %s ']",dataFrom[1]);
        String locator4 = String.format("//div[.=' %s ']", dataTo[1]);
        //click(By.xpath(locator3));
        click(By.xpath(locator4));

    }

    public void selectPeriodVersion2(String fromD, String toD){
        LocalDate from = LocalDate.parse(fromD, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(toD,DateTimeFormatter.ofPattern("MM/dd/yyyy"));//вычитывет из стринг дату в соотв формате
        LocalDate now = LocalDate.now();
        click((By.xpath("(//input[@id='dates'])[1]")));

        selectData(from,now);

//        int mounthDiff = from.getYear()-now.getYear()==0? from.getMonthValue()-now.getMonthValue()
//                : 12-now.getMonthValue()+from.getMonthValue();
//
//        for (int i = 0; i < mounthDiff; i++) {
//           click(By.xpath("//button[@aria-label='Next month']"));
//
//        }
        click(By.xpath(String.format("//div[.=' %s ']",from.getDayOfMonth())));

//        mounthDiff=to.getYear()-from.getYear()==0?to.getMonthValue()-from.getMonthValue() :
//          12-from.getMonthValue()+to.getMonthValue();
//        for (int i = 0; i < mounthDiff; i++) {
//            click(By.xpath("//button[@aria-label='Next month']"));
//
//        }
        selectData(to,from);
        click(By.xpath(String.format("//div[.=' %s ']",to.getDayOfMonth())));
    }

    public void selectData(LocalDate first,LocalDate second){
        int mounthDiff = first.getYear()-second.getYear()==0? first.getMonthValue()-second.getMonthValue()
                : 12-second.getMonthValue()+first.getMonthValue();

        for (int i = 0; i < mounthDiff; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));

        }
    }

    public void returnToMainPage() {
        click(By.xpath("//div[@class='header']//img[@alt='logo']"));

    }
}
