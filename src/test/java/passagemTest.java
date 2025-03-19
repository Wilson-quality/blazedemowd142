// Primeiro tem as blibliotecas (imports) arquivo pom.xml
// Depois vem as classes
//Dentro da classe, atributos da classe e Funções e Métodos.
//Métodos somente são executados e não tem nenhum retorno.
//Classes são executadas e devolvem algum retorno/resultado.


//Bibliotecas e Imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Fim das Bibliotecas e Imports

//Inicio Classe passagemTest
public class passagemTest {

//atributos
private WebDriver driver; //objeto do Selenium

// Funções  e Métodos

//Antes do Teste @BeforeEach (Antes de cada teste) @BeforeAll (Antes de todos os testes)
@BeforeEach 
//void =método
//() paretenses após a função "iniciar" está recebendo dados, no meio do código sem ser após uma função está enviado dados.
public void iniciar () {
driver  = new ChromeDriver(); // Instanciar o objeto do Selenium com o ChromeDriver
driver.manage().window().maximize(); //Maximiza a janela do Browser

}

// Depois do Teste
@AfterEach 
public void finalizar(){
    driver.quit(); // Destroi o objeto do Selenium

}

//Teste1 
@Test
public void comprarPassagem() {
    driver.get("https://www.blazedemo.com"); //Abre a o site

    
    //Formas de pegar o elemento do melhor pro pior (Datatest, ID, name, css-selector [primeira palavra da classe.e o que está dentro da classe
    // <select name="fromPort" class="form-inline"> ] Exemplo: select.form-inline, Xpacth)


    //Escolher a origem - combo origiem - INICIO
    driver.findElement(By.name("fromPort")).click(); //o .click clica no combo
    {
       //Encontra a opção desejada na lista
            WebElement comboorigem = driver.findElement(By.name("fromPort"));
     
            //aguarda a página carregar
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromPort")));
            
            comboorigem.findElement(By.xpath("//option[. = 'São Paolo']")).click(); //clica no elemento escolhido
     
            
    }  //Escolher a origem - combo origem - FIM

    {
       //Escolher o destino - combo destino - INICIO
        WebElement combodestino = driver.findElement(By.name("toPort"));
        combodestino.findElement(By.xpath("//option [.='London']")).click();
        //Clicar no botão Encontrar voos
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

       
    }   //Escolher o destino - combo destino - INICIO

    {        
       //Transição de Página - Esolher Voo
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.urlContains("reserve"));

        //Clicar no botão Escolher voo
        driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();


    }
    { //Preencher verificar se está na página de pagamento
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("purchase"));
        assertEquals("https://www.blazedemo.com/purchase.php",driver.getCurrentUrl());

        //Preencher dados do passageiro e pagamento
        driver.findElement(By.id("inputName")).sendKeys("");
        driver.findElement(By.id("address")).sendKeys("123 alpha street");
        driver.findElement(By.id("city")).sendKeys("Goiania");
        driver.findElement(By.id("state")).sendKeys("Goias");
        driver.findElement(By.id("zipCode")).sendKeys("74123000");
        {
            WebElement dropdown = driver.findElement(By.id("cardType"));
            dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
     
        driver.findElement(By.id("creditCardNumber")).sendKeys("10102020");
        driver.findElement(By.id("creditCardMonth")).sendKeys("1");
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        driver.findElement(By.id("nameOnCard")).sendKeys("JWLJ");



        // Valida se o elemento não é nulo


       WebElement myInput = driver.findElement(By.id("inputName"));assertNotNull( myInput,"O campo de input de texto é nulo!");
           System.out.println("O campo de input foi encontrado!");

        // Verifica se o campo está vazio  // Se inputValue for null, substitui por uma string vazia
        String inputValue =  myInput.getDomAttribute("value");
        if (inputValue == null) {
            inputValue = "";
        }
        assertTrue( inputValue.isEmpty(),"O campo de input deveria estar vazio, mas não está!");
        System.out.println("O campo de input está vazio!");
  
       
             // Verificação se o campo está vazio
        assertTrue(inputValue.isEmpty(), "O campo de input deveria estar vazio, mas não está!");
        System.out.println("O campo de input está vazio!");


        //Clicar no botão Escolher voo
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

       
    { 
        
        //Preencher verificar se está na página finalização
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.urlContains("confirmation"));
        assertEquals("https://www.blazedemo.com/confirmation.php",driver.getCurrentUrl());
        System.out.println("Fim da compra de Passagem");
    
        
        
        
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofMinutes(5)); // Tempo máximo de espera
            System.out.println("Mensagem encontrada! Pausando até que ela desapareça...");

        // Aguarda até que o elemento não esteja mais visível
            wait4.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("h1")));
            System.out.println("Mensagem desapareceu, continuando o teste...");
       
 

    }

}

 
 
 }
 
 
 } //Fim  Classe passagemTest

    

