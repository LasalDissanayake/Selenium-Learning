import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateInventoryTest {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:5174/inventory/create");

    }

    private void fillInventoryForm(InventoryItem item) {
        driver.findElement(By.xpath("//body/div[@id='root']/div/div/div[1]/input[1]")).sendKeys(item.name);

        WebElement location = driver.findElement(By.xpath("//div[@id='root']//div//div//div//select")); // Example XPath for dropdown
        Select locationDropdown = new Select(location);


        driver.findElement(By.xpath("//div[3]//input[1]")).sendKeys(String.valueOf(item.quantity));
        driver.findElement(By.xpath("//div[4]//input[1]")).sendKeys(String.valueOf(item.purchasedPrice));
        driver.findElement(By.xpath("//div[5]//input[1]")).sendKeys(String.valueOf(item.sellPrice));
        driver.findElement(By.xpath("//div[6]//input[1]")).sendKeys(item.supName);
        driver.findElement(By.xpath("//div[7]//input[1]")).sendKeys(item.supPhone);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(item.supEmail);
    }

    @Test
    public void createInventory() {
        InventoryItem invalidName = new InventoryItem("", "Bin", 45, 450.0, 450.0, "Aa", "0719851840", "l@g.com");
        InventoryItem invalidLocation = new InventoryItem("Aa", "Table", 45, 450.0, 450.0, "Aa", "0719851840", "InvalidEmail");
        InventoryItem invalidQuantity = new InventoryItem("Screw","Bin", -5, 450.0, 550.0, "Mr.Screw", "0719851840", "MrScrew@gmail.com");
        InventoryItem invalidPurchasedPrice = new InventoryItem("Screw", "Bin",45, -100.0, 550.0, "Mr.Screw", "0719851840", "MrScrew@gmail.com");
        InventoryItem invalidSellPrice = new InventoryItem("Screw","Bin", 45, 450.0, 350.0, "Mr.Screw", "0719851840", "MrScrew@gmail.com");
        InventoryItem invalidSupplierName = new InventoryItem("Screw","Bin", 45, 450.0, 550.0, "", "0719851840", "MrScrew@gmail.com");
        InventoryItem invalidSupplierPhone = new InventoryItem("Screw","Bin", 45, 450.0, 550.0, "Mr.Screw", "871985184", "MrScrew@gmail.com");
        InventoryItem invalidSupplierEmail = new InventoryItem("Screw","Bin", 45, 450.0, 550.0, "Mr.Screw", "0719851840", "MrScrew.com");
        InventoryItem validInput = new InventoryItem("Widget","Bin", 100, 100.0, 120.0, "Mr.Lasal", "0719851840", "lasal@gmail.com");

        WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Save']"));

        // Test invalid inputs
        fillInventoryForm(invalidName);

        driver.navigate().refresh();
        fillInventoryForm(invalidLocation);
        driver.navigate().refresh();
        fillInventoryForm(invalidQuantity);
        driver.navigate().refresh();
        fillInventoryForm(invalidPurchasedPrice);
        driver.navigate().refresh();
        fillInventoryForm(invalidSellPrice);
        driver.navigate().refresh();
        fillInventoryForm(invalidSupplierName);
        driver.navigate().refresh();
        fillInventoryForm(invalidSupplierPhone);
        driver.navigate().refresh();
        fillInventoryForm(invalidSupplierEmail);
        driver.navigate().refresh();

        // Clear fields before the next test
         driver.navigate().refresh();

         //Test valid inputs
       fillInventoryForm(validInput);
        submit.click();
    }
}

