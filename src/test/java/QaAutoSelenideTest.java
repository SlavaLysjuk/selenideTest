import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class QaAutoSelenideTest extends BaseTest {

    SelenideElement dateElement = $(".car_update-mileage");
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String expectedDate = today.format(formatter);

    @Ignore
    @Test
    public void testAddCar() {
        $x("//button[text()='Guest log in']").shouldBe(visible).click();
        webdriver().shouldHave(url("https://guest:welcome2qauto@qauto.forstudy.space/panel/garage"));
        $x("//button[text()='Add car']").shouldBe(visible).click();
        $x("//h4[text()='Add a car']").shouldBe(visible);
        $("#addCarMileage").shouldBe(visible, Duration.ofSeconds(3)).sendKeys("20");
        $x("//button[text()='Add']").shouldBe(visible).click();
        $(".car_name").shouldBe(Condition.visible, Duration.ofSeconds(3)).shouldHave(Condition.text("Audi TT"));
        dateElement.shouldHave(text(expectedDate));
        $("input[name='miles'].update-mileage-form_input").shouldHave(Condition.value("20"));
        $x("//div[@class='car_logo car-logo']").shouldBe(visible);
        $x("//img[@alt='TT']").shouldBe(visible).shouldHave(attributeMatching("src", ".*audi\\.png$"));


    }
}
