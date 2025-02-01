import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AddCarJenkinsAllureTest extends BaseTest {


    SelenideElement dateElement = $(".car_update-mileage");
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String expectedDate = today.format(formatter);

    @Test
    @Description("Додавання машини Audi TT, та перевірка заповнених даних")
    @Owner("Slava Lysjuk")
    @Link("https://lms.ithillel.ua/groups/66a3b3f284150597717a2ab7/homeworks/6787738aaf5b996f98f997af")
    @Severity(SeverityLevel.BLOCKER)
    public void testAddCarJenkins() {
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
