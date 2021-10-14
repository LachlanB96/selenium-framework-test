package sample.homepage;

import org.openqa.selenium.WebDriver;

import sample.Page;


public class HomePage extends Page {

    public void clickDressesButton(WebDriver driver) {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(HomePageObjects.dressesButtonXPath).click();
    }

}
