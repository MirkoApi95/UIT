package seleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_1_2_4 {
  /**
   * 
   * @author Mirko
   * La calsse testa il login con password non corretta
   */
  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "D:\\Utenti\\Mirko\\Desktop\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("http://localhost:8080/UIT/HomePageViewGenerale.jsp");
    WebElement inputEmail;
    WebElement inputpassword;
    WebElement button;
    inputEmail= driver.findElement(By.id("emailId"));
    inputEmail.sendKeys("s.apicella99@studenti.unisa.it");
    inputpassword= driver.findElement(By.id("passwordinput"));
    inputpassword.sendKeys("");
    button=driver.findElement(By.id("entra"));
    button.click();
  }
}