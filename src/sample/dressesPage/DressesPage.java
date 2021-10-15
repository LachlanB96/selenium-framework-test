package sample.dressesPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sample.Page;

import java.util.List;


public class DressesPage extends Page {



    public List<WebElement> getAllDresses(WebDriver driver) {
        return driver.findElements(DressesPageObjects.dresses);
    }

    public class Dress {

        private static int numberOfDresses;

        private double price;
        private double discount;

        Dress(double price){
            numberOfDresses += 1;
            this.price = price;
            this.discount = 0.0;
        }

        Dress(double price, double discount){
            numberOfDresses += 1;
            this.price = price;
            this.discount = discount;
        }

        public static int getNumberOfDresses(){
            return numberOfDresses;
        }
    }

}
