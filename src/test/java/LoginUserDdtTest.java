import com.codeborne.selenide.Condition;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginUserDdtTest extends BaseTest {

    @Ignore
    @Test(dataProvider = "loginPassword")
    public void testUserLoginByDdt(String email, String password) {
        $x("//button[text()='Sign In']").shouldBe(visible).click();
        $("#signinEmail").shouldBe(visible).sendKeys(email);
        $("#signinPassword").shouldBe(visible).sendKeys(password);
        $x("//button[text()='Login']").shouldBe(visible).click();
        $x("//p[@class='alert alert-danger']").shouldBe(Condition.visible, Duration.ofSeconds(3))
                .shouldHave(Condition.text("Wrong email or password"));
    }

    @DataProvider(name = "loginPassword")
    public Object[][] loginPassword() {
        return new Object[][]{
                {"test@hillel.ua", "1111"},
                {"test@hillel.ua", "1234"}
        };
    }
}
