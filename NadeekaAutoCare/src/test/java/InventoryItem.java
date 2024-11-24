import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class InventoryItem {
    String name;
    String location;
    int quantity;
    double purchasedPrice;
    double sellPrice;
    String supName;
    String supPhone;
    String supEmail;

    public InventoryItem(String name, String location, int quantity, double purchasedPrice, double sellPrice, String supName, String supPhone, String supEmail) {
        this.name = name;
        this.location = location;
        this.quantity = quantity;
        this.purchasedPrice = purchasedPrice;
        this.sellPrice = sellPrice;
        this.supName = supName;
        this.supPhone = supPhone;
        this.supEmail = supEmail;
    }
}


