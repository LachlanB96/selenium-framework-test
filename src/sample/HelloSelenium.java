package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

import sample.homepage.HomePage;
import sample.dressesPage.*;

public class HelloSelenium {

    static WebDriver driver;

    public static void main(String[] args){
        //Learn how to navigate iframes
        //Learn how to use implicit and explicit waits
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        System.out.println("1. POM TEST");

        //int input = sc.nextInt();
        int input = 1;

        driver = new ChromeDriver();

        if (input == 1){
            //How do I define a page when I have multiple pages?
            HomePage homePage = new HomePage();
            homePage.clickDressesButton(driver);
            DressesPage dressesPage = new DressesPage();
            dressesPage.getAllDresses(driver);
            //List<WebElement> dre
        }
    }


}