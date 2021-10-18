package sample.model;

import org.openqa.selenium.WebElement;

public class Model {

    public class Product {

        private static int numberOfProducts;

        private String name;
        private double price;
        private double discount;

        public WebElement buyProductButton;

        public static int getNumberOfProducts(){
            return numberOfProducts;
        }

        Product(String name){
            numberOfProducts += 1;
            this.name = name;
        }

        Product(WebElement buyButton, double price){
            numberOfProducts += 1;
            this.price = price;
            this.discount = 0.0;
            this.buyProductButton = buyButton;
        }

        Product(WebElement buyButton, double price, double discount){
            numberOfProducts += 1;
            this.price = price;
            this.discount = discount;
            this.buyProductButton = buyButton;
        }

        public void buyProduct(){
            this.buyProductButton.click();
        }
    }
}

