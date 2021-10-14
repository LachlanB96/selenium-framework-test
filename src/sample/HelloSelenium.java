package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import sample.homepage.HomePage;

public class HelloSelenium {

    static WebDriver driver;

    public static void main(String[] args) throws AWTException {
        //Learn how to navigate iframes
        //Learn how to use implicit and explicit waits
        // Learn how to use a pom.xml
        //use a relative
        //        System.setProperty("webdriver.chrome.driver", ".\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LachlanB\\Documents\\git\\work\\java\\chromedriver.exe");

        System.out.println("Hello, Selenium!");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        System.out.println("1. POM TEST");
        System.out.println("2. Checkboxes");
        System.out.println("3. Basic Auth");
        System.out.println("4. Input");

        //int input = sc.nextInt();
        int input = 1;

        driver = new ChromeDriver();
        //Instead of using these absolute paths, I could use paths that use a contain method to dynamically get an element
        if (input == 1){
            //How do I define a page when I have multiple pages?
            HomePage homePage = new HomePage();
            homePage.clickDressesButton(driver);
        }
//        else if(input == 2) {
//            driver.get("http://the-internet.herokuapp.com");
//            driver.findElement(By.xpath("//body/div[2]/div/ul/li[6]/a")).click();
//            checkBoxes(driver);
//        } else if(input == 3){
//            driver.get("http://the-internet.herokuapp.com");
//            driver.findElement(By.xpath("//body/div[2]/div/ul/li[3]/a")).click();
//            basicAuth(driver);
//        } else if(input == 4){
//            driver.get("http://the-internet.herokuapp.com");
//            driver.findElement(By.xpath("//body/div[2]/div/ul/li[27]/a")).click();
//            inputs(driver);
//        }
    }

    public static void checkBoxes(WebDriver driver){
        //List<WebElement> main = driver.findElements(By.className("main"));
        List<WebElement> checkBoxes = driver.findElements(By.id("checkboxes"));
        //WebElement firstBox = driver.findElement(By.id("checkboxes"));
        System.out.println(driver.findElements(By.className("ng-scope")));
        for (Object obj : checkBoxes) {
            System.out.println(obj);
        }
        //System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();
    }

    public static void basicAuth(WebDriver driver) throws AWTException {
        //actions are preffered over robots
        Robot robotKeys = new Robot();
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        //use wait driver handler instead. Use dynamic timings not static. fluent wait
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        robotKeys.keyPress(KeyEvent.VK_A);
        robotKeys.keyPress(KeyEvent.VK_D);
        robotKeys.keyPress(KeyEvent.VK_M);
        robotKeys.keyPress(KeyEvent.VK_I);
        robotKeys.keyPress(KeyEvent.VK_N);
        robotKeys.keyPress(KeyEvent.VK_TAB);
        robotKeys.keyPress(KeyEvent.VK_A);
        robotKeys.keyPress(KeyEvent.VK_D);
        robotKeys.keyPress(KeyEvent.VK_M);
        robotKeys.keyPress(KeyEvent.VK_I);
        robotKeys.keyPress(KeyEvent.VK_N);
    }

    public static void inputs(WebDriver driver){
        WebElement inputBox = driver.findElement(By.xpath("//input"));
        inputBox.sendKeys(Keys.UP);
        inputBox.sendKeys(Keys.UP);
        inputBox.sendKeys(Keys.UP);
        inputBox.sendKeys(Keys.UP);
        inputBox.sendKeys(Keys.UP);
    }
}

/*
How do you find an element when the html is like this:

<html>
<body>
<form>
<input type="checkbox">Box1</input>
<input type="checkbox">Box2</input>
</form>
</body>
</html>

How to get div then play with its sub elements?
<html>
<body>
<div>
<form>
<input type="checkbox">Box1</input>
<input type="checkbox">Box1</input>
</form>
</div>
</body>
</html>
 */