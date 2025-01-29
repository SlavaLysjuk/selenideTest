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
        Configuration.timeout = 1000;
        log.info("Remote URL: " + ConfigReader.getRemoteUrl());
        //Configuration.remote = "http://localhost:4444/wd/hub";
//        Configuration.remote = ConfigReader.getRemoteUrl();
        Configuration.browser = "chrome";
//        Configuration.browserVersion = "latest";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.of(
//                "enableVNC", true,
//                "enableVideo", false
//        ));
//        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        Configuration.pollingInterval = 1000;

        open("/");
    }


}
