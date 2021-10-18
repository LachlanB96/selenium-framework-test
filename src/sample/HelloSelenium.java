package sample;

import org.openqa.selenium.WebElement;

import java.util.*;

import sample.exceptions.DriverLocationException;
import sample.pages.automationPractice.homepage.HomePage;
import sample.pages.automationPractice.dressesPage.*;


public class HelloSelenium {


    public static void main(String[] args) throws DriverLocationException {

        TestDriver driver = new TestDriver();

        //Create an instance of homepage which calls the get() function on our driver
        HomePage homePage = new HomePage();
        //On the homepage we want to click the button to shop for our dresses
        homePage.clickDressesButton(driver);
        //Once we're on the
        DressesPage dressesPage = new DressesPage();
        dressesPage.getAllDresses(driver);
        List<WebElement> dresses = dressesPage.getAllDresses(driver);
        WebElement bestDiscountedDress = null;
        double bestDiscount = 0.0;
        double dressDiscount;
        for (WebElement dress : dresses){
            Boolean hasDiscount = dress.findElements(DressesPageObjects.discountInformation).size() > 0;
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