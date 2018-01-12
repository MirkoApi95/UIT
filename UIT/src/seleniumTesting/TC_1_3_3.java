package seleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_1_3_3 {

  public static void main(String[] args) {
    /**
     * Classe per testare la modifica della password, l'utente inserisce due password diverse
     */
    System.setProperty("webdriver.chrome.driver", "D:\\Utenti\\Mirko\\Desktop\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("http://localhost:8080/UIT/AccountView.jsp");
    WebElement inputpassword;
    WebElement inputnewpassword;
    WebElement button;

    inputpassword= driver.findElement(By.id("passwordinput"));
    inputpassword.sendKeys("apicella55");
    inputnewpassword= driver.findElement(By.id("confirm_password"));
    inputnewpassword.sendKeys("aicella55");
    button=driver.findElement(By.id("conferma"));
    button.click();
  }
}
