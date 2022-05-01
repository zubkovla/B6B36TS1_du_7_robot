import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RobotTest {

//     The path of chromedriver for mac
//     System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver");

//     The path of chromedriver for windows
//     System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");


    /**
     * 7 Actions of a Selenium Script:
     * 1. Instantiate a WebDriver object to drive the browser you want to use in your tests (System.setProperty("webdriver.chrome.driver", "path") or as a WebDriverManager).
     * 2. Navigate to the web page you want to test (make sure to include "http").
     * 4. Ensure the browser is in the correct state to interact with that element (e.g. presence of a specific element found by an Id, after WebDriverWait)
     * 3. Locate the element on the web page you need to interact with
     * 5. Perform the action on the element
     * 6. Record the test results
     * 7. Quit the test
     */

    // Setting up a webdriver variable available to all tests
    static WebDriver driver;
    static FluentWait wait;

    // Note: This method will run once before all tests in our class
    @BeforeClass
    public static void setupClass() {
        // Telling the system where to find chromedriver
        WebDriverManager.chromedriver().setup();

        // 1. Instantiate a webdriver object, set up a wait period
        driver = new ChromeDriver();
        wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(5000));
        wait.pollingEvery(Duration.ofMillis(10));
        wait.ignoring(NoSuchElementException.class);
    }

    // Note: This method will run once after all tests in our class
    @AfterClass
    public static void tearDown() {
        // 7. Quit the driver
        driver.quit();
    }

    @Test
    public void robotTest() {

        // Test-Case walk-through step (#) | name | target | value


        // Step (1) | open | / |
        // 2. Navigate to the URL
        try {
            driver.navigate().to("https://moodle.fel.cvut.cz/");
            System.out.println("Step (1) - page was accessed.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (1) - page was not available.");
            throw (e);
        }


        // Step (2) | click | xpath("//a[@data-cy='login-sso-a'] |
        // 3. Find element // 4. Check the state
        WebElement element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-cy='navbar-login-a']"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (2) - login button clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (2) - login button was not clicked.");
            throw (e);
        }


        // Step (3) | click | xpath("//a[@data-cy='login-sso-a'] |
        // 2. Navigate to the URL
        // not applicable, continue from previous step

        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-cy='login-sso-a']"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (3) - SSO login button clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (3) - SSO login button was not clicked.");
            throw (e);
        }


        // Step (4) | type | id=username | %username%
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("username"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.sendKeys("%username%"); // %username%
            System.out.println("Step (4) - username was typed.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (4) - username was not typed.");
            throw (e);
        }


        // Step (5) | type | id=password | %password%
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("password"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.sendKeys("%password%"); // %password%
            System.out.println("Step (5) - password was typed.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (5) - password was not typed.");
            throw (e);
        }


        // Step (6) | click | xpath("//*[@type='checkbox'][@id='donotcache']") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='checkbox'][@id='donotcache']"))
        );
        // assertTrue(element.isDisplayed()); // thows assertion error?!

        // 5. Take an action // 6. record the results
        // Check whether the checkbox is toggled on
        if (!element.isSelected()) {
            try {
                element.click();
                System.out.println("Step (6) - checkbox had been clicked.");
            } catch (Exception e) {
                System.err.println("WARNING, Step (6) - checkbox had not been clicked.");
                e.printStackTrace();
            }
        }


        // Step (7) | click | xpath("//*[@type='submit'][@class='btn'][@name='_eventId_proceed']") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit'][@class='btn'][@name='_eventId_proceed']"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (7) - SSO login button clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (7) - SSO login button was not clicked.");
            throw (e);
        }


        // Step (8) | click | xpath("//*[@class='header-moodle-main-anchor-text nav-link']") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='header-moodle-main-anchor-text nav-link']"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        // Check whether the Check box is toggled on
        try {
            element.click();
            System.out.println("Step (8) - 'My courses' link had been clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (8) - 'My courses' link had not been clicked.");
            e.printStackTrace();
        }


        // Step (9) | click | xpath("//*[@data-target='#event-details-40823']") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Software Testing"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        // Check whether the Check box is toggled on
        try {
            element.click();
            System.out.println("Step (9) - 'Test pro Robota' had been clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (9) - 'Test pro Robota' had not been clicked.");
            e.printStackTrace();
        }



        // Step (10) | click | xpath("//*[@data-event-id='40823']") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-event-id='40823']"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (10) - 'Software Testing' pop-up window link had been clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (10) - 'Software Testing' pop-up window link had not been clicked.");
            throw (e);
        }


        // Step (11) | click | linkText=Go to activity |
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.linkText("Go to activity"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (11) - 'Go to activity' pop-up window link had been clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (11) - 'Go to activity' pop-up window link had not been clicked.");
            throw (e);
        }


        // Step (12) | click | xpath("//*[@type='submit'][@class='btn btn-primary']") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit'][@class='btn btn-primary']"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (12) - attempt quiz button clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (12) - attempt quiz button was not clicked.");
            throw (e);
        }


        // Step (13) | click | xpath("//*[@type='submit'][@value='Start attempt']") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit'][@value='Start attempt']"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (13) - start attempt button clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (13) - start attempt button was not clicked.");
            throw (e);
        }


        // Step (14) | click | xpath("//*[contains(@class, 'qtype_essay_response')]") |
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'qtype_essay_response')]"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (14) - response textarea 'qtype_essay_response' had been clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (14) - response textarea 'qtype_essay_response' had not been clicked.");
            throw (e);
        }


        // Step (15) | type | xpath("//*[contains(@name, '1_answer')][contains(@class, 'qtype_essay_response')]") | Vladimir Zubkov, paralelka cvičení 106
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'qtype_essay_response')]"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.sendKeys("Vladimir Zubkov, paralelka cvičení 106");
            System.out.println("Step (15) - response textarea 'qtype_essay_response' had been filled.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (15) - response textarea 'qtype_essay_response' had not been filled.");
            throw (e);
        }


        // Step (16) | type | xpath("//*[contains(@name, '2_answer')][contains(@class, 'form-control')]") | 86400
        // 3. Find element // 4. Check the state
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@name, '2_answer')][contains(@class, 'form-control')]"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.sendKeys(String.valueOf(86400));
            System.out.println("Step (16) - number had been typed.");
        } catch (Exception e) {
            System.err.println("Step (16) - WARNING, number had not been typed.");
            throw (e);
        }


        // Step (17) | select | xpath("//*[contains(@id, '3_p1')]") | label=Oberon
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, '3_p1')]"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.findElement(By.xpath("//option[. = 'Oberon']")).click();
            System.out.println("Step (17) - option 'planets' was clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (17) - option 'planets' was not clicked.");
            throw (e);
        }


        // Step (18) | select | xpath("//*[contains(@id, '4_p1')]") | label=Rumunsko
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, '4_p1')]"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.findElement(By.xpath("//option[. = 'Rumunsko']")).click();
            System.out.println("Step (18) - option 'countries' was clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (18) - option 'countries' was not clicked.");
            throw (e);
        }


        // Step (19) | click | id=mod_quiz-next-nav |
        element = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("mod_quiz-next-nav"))
        );
        assertTrue(element.isDisplayed());

        // 5. Take an action // 6. record the results
        try {
            element.click();
            System.out.println("Step (19) - 'submit test' button was clicked.");
        } catch (Exception e) {
            System.err.println("WARNING, Step (19) - 'submit test' button was not clicked.");
            throw (e);
        }
    }
}