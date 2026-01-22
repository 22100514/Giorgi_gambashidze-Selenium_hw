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
import pages.DemoQAFormPage;

public class FormTests extends BaseTest {

    @Test
    @Epic("Homework 3")
    @Feature("Practice Form")
    @Story("Submit valid form")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Giorgi")
    @Description("Fill the practice form and verify submission modal content.")
    public void fillForm_and_verifySubmissionPopup() {
        String first = "Gio";
        String last = "Gambusha";
        String email = "gio@example.com";
        String gender = "Male";
        String mobile = "9998887766";
        String subject = "Computer Science";
        String hobby = "Sports";
        String address = "Shota Rustaveli Ave, Tbilisi";
        String state = "NCR";
        String city = "Delhi";

        DemoQAFormPage page = new DemoQAFormPage(driver, wait)
                .open()
                .setFirstName(first)
                .setLastName(last)
                .setEmail(email)
                .selectGender(gender)
                .setMobile(mobile)
                .addSubject(subject)
                .selectHobby(hobby)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .submit();

        String modalText = page.getSubmissionTableText();

        Assert.assertTrue(modalText.contains(first + " " + last), "Name not present in modal");
        Assert.assertTrue(modalText.contains(email), "Email not present in modal");
        Assert.assertTrue(modalText.contains(gender), "Gender not present in modal");
        Assert.assertTrue(modalText.contains(mobile), "Mobile not present in modal");
        Assert.assertTrue(modalText.contains(subject), "Subject not present in modal");
        Assert.assertTrue(modalText.contains(hobby), "Hobby not present in modal");
        Assert.assertTrue(modalText.contains(address), "Address not present in modal");
        Assert.assertTrue(modalText.contains(state) && modalText.contains(city), "State/City not present in modal");

        page.closeModal();
    }
}
