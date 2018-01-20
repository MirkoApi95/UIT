package seleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_1_2_3 {

  public static void main(String[] args) {
    /**
     * 
     * @author Mirko
     * La calsse testa il login con password non corretta
     */
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Salvatore\\Desktop\\SELENIUM\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("http://localhost:8080/UIT/HomePageViewGenerale.jsp");
    WebElement inputEmail;
    WebElement inputpassword;
    WebElement button;
    WebElement menu;
    menu= driver.findElement(By.id("log"));
    menu.click();
    inputEmail= driver.findElement(By.id("emailId"));
    inputEmail.sendKeys("s.apicella99@studenti.unisa.it");
    inputpassword= driver.findElement(By.id("passwordinput"));
    inputpassword.sendKeys("aiella22");
    button=driver.findElement(By.id("entra"));
    button.click();
  }
}
