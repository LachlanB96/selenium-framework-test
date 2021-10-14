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
        WebElement bestDiscountedDress = null;
        double bestDiscount = 0.0;
        double dressDiscount;
        for (WebElement dress : dresses){
            Boolean hasDiscount = dress.findElements(By.className("price-percent-reduction")).size() > 0;
            if(hasDiscount) {
                String[] lines = dress.getText().split("\\n");
                String[] priceLine = lines[1].split(" ");
                dressDiscount = Double.parseDouble(priceLine[2].substring(0, priceLine[2].length() - 1));
                if(dressDiscount < bestDiscount){
                    bestDiscount = dressDiscount;
                    bestDiscountedDress = dress;
                }
            }
        }
        System.out.println(bestDiscountedDress.getText());
        bestDiscountedDress.click();
    }
}