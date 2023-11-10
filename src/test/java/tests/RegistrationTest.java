package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@Tag("demoqa_m")
public class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @Feature("Форма регистрации")
    @Story("Добавление информации о студенте")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Successful fill form registration")
    void successfulFillFormTest() {
        step("Открыть форму", () -> {
            registrationPage.openPage()
                    .deleteBanners();
        });
        step("Заполнить форму", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.secondName)
                    .setUserEmail(testData.email)
                    .setGender(testData.gender)
                    .setUserNumber(testData.mobile)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .setSubjects(testData.symbol1, testData.subject1)
                    .setSubjects(testData.symbol2, testData.subject2)
                    .setHobbies(testData.hobbies1)
                    .setHobbies(testData.hobbies2)
                    .uploadPicture(testData.picture)
                    .setCurrentAddress(testData.address)
                    .setStateSelect(testData.state)
                    .setCitySelect(testData.city)
                    .submit();
        });
        step("Проверить результат", () -> {
            registrationPage.checkTitle()
                    .checkResult("Student Name", testData.firstName + " " + testData.secondName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.mobile)
                    .checkResult("Date of Birth", registrationPage.addZeroWithDateWithOneChar(testData.day) + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", testData.subject1 + ", " + testData.subject2)
                    .checkResult("Hobbies", testData.hobbies1 + ", " + testData.hobbies2)
                    .checkResult("Picture", testData.picture)
                    .checkResult("Address", testData.address)
                    .checkResult("Address", testData.address)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });
    }
}
