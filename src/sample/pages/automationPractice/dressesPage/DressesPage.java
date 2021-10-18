package sample.pages.automationPractice.dressesPage;

import org.openqa.selenium.WebElement;

import sample.Page;
import sample.TestDriver;

import java.util.ArrayList;
import java.util.List;


public class DressesPage extends Page {



    public List<WebElement> getAllDresses(TestDriver driver) {
        return driver.findElements(DressesPageObjects.dresses);
    }

    public List<Product> getAllDressObjects(TestDriver driver){
        List<WebElement> dressWebElements = driver.findElements(DressesPageObjects.dresses);
        List<Product> products = new ArrayList<>();
        for (WebElement dressWebElement : dressWebElements){
            //Need to change the first arg to give the dress the buy button
            products.add(new Product(dressWebElement, 10, 10));
        }
        return products;
    }

    public class Product {

        private static int numberOfDresses;

        private double price;
        private double discount;
        private String name;

        public WebElement productElement;

        public static int getNumberOfDresses(){
            return numberOfDresses;
        }

        Product(WebElement buyButton, double price){
            numberOfDresses += 1;
            this.price = price;
            this.discount = 0.0;
            this.productElement = buyButton;
            name = "test1";
        }

        Product(WebElement buyButton, double price, double discount){
            numberOfDresses += 1;
            this.price = price;
            this.discount = discount;
            this.productElement = buyButton;
            name = "test2";
        }

        /*        public void buyDress(){
            this.buyDressButton.click();
        }*/

        public String getName(){
            return this.name;
        }

        public void getDiscount(){
            try {
                productElement.findElement(DressesPageObjects.discountInformation);
            } catch (Exception e){
                this.discount = 0;
            }
            System.out.println(this.name);
        }
    }

}
