import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
            //Append country to this city
            //clear the typed text
            //retrieve the type text
            //type email and Tab. confirm control moved to next element

        }

    }

