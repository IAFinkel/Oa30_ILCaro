package tests;

import manager.ApplManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplManager app = new ApplManager();

    @BeforeSuite
    public void setUp(){
    app.init();
    }

    @AfterSuite
    public void tearDown(){
    app.stop();
    }
}
