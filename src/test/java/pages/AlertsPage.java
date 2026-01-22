package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Open alerts page")
    public AlertsPage open() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
        return this;
    }

    @Step("Open textbox tab")
    public AlertsPage openTextboxTab() {
        driver.findElement(By.cssSelector("a[href='#Textbox']")).click();
        return this;
    }

    @Step("Trigger prompt alert")
    public AlertsPage triggerPromptAlert() {
        driver.findElement(By.cssSelector("#Textbox button.btn.btn-info")).click();
        return this;
    }

    @Step("Fill prompt with text: {text} and accept")
    public AlertsPage fillPromptAndAccept(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
        return this;
    }

    @Step("Get prompt result text")
    public String getPromptResultText() {
        return driver.findElement(By.cssSelector("#Textbox #demo1")).getText().trim();
    }
}
