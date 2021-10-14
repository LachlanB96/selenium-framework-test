package sample.homepage;

import org.openqa.selenium.By;


public class HomePageObjects {

    public static By dressesButton = By.linkText("Dresses");
    public static By dressesButtonXPath = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a");
    ////a[contains(@href,'category') and contains(@title,'dress') and text() = 'Dresses']

}
