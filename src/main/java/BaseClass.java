import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties config  = new Properties();

    @BeforeClass
    public void setUp() {

    }
}
