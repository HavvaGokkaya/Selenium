package day05_Assertions_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //	1. Kategori menusunden Books secenegini  secin
    //	2. Arama kutusuna Java yazin ve aratin
    //	3. Bulunan sonuc sayisini yazdirin
    //	4. Sonucun Java kelimesini icerdigini test edin
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test01(){
        //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);
        int actualOptionSayisi = select.getOptions().size();
        int expectedOptionSayisi = 45;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }

    @Test
    public void test02(){
        //1. Kategori menusunden Books secenegini  secin
        //	2. Arama kutusuna Java yazin ve aratin
        //	3. Bulunan sonuc sayisini yazdirin
        //	4. Sonucun Java kelimesini icerdigini test edin

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Books");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        WebElement aramasonucYazisi = driver.findElement(By.tagName("h1"));
        System.out.println(aramasonucYazisi.getText());

        String expectedIcerik = "Java";
        String actualIcerik = aramasonucYazisi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
