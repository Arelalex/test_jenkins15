package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.platform.commons.util.Preconditions.condition;

public class CheckResultComponent {


    public void checkLabel(String value) {
        $x("//*[contains(text(),'Thanks for submitting the form')]").shouldHave(text(value));
    }

    public void checkNotLabel(String value) {
        $x("//*[contains(text(),'Thanks for submitting the form')]").should(hidden);
    }

    public void checkData(String key, String value) {
        String tablesValueXpath = "//td[text()='%s']/../td[text()='%s']";
        $x(String.format(tablesValueXpath, key, value)).shouldBe(visible);
    }
}
