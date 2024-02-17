
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PinterstSeleccionDeUnaImagen extends TestCase {
    private WebDriver driver;

    @Before
    public void setUp() {
        SafariOptions options = new SafariOptions();
        driver = new SafariDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.pinterest.com/");
    }

    @Test
    public void test() {
        // buscar boton explorar
        By btExplorar = By.xpath("//div[contains(text(),'Explorar')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(btExplorar)).click();

        // dar click en el input de buscar
        By inputBuscar = By.xpath("//*[@id=\"searchBoxContainer\"]/div/div/div[2]/input");
        wait.until(ExpectedConditions.elementToBeClickable(inputBuscar));

        // escribir en el input de buscar
        wait.until(ExpectedConditions.elementToBeClickable(inputBuscar)).sendKeys("rosas");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(inputBuscar)).sendKeys(Keys.ENTER);

        // click en el 3er elemento
        By elementThree = By.xpath("//*[@id=\"mweb-unauth-container\"]/div/div[3]/div/div[2]/div/div[1]/div/div[1]/div[3]");
        wait.until(ExpectedConditions.elementToBeClickable(elementThree)).click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
