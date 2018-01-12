package seleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 * @author Mirko
 * La calsse testa la registrazione inserendo come campo errato @gmail.com
 */
public class TC_1_1_1 {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "D:\\Utenti\\Mirko\\Desktop\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("http://localhost:8080/UIT/RegistrazioneView.jsp");
    WebElement inputEmail;
    WebElement inputpassword;
    WebElement confirm_password;
    WebElement button;
    inputEmail= driver.findElement(By.id("emailId"));
    inputEmail.sendKeys("s.apicella22@gmail.com");
    inputpassword= driver.findElement(By.id("passwordinput"));
    inputpassword.sendKeys("apicella22");
    confirm_password= driver.findElement(By.id("confirm_password"));
    confirm_password.sendKeys("apicella22");
    button=driver.findElement(By.id("submit"));
    button.click();
  }
}