import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProjectN {
    private static final String MYPROJECTNATALLIA_MAIN_PAGE_URL = "http://www.myprojectnatallia.com/";
    WebDriver driver;
    //1. Open a browser
    //2. Go to MyProjectNatallia main page
    //3. Complete the fields
    //4. Submit a message
    //5. Verify results page is appeared

    @Test
    public void test001() {
        openBrowser();
        goToMainPage();
        waitForSearchElementName();
        waitForSearchElementEmail();
        waitForSearchElementSubject();
        waitForSearchElementProject();
        completeFieldsName();
        completeFieldsEmail();
        completeFieldsSubject();
        completeFieldsProject();
        submitMessage();
        waitForElement();
        verifyResultsPage();
    }
    private void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers_Mac_OS/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    private void goToMainPage() {
        driver.get(MYPROJECTNATALLIA_MAIN_PAGE_URL);
    }
    private void waitForSearchElementName() {
        WebDriverWait wait = new WebDriverWait(driver, 20 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
    }
    private void waitForSearchElementEmail() {
        WebDriverWait wait = new WebDriverWait(driver, 20 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }
    private void waitForSearchElementSubject() {
        WebDriverWait wait = new WebDriverWait(driver, 20 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
    }
    private void waitForSearchElementProject() {
        WebDriverWait wait = new WebDriverWait(driver, 20 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    }
    private void completeFieldsName() {
        driver.findElement(By.id("name")).sendKeys("Catherine");
    }
    private void completeFieldsEmail() {
        driver.findElement(By.id("email")).sendKeys("catherine1990@gmail.com");
    }
    private void completeFieldsSubject() {
        driver.findElement(By.id("subject")).sendKeys("A new project is waiting for you!");
    }
    private void completeFieldsProject() {
        driver.findElement(By.id("message")).sendKeys("This project is about...");
    }
    private void submitMessage() {
        driver.findElement(By.id("submit")).submit();
    }
    private void waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, 20 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card")));
    }
    private void verifyResultsPage() {
        WebElement element = driver.findElement(By.id("card"));
        boolean displayed = element.isDisplayed();
        Assert.assertEquals(displayed, true);
    }
}
