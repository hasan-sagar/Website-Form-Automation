import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//set test instance to configure junit lifecycle test
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FormAutomationTest {
    //import webdriver to use browser and functionalities
    WebDriver driver;

    @BeforeAll
    public void setup() {
        //Chrome browser
        driver = new ChromeDriver();
        //always maximize window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testWebApp() throws InterruptedException {
        //test url
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        //accept all cookie button
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //enter name
        driver.findElement(By.id("edit-name")).sendKeys("Khalid Hasan Sagar");
        //enter number
        driver.findElement(By.id("edit-number")).sendKeys("01726487843");
        //enter age
        driver.findElements(By.className("ui-button")).get(0).click();
        //enter date
        driver.findElement(By.id("edit-date")).sendKeys("03/20/2024");
        //enter email
        driver.findElement(By.id("edit-email")).sendKeys("khsagar0512@gmail.com");
        //enter about myself
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("Hi my name is Sagar");
        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        //scroll down to next section
        Utils.scrollToDown(driver , 0 , 500);
        //upload pdf
        uploadElement.sendKeys("C:\\Users\\User\\Desktop\\Khalid Hasan Sagar CV.pdf");
        Thread.sleep(2000);
        //checkbox for confirm
        driver.findElement(By.id("edit-age")).click();
        //submit form
        driver.findElement(By.id("edit-submit")).click();
        //see confirmation message
        String messageConfirmation = driver.findElement(By.id("block-pagetitle-2")).getText();
        Assertions.assertTrue(messageConfirmation.contains("Thank you for your submission!"));
    }

    @AfterAll
    public void stopAutomation(){
        //driver.quit();
    }
}
