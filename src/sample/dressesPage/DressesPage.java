package sample.dressesPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sample.Page;

import java.util.List;


public class DressesPage extends Page {

    public List<WebElement> getAllDresses(WebDriver driver) {
        return driver.findElements(DressesPageObjects.dresses);
    }

}
