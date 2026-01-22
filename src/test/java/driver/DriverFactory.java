package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static void initDriver() {
        if (TL_DRIVER.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if ("true".equalsIgnoreCase(System.getProperty("headless", "false"))) {
                options.addArguments("--headless=new");
            }
            options.addArguments("--start-maximized");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            TL_DRIVER.set(new ChromeDriver(options));
        }
    }

    public static WebDriver getDriver() {
        return TL_DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver driver = TL_DRIVER.get();
        if (driver != null) {
            driver.quit();
            TL_DRIVER.remove();
        }
    }
}
