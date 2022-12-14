package page_object_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicPage {

    protected   WebDriver driver;

    public  WebDriver getDriver() {
        return driver;
    }

    public BasicPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }
}
