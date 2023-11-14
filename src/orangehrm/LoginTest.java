package orangehrm;
/*
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    public static void main(String[] args) throws InterruptedException {

        //setup browser
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl); // open the URL into browser
        //maximise browser
        driver.manage().window().maximize();
        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //print title of the page
        System.out.println(driver.getTitle());
        //print the current url
        System.out.println(driver.getCurrentUrl());
        //print the page source
        System.out.println(driver.getPageSource());
        Thread.sleep(4000);

        //click on forgot your password link
        WebElement forgotPswd = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPswd.click();
        Thread.sleep(4000);

        // print current url
        System.out.println(driver.getCurrentUrl());

        //navigate back to login page
        driver.navigate().back();

        //refresh the page
        driver.navigate().refresh();

        //enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");
        Thread.sleep(4000);

        //find password field and type password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        Thread.sleep(4000);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(4000);


        driver.quit();

    }

}
