package praktikum.drivers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    static String binaryYandexDriverFile = "drivers/yandexdriver.exe";
    @Step("Выбор драйвера в зависимости от входных параметров")
    public static WebDriver getDriver(String browserName){
        switch (browserName){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-fullscreen");
                options.addArguments("--incognito");
                return new ChromeDriver(options);
            case "yandex":
                System.setProperty("webdriver.chrome.driver", binaryYandexDriverFile);
                ChromeOptions yOptions = new ChromeOptions();
                yOptions.addArguments("--start-fullscreen");
                yOptions.addArguments("--incognito");
                return new ChromeDriver(yOptions);
            case "firefox":
                FirefoxOptions optionsF = new FirefoxOptions();
                optionsF.addArguments("--kiosk");
                optionsF.addArguments("-private");
                return new FirefoxDriver(optionsF);
            default:
                throw new RuntimeException("Введено некорректное название браузера");
        }
    }
}
