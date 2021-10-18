package sample;

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
        DressesPage dressesPage = new DressesPage();
        dressesPage.getAllDresses(driver);
        List<DressesPage.Product> products = dressesPage.getAllDressObjects(driver);
        DressesPage.Product bestDiscountedProduct = null;
        double bestDiscount = 0.0;
        double dressDiscount;
        for (DressesPage.Product product : products){
            product.getDiscount();
//            Boolean hasDiscount = product.findElements(DressesPageObjects.discountInformation).size() > 0;
//            if(hasDiscount) {
//                String[] lines = product.getText().split("\\n");
//                String[] priceLine = lines[1].split(" ");
//                dressDiscount = Double.parseDouble(priceLine[2].substring(0, priceLine[2].length() - 1));
//                if(dressDiscount < bestDiscount){
//                    bestDiscount = dressDiscount;
//                    bestDiscountedProduct = product;
//                }
//            }
        }
        System.out.println(bestDiscountedProduct.getName());
        //bestDiscountedProduct.click();
    }
}