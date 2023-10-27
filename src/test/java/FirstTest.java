import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import org.testng.asserts.SoftAssert;

public class FirstTest {

    WebDriver driver = null;

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWiki () {
        String driverPath = "/Users/gabri/OneDrive/Documentos/Gabriel/1-Cursos/1-EggGlobantQA/001-ProjectsEGG/WebAutomation/Prueba01/src/utils/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();    //abre el navegador

        driver.navigate().to("https://www.wikipedia.org");  //abre la pagina

        WebElement searchInput = driver.findElement(By.id("searchInput")); //al buscar por ID no va nada adelante
        WebElement footerlink = driver.findElement(By.cssSelector(".footer-sidebar-text + div.footer-sidebar-text"));

        searchInput.sendKeys("Selenium");

        //Assert.assertEquals(footerLink.getText(), "Puedes apoyar nuestro trabajo con una donación.");

        List<WebElement> lang_list = driver.findElements(By.className("central-featured-lang"));
        softAssert.assertEquals(lang_list.size(), 9);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> lang_list2 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(
                        "central-featured-lang")));

        WebElement submitBtn = driver.findElement(By.cssSelector("button[type=\"submit\"]"));   //no le coloco ., porque es un button class????

        softAssert.assertTrue(submitBtn.isDisplayed()); //se fija si el boton existe antes de dar click
        submitBtn.click();  //le da click a la lupita y pasa a la pag de selenium

        softAssert.assertAll();

        driver.close();
    }
}
