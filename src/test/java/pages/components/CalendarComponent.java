package pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    String choiceOfDay = "//*[contains(@aria-label,'%s')][contains(@aria-label,'%s')][text()='%s']";

    public void setDate(String day, String month, String year) {
        $x("//*[@id='dateOfBirthInput']").click();
        $x("//option[text()='" + month + "']").click();
        $x("//option[@value='" + year + "']").click();
        $x(String.format(choiceOfDay, year, month, day)).click();
    }
}
