package Test;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    HomePage homePage;

    @BeforeTest
    public void beforeTest(){
        String driverPath = "/Users/gabri/OneDrive/Documentos/Gabriel/1-Cursos/1-EggGlobantQA/001-ProjectsEGG/WebAutomation/Prueba01/src/utils/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();    //abre el navegador
    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver, "https://www.wikipedia.org" );
        return homePage;
    }




}
