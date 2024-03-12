package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;
import java.util.Arrays;
import java.util.List;
import org.testng.asserts.SoftAssert;


public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage= new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new  PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }


    @When("^(?:I|The user|The client) selects? Elegir Plan$")
    public void selectElegirPlan() {
        landingPage.clickOnElegirPlanButton();
    }

    @And("^(?:I|The user|The client) selects? Introduction al Testing$")
    public void navigateToIntro() {
        cursosPage.clickFundamentosTestingLink();
        fundamentosPage.clickIntroduccionTestingLink();
    }

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$")
    public void validateCheckoutPlans() {
        //lista real
        List<String> lista = registro.returnPlanDropdowmValues();
        //lista esperada
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes \u2022 12 productos","Academia: $176 / a\u00F1o \u2022 12 productos","Free: Gratis \u2022 1 producto");
        //metodo de la libreria TestNG para comparar las listas.
        Assert.assertEquals(listaEsperada, lista);
    }



    SoftAssert soft = new SoftAssert();
    //Y así se ven (exactamente como las assertions comunes, pero con el potente assertAll(); al final!
    public void Ejemplulis() {
        String palabraEsperada = "Pepe";
        String palabraEncontrada = "Papa";

        // Soft Assertions: No detienen la ejecución al fallar. Ideal para verificar
        // muchas cosas pequeñas a la vez.
        soft.assertEquals(palabraEsperada, palabraEncontrada);
        soft.assertTrue(palabraEncontrada.contains(palabraEsperada));
        soft.assertNotEquals(palabraEncontrada,palabraEsperada);

        soft.assertAll();

    }

}

//Nota: En el metodo validateCheckoutPlans(), se utilizaron Secuencias de Escape Unicode
// con el fin de que el carácter especial fuera interpretado correctamente y no me generara error.

//Nota 2: Al colocar lo siguiente en los steps= ?: significa que se le está diciendo a cucumber que puede
//usar cualquiera de las tres opciones = "I|The user|The client".

//Nota 3: cuando se coloca este simbolo ^ al principio del paso y este simbolo $ al final, indica el comienzo
//y final exacto del step. Esto le permite a cucumber identificar cada paso.


