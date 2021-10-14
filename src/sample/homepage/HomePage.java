package sample.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import sample.Page;


public class HomePage extends Page {

    public void clickDressesButton(WebDriver driver) {
        driver.get("http://automationpractice.com/index.php");
        //because final static does not need to be acknoledged as param
        driver.findElement(HomePageObjects.dressesButtonXPath).click();
    }

}
