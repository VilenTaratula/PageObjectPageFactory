package page_object_classes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SiteTest {
    protected WebDriver driver;
    public String wrongPhoneNumber = "0000000000";
    public String wrongPassword = "1111111111";
    public String expectedHomePageUrl = "https://avic.ua/ua";
    public String expectedNoteBookPageUrl = "https://avic.ua/ua/noutbuki-i-aksessuaryi";
    public String expectedTitle = "AVIC ™ - зручний інтернет-магазин побутової техніки та електроніки в Україні. | Avic";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        driver.get("https://avic.ua");
    }

    @AfterClass
    public void setDown() {
        driver.quit();
    }


    public WebDriver getDriver() {
        return driver;
    }

}
