import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zen.com.tn");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.name("menu-toggle")).click();
        WebElement enfantElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'list-item') and .//span[text()='ENFANT']]")));
        enfantElement.click();
        WebElement bebeFilles = driver.findElement(By.cssSelector("li.menu-item div.menu-item-data span"));
        if (bebeFilles.getText().equals("BÉBÉS FILLES")) {
            bebeFilles.click();
        }
        driver.findElement(By.name("T-shirt")).click();
        WebElement tshirtElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("T SHIRT MANCHE")));
        tshirtElement.click();

        WebElement colorByImage = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//img[contains(@src, 'https://images.zen.com.tn/medias/folder_25_09_2024/8_U2_A2997aa_25a0fa3d44.webp')]")));
        colorByImage.click();

        WebElement selectedColorDiv = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'item-colors-selected')]")));
        if (selectedColorDiv.getAttribute("class").contains("item-colors-selected")) {
            System.out.println("La couleur a bien été sélectionnée.");
        } else {
            System.out.println("La couleur n'a pas été sélectionnée.");
        }

        WebElement size36M = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()=' 36M ']/parent::div")));
        size36M.click();
        driver.findElement(By.className("default-btn")).click();
        WebElement continueElement = driver.findElement(By.xpath("//button[text()='Continuer mes achats']"));
        continueElement.click();
        driver.findElement(By.name("Panier")).click();
        try {
            WebElement tshirtTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='T SHIRT MANCHE']")));
            System.out.println("Le titre 'T SHIRT MANCHE' est bien visible dans le panier. test OK");
        } catch (Exception e) {
            System.out.println("Le titre 'T SHIRT MANCHE' n'existe pasdans le panier. test KO");
        }

        driver.quit();
    }
}