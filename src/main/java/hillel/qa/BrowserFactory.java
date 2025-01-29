package hillel.qa;
import org.testng.annotations.DataProvider;

public class BrowserFactory {

    @DataProvider(name = "browsers")
    public static Object[][] getBrowsers() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }



}
