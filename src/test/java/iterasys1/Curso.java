package iterasys1;
// 2 - Bibliotecas
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

// 3 - Classe
public class Curso{
    // 3.1 - Atributos
    WebDriver driver; // declarar o objeto Selenium WebDriver

    // 3.2 - Métodos e Funções
    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/96/chromedriver.exe");
        driver = new ChromeDriver(); // Instanciou o Selenium como Chrome
        driver.manage().window().maximize(); // Maximizar a janela do navegador
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @After
    public void finalizar(){
        //driver.quit();
    }

    @Test
    public void consultarMantis(){

        // Página Inicial
        driver.get("https://www.iterasys.com.br");
        driver.findElement(By.id("searchtext")).click(); // clicar na caixa de pesquisa
        driver.findElement(By.id("searchtext")).clear(); // limpar a caixa de pesquisa
        // localizar a caixa de pesquisa, digitar Mantis letra por letra e apertar o Enter
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis") + Keys.ENTER);

        // Página de Lista de Produto
        driver.findElement(By.cssSelector("a.cc-btn.cc-dismiss")).click(); // Clicou no Ok da LGPD
        driver.findElement(By.cssSelector("span.comprar")).click(); // Clicar em Matricule-se

        // Página de Detalhes do Produto
        assertEquals("Mantis", driver.findElement(By.cssSelector("span.item-title")).getText());
        assertEquals("R$ 59,99", driver.findElement(By.cssSelector("span.new-price")).getText());

    }

    // Hora do Café
    // Voltamos 20h40

}

