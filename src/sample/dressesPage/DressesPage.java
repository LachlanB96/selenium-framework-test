package sample.dressesPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sample.Page;

import java.util.List;


public class DressesPage extends Page {



    public List<WebElement> getAllDresses(WebDriver driver) {
        return driver.findElements(DressesPageObjects.dresses);
    }

    public List<Dress> getAllDressObjects(WebDriver driver){
        List<WebElement> dressWebElements = driver.findElements(DressesPageObjects.dresses);
        List<Dress> dresses = null;
        for (WebElement dressWebElement : dressWebElements){
            //Need to change the first arg to give the dress the buy button
            dresses.add(new Dress(dressWebElement, 10, 10));
        }
        return dresses;
    }

    public class Dress {

        private static int numberOfDresses;

        private double price;
        private double discount;

        public WebElement buyDressButton;

        public static int getNumberOfDresses(){
            return numberOfDresses;
        }

        Dress(WebElement buyButton, double price){
            numberOfDresses += 1;
            this.price = price;
            this.discount = 0.0;
            this.buyDressButton = buyButton;
        }

        Dress(WebElement buyButton, double price, double discount){
            numberOfDresses += 1;
            this.price = price;
            this.discount = discount;
            this.buyDressButton = buyButton;
        }

        public void buyDress(){
            this.buyDressButton.click();
        }
    }

}
