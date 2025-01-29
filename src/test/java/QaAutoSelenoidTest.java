import com.codeborne.selenide.Condition;
import hillel.qa.BrowserFactory;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class QaAutoSelenoidTest extends BaseTest{

    @Test(dataProvider = "browsers", dataProviderClass = BrowserFactory.class)
    public void testCanStartOnSelenoid(String browser) {
        $x("//button[text()='Sign In']").shouldBe(visible).click();
        $("#signinEmail").shouldBe(visible).sendKeys("test@hillel.ua");
        $("#signinPassword").shouldBe(visible).sendKeys("1111");
        $x("//button[text()='Login']").shouldBe(visible).click();
        $x("//p[@class='alert alert-danger']").shouldBe(Condition.visible, Duration.ofSeconds(3))
                .shouldHave(Condition.text("Wrong email or password"));
    }
}
