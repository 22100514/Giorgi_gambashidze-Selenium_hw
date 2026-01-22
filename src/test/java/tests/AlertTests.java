package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertTests extends BaseTest {

    @Test
    @Epic("Homework 3")
    @Feature("Alerts")
    @Story("Prompt alert")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Giorgi")
    @Description("Open alerts page, trigger prompt, enter name and verify result text.")
    public void promptAlert_accept_and_verifyResult() {
        String fullName = "Gio Gambusha";

        AlertsPage page = new AlertsPage(driver, wait)
                .open()
                .openTextboxTab()
                .triggerPromptAlert()
                .fillPromptAndAccept(fullName);

        String result = page.getPromptResultText();

        Assert.assertTrue(result.contains(fullName),
                "Expected name to be present in result. Actual: " + result);
    }
}
