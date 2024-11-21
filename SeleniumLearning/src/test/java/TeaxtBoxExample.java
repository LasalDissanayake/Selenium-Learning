import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeaxtBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }
        @Test
        public void testTextBox(){
            //Type Your Name
            WebElement name = driver.findElement(By.id("j_idt88:name"));
            name.sendKeys("Lasal");

            //Append country to this city
            WebElement append = driver.findElement(By.id("j_idt88:j_idt91"));
            append.sendKeys("Bla");

            //verify if the text box is disabled
            boolean isEnable = driver.findElement(By.id("j_idt88:j_idt91")).isEnabled();


            //clear the typed text
            WebElement clearPath = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));

            clearPath.clear();


            //retrieve the type text
            WebElement retrieveText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt97']"));

            String text = retrieveText.getAttribute("value");
            System.out.println("retrieve the type text is :"+text);


            //type email and Tab. confirm control moved to next element
            WebElement email = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt99']"));
            email.sendKeys("l@g.com"+Keys.TAB);

        }

    }

