package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    /*
     * Declaración de una variable estática 'Driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y subclases
     */
    protected static WebDriver driver;

    /*
     * Declaración de una variable de instancia 'Wait' de tipo WebdriverWait.
     * Se inicializa inmediatamente con una instancia de WebdriverWait utilizando el 'Driver' estático
     * WebDriverWait se usa para poner esperas explicitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador.
     */
    static {
        WebDriverManager.chromedriver().setup();
        //Inicializa la variable estatica 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /*
     * Este es el constructor de BasePage que acepta el objeto WebDriver como argumento
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    //Método estático para navegar a una url.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
    // esperando a que esté presentente en el DOM
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String keysToSend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropDowmnByValue(String locator, String value) {
        Select dropdowm = new Select(Find(locator));
        dropdowm.selectByValue(value);
    }

    public void selectFromDropDowmnByIndex(String locator, Integer index) {
        Select dropdowm = new Select(Find(locator));
        dropdowm.deselectByIndex(index);
    }

    //Método que cuenta la cantidad de opciones que tiene un dropdowm.
    public int dropDowmSize(String locator){
        Select dropdowm = new Select(Find(locator));
        List<WebElement> dropdowmOptions = dropdowm.getOptions();
        return dropdowmOptions.size();
    }

    //Método para ver las opciones que tiene un dropdowm (todos los valores en formato texto).

    public List<String> getDropdowmValues(String locator){
        Select dropdowm = new Select(Find(locator)); //se crea una instancia de la clase select de selenium
        //crear lista del tipo web element, va a devolver todos los elementos web dentro del dropdown.
        List<WebElement> dropdowmOptions = dropdowm.getOptions();
        //Aqui los trae en forma de lista de strings que va a ser de tipo array.
        List<String> values = new ArrayList<>();

        //para cada webElement que vamos a llamar option, dentro de esta lista de WebElement dropdowmOptions;
        for (WebElement option: dropdowmOptions ){
            //Agarra el texto y lo agrega a la lista de strings que tenemos llamada "values"
            values.add(option.getText());
        }
        return values; //retorna la lista en string como lo pide el método.

    }
}
