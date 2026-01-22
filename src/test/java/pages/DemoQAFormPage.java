package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQAFormPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DemoQAFormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Open demo QA practice form")
    public DemoQAFormPage open() {
        driver.get("https://demoqa.com/automation-practice-form");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        return this;
    }

    @Step("Set first name: {first}")
    public DemoQAFormPage setFirstName(String first) {
        driver.findElement(By.cssSelector("#firstName")).sendKeys(first);
        return this;
    }

    @Step("Set last name: {last}")
    public DemoQAFormPage setLastName(String last) {
        driver.findElement(By.cssSelector("#lastName")).sendKeys(last);
        return this;
    }

    @Step("Set email: {email}")
    public DemoQAFormPage setEmail(String email) {
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(email);
        return this;
    }

    @Step("Select gender: {visibleText}")
    public DemoQAFormPage selectGender(String visibleText) {
        WebElement label = driver.findElement(By.xpath("//label[normalize-space()='" + visibleText + "']"));
        removeAds();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label);
        return this;
    }

    @Step("Set mobile: {mobile}")
    public DemoQAFormPage setMobile(String mobile) {
        driver.findElement(By.cssSelector("#userNumber")).sendKeys(mobile);
        return this;
    }

    @Step("Add subject: {subject}")
    public DemoQAFormPage addSubject(String subject) {
        WebElement subj = driver.findElement(By.id("subjectsInput"));
        subj.sendKeys(subject);
        subj.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Select hobby: {visibleText}")
    public DemoQAFormPage selectHobby(String visibleText) {
        WebElement label = driver.findElement(By.xpath("//label[normalize-space()='" + visibleText + "']"));
        removeAds();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label);
        return this;
    }

    @Step("Set address: {address}")
    public DemoQAFormPage setAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
        return this;
    }

    @Step("Select state: {state}")
    public DemoQAFormPage selectState(String state) {
        WebElement stateInput = driver.findElement(By.cssSelector("div#state input[id^='react-select-'][id$='-input']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateInput);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Select city: {city}")
    public DemoQAFormPage selectCity(String city) {
        WebElement cityInput = driver.findElement(By.cssSelector("div#city input[id^='react-select-'][id$='-input']"));
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Submit form")
    public DemoQAFormPage submit() {
        WebElement submit = driver.findElement(By.id("submit"));
        removeAds();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        return this;
    }

    @Step("Get submission table text")
    public String getSubmissionTableText() {
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table-responsive")));
        return table.getText();
    }

    @Step("Close submission modal")
    public void closeModal() {
        WebElement close = driver.findElement(By.id("closeLargeModal"));
        removeAds();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", close);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
    }

    private void removeAds() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe[id^=\"google_ads_iframe\"]').forEach(e => e.remove());" +
                "document.querySelectorAll('div[id^=\"google_ads_iframe\"]').forEach(e => e.remove());");
    }
}
