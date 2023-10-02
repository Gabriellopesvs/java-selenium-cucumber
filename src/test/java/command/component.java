package command;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Map;

public class component {

    // typeElement: Este método é responsável por localizar um elemento na página usando diferentes
    // tipos de localizadores, como XPath, Name ou ID.
    public static WebElement typeElement(WebDriver driver, String type, String path) {

        WebElement element = null;

        if (type.equals("xpath")) {
            element = driver.findElement(By.xpath(path));
        }
        if (type.equals("name")) {
            element = driver.findElement(By.name(path));
        }
        if (type.equals("id")) {
            element = driver.findElement(By.id(path));
        }
        return element;
    }

    // commandPage: Este método oferece uma maneira simplificada de executar ações em elementos da página. Ele utiliza o
    // método typeElement para localizar o elemento com base no tipo e caminho fornecidos
    public void commandPage(WebDriver driver, String type, String element, String command, String text) {
        WebElement commandElement = typeElement(driver, type, element);

        if (command.equals("click")) {
            commandElement.click();
        } else if (command.equals("send")) {
            if (text != null) {
                commandElement.sendKeys(text);
            }
        }
    }

    // getValue: Este método é usado para obter valores de uma tabela de dados definida na feature.
    public String getValue(List<Map<String, String>> table, int index) {
        if (index >= 0 && index < table.size()) {
            Map<String, String> row = table.get(index);
            return row.get("value");
        }
        return null;
    }

}
