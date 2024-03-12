package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeRangeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Inicializa webdriver para chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navegamosAFreeRangeTesters() {
        //Navega a la página Web
        driver.get("https://www.freerangetesters.com/");
    }

    @AfterMethod
    public void tearDown() {
        //Cierra el navegador después de la prueba
        if (driver != null) {
            driver.quit();
        }
    }
}
