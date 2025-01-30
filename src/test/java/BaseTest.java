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
    public void setUp(Object[] params) {
        if (params.length == 0 || !(params[0] instanceof String)) {
            throw new IllegalArgumentException("Browser parameter is missing or invalid.");
        }

        String browser = (String) params[0];
        log.info("Setting up browser: " + browser);

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = browser;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        Configuration.pollingInterval = 1000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", false
        ));
        Configuration.browserCapabilities = capabilities;

        open("/");
    }


}
