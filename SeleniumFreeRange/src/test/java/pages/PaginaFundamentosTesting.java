package pages;

import org.openqa.selenium.WebDriver;

public class PaginaFundamentosTesting extends BasePage{

    private String introduccionTestingLink = "//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Ver producto']";
    //a[normalize-space()='Introducción al Testing de Software' and @href]";
    //Este xpath no me funcionó:"//a[@href=\"/introduccion-al-testing-de-software\" and @class=\"sc-hHftZz fCaYAt\"]";

    public PaginaFundamentosTesting() {
        super(driver);
    }
        public void clickIntroduccionTestingLink(){
        clickElement(introduccionTestingLink);
    }

}
