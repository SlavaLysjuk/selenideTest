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
    @org.testng.annotations.Parameters({"browser"})
    public void setUp(String browser) {
        log.info("Test Method setUp");
        Configuration.timeout = 1000;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = browser;
//        Configuration.browserVersion = "124.0";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", false
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        Configuration.pollingInterval = 1000;

        open("/");
    }


}
