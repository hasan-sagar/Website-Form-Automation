package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {
    WebDriver driver;

    public static void scrollToDown(WebDriver driver, int x, int y) {
        //use scroll down to view pages automatic
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
    }
}
