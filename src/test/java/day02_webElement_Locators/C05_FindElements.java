package day02_webElement_Locators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        // arama kutusuna java yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinda cikan resimlerdeki yazilari yazdirin
        List<WebElement> aramaSonuclariElementList = driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonuclariElementList.size()); // 70

        // bu 70 elementi yazdiralim
        int webElementi=1;

        for (WebElement each:aramaSonuclariElementList
             ) {
            System.out.println(webElementi+"---"+each.getText());
            webElementi++;

        }
        Thread.sleep(3000);

        driver.close();



    }
}
