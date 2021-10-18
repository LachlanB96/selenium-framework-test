package sample.pages.automationPractice.homepage;

import sample.Page;
import sample.TestDriver;


public class HomePage extends Page {

    public void clickDressesButton(TestDriver driver) {
        driver.goToURL("http://automationpractice.com/index.php");
        driver.findElement(HomePageObjects.dressesButtonXPath).click();
    }

}
