import com.codeborne.selenide.Configuration;
import hillel.qa.ConfigReader;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public static final Logger log = Logger.getLogger(BaseTest.class.getName());

    @BeforeMethod
    public void setUp() {
        log.info("Test Method setUp");
        Configuration.timeout = 1000;
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        Configuration.pollingInterval = 1000;

        open("/");
    }


}
