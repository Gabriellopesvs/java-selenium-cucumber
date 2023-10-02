package steps;

import command.webDriverSetup;
import elements.elementsWeb;
import command.component;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class webTest {
    private static webDriverSetup init;
    private WebDriver driver;
    private static elementsWeb page = new elementsWeb();
    private static component comp = new component();

    @Given("the website {string} is accessed")
    public void the_website_is_accessed(String endpoint) {
        init = new webDriverSetup();
        driver = init.initializeWebDriver(endpoint);
    }

    @When("the user logs in with the following credentials:")
    public void the_user_logs_in_with_the_following_credentials(io.cucumber.datatable.DataTable dataTable) {
        // Converte os dados da tabela da feature em uma lista de mapas
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        // Obtém o valor da coluna "value" na feature e armazena na variável
        String name = comp.getValue(table, 0);
        String password = comp.getValue(table, 1);

        //Utiliza o método "commandPage" para interagir com um elemento da página
        comp.commandPage(driver, "name", page.name(), "click", null);
        comp.commandPage(driver, "name", page.name(), "send", name);
        comp.commandPage(driver, "id", page.password(), "click", null);
        comp.commandPage(driver, "id", page.password(), "send", password);
    }

    @Then("the user should be logged in and see a success message")
    public void the_user_should_be_logged_in_and_see_a_success_message() {
        comp.commandPage(driver, "xpath", page.button(), "click", null);
        init.quitPage();
    }

}



