package command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriverSetup {
    private WebDriver driver;

    public WebDriver initializeWebDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\criar_0cs\\OneDrive\\Documentos\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public void quitPage() {
            driver.quit();
    }
}
