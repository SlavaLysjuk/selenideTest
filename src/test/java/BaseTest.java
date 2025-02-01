import com.codeborne.selenide.Configuration;
import hillel.qa.ConfigReader;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.util.Map;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public static final Logger log = Logger.getLogger(BaseTest.class.getName());

    @BeforeMethod
    public void setUp() {
        log.info("Test Method setUp");
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        Configuration.pollingInterval = 1000;

        open("/");
    }


}
