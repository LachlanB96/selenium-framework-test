package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sample.exceptions.DriverLocationException;

import java.util.List;

public class TestDriver {

    private static WebDriver driver;

    TestDriver() {
        try {
            importDriver();
        }
        catch (Exception e) {
            System.out.println("Import Failed");
        }
        this.driver = new ChromeDriver();
    }

    public static void goToURL(String URL){
        driver.get(URL);
    }

    public static WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    static void importDriver() throws DriverLocationException {
        try {
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        }
        catch (Exception e) { //IllegalStateException ?
            System.out.println("Can not locate chrome driver. Illegal State Exception.");
            throw new DriverLocationException("Chrome Driver not found");
        } finally {
            System.out.println("Test");
        }
    }

}
