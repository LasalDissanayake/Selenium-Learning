import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

    }

    @Test
    public void testLinks(){

        WebElement homepage = driver.findElement(By.linkText("Go to Dashboard"));
        homepage.click();
        driver.navigate().back();

        WebElement path = driver.findElement(By.partialLinkText("Find the URL"));
        path.getAttribute("href");
        System.out.println("Path is"+ path);


        WebElement brokenElement = driver.findElement(By.linkText("Broken?"));
        brokenElement.click();
        String titleName = driver.getTitle();
        if (titleName.contains("404")) {
            System.out.println("This is Error Page");
        }else
            System.out.println("This is good");

        driver.navigate().back();


        List<WebElement> countTags = driver.findElements(By.tagName("a"));
        int count = countTags.size();
        System.out.println("a Tags in the web pages: "+ count);

        WebElement container = driver.findElement(By.className("layout-main-content"));
        List<WebElement> containerTags = container.findElements(By.tagName("a"));
        int count2 = containerTags.size();
        System.out.println("Container tags count is: "+count2);





        driver.quit();
    }

}

