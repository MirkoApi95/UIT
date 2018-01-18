package seleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_1_3_4 {

  public static void main(String[] args) {
    /**
     * Classe per testare la modifica della password, l'utente non inserisce la consegna
     */
    System.setProperty("webdriver.chrome.driver", "D:\\Utenti\\Mirko\\Desktop\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.get("http://localhost:8080/UIT/HomePageViewGenerale.jsp");
    WebElement inputEmail;
    WebElement inputpassword;
    WebElement button;
    WebElement menu;
    menu= driver.findElement(By.id("log"));
    menu.click();
    inputEmail= driver.findElement(By.id("emailId"));
    inputEmail.sendKeys("s.apicella22@studenti.unisa.it");
    inputpassword= driver.findElement(By.id("passwordinput"));
    inputpassword.sendKeys("apicella22");
    button=driver.findElement(By.id("entra"));
    button.click();
  
    try {
      Thread.sleep(7000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  
    driver.get("http://localhost:8080/UIT/AccountView.jsp");
    WebElement inputpassword1;
    WebElement inputnewpassword1;
    WebElement button1 = null;

    inputpassword1= driver.findElement(By.id("passwordinput"));
    inputpassword1.sendKeys("apicella22");
    inputnewpassword1= driver.findElement(By.id("confirm_password"));
    inputnewpassword1.sendKeys("");
    button1=driver.findElement(By.id("confermapassword"));
    button1.click();
  }
}
