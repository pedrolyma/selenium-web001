import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class driver {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "d:\\testes selenium\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.casasbahia.com.br");

 //       WebElement caixaDeBusca = driver.findElement(By.id("strBusca"));
        driver.findElement(By.id("strBusca")).sendKeys("Panela");  // fazer direto
        driver.findElement(By.id("btnOK")).click();
        WebElement resultadoPesquisa = driver.findElement(By.className("nm-product-name"));
        String resultado = resultadoPesquisa.getText();
        resultado = resultado.toLowerCase();

        if (resultado.contains("panela") || resultado.contains("pressao")) {
            System.out.println("Sucesso");
        } else {
            System.out.println("Erro na pesquisa");
            System.out.println("O Resultado Foi " + resultado);
        }
        driver.close();
    }
}
