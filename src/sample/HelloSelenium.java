package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

import sample.homepage.HomePage;
import sample.dressesPage.*;


public class HelloSelenium {

    static WebDriver driver;

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        driver = new ChromeDriver();

        HomePage homePage = new HomePage();
        homePage.clickDressesButton(driver);
        DressesPage dressesPage = new DressesPage();
        dressesPage.getAllDresses(driver);
        List<WebElement> dresses = dressesPage.getAllDresses(driver);
        for (WebElement dress : dresses){
            System.out.println(dress.getText());
            Boolean hasDiscount = dress.findElements(By.className("price-percent-reduction")).size() > 0;
            if(hasDiscount) {
                //String discount = dress.findElement(By.className("price-box")).getText();
                System.out.println(dress.toString());
            }
        }
    }
}