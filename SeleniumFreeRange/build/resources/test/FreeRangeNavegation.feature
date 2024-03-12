# new feature
# Tags: los tags son identificadores que me permiten filtrar y ejecutar individualmente o especificamente uno o mas
# casos de prueba sin necesidad de comentariar los casos que yo no quiera correr.  Para ejecutarlos simplemente de
# le doy play en intellij sin necesidad de comandos.

  #barra de navegación

@Navigation #etiqueta para ejecutar todos los test

Feature:  Navigation
  To see the subpages
  Without logging in
  I can click the navigation bar links

  //En background se colocan aquellos pasos que son repetitivos en cada uno de los escenarios de prueba.
  //A tener en cuenta: No pueden ser mas de dos.
  //para todos estos casos de prueba si o si tiene que navegar a www.freerangetesters.com.
  //con esto no se repiten pasos.

  Background: I am on the Free Range Testers web without logging in.
    Given I navigate to www.freerangetesters.com

Scenario Outline: I can access the subpages through the navigation
  When I go to <section> using the navigation bar

 Examples:
   | section   |
   | Cursos    |
   | Recursos  |
   | Udemy     |
   | Mentorías |
   | Blog      |

  @Courses
  Scenario: Courses are presented correctly to potential customers
    When I go to Cursos using the navigation bar
    And I select Introduction al Testing

   @Plans
   Scenario: Users can select a plan when signing up
     When The client selects Elegir Plan
     Then The user can validate the options in the checkout page