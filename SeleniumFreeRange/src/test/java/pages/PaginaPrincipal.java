package pages;

public class PaginaPrincipal extends BasePage{

    //private String searchButton = "//a[@href='/programacion-y-trabajo-con-codigo-para-testers'][normalize-space()='Ver curso']";
    private String sectionLink = "//a[normalize-space()='%s' and @href]";

    private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";


    public PaginaPrincipal() {
        super(driver);
    }

    //Método para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters(){

        navigateTo("https://www.freerangetesters.com/");
        //clickElement(searchButton);
    }

    public void clickOnSectionNavigationBar(String section){
        //Reemplaza el marcador de posición (#s) en sectionLink por el nombre.
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlanButton(){
        clickElement(elegirUnPlanButton);
    }

}
