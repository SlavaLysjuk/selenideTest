import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class QaAutoSelenoidTest extends BaseTest {


    @BeforeMethod
    @Override
    public void setUp(Object[] params) {
        super.setUp(params);
    }

    @Test(dataProvider = "browsers")
    public void testCanStartOnSelenoid(String browser) {
        $x("//button[text()='Sign In']").shouldBe(visible).click();
        $("#signinEmail").shouldBe(visible).sendKeys("test@hillel.ua");
        $("#signinPassword").shouldBe(visible).sendKeys("1111");
        $x("//button[text()='Login']").shouldBe(visible).click();
        $x("//p[@class='alert alert-danger']").shouldBe(Condition.visible, Duration.ofSeconds(3))
                .shouldHave(Condition.text("Wrong email or password"));
    }

    @DataProvider(name = "browsers", parallel = true)
    public Object[][] getBrowsers() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }
}
