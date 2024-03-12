package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", //Este es el directorio de nuestros archivos .feature
        glue = "steps", //Paquete donde tenemos nuestras clases definiendo los steps escritos en el feature file.
        plugin = {"pretty", "html:target/cucumber-reports"}, //esto es para generar reporte
        //tags = "@Navigation"
        tags = "@Navigation" //En esta parte coloco las etiquetas de los test que yo quiera correr especificamente.
)


public class TestRunner  {


    @AfterClass
    public static void cleanDriver (){
    BasePage.closeBrowser();
    }

}


