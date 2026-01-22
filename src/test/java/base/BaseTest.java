package base;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
        } catch (Exception ignored) {}
        DriverFactory.quitDriver();
    }
}
