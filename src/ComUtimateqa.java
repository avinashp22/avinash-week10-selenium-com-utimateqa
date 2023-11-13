/**
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ComUtimateqa {

    static String browser = "chrome"; // choose browser
    static WebDriver driver; // declare globally

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        String baseURL = "https://courses.ultimateqa.com/"; // set base url
        driver.get(baseURL);  // get base url
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //give implicit wait to driver

        System.out.println(driver.getTitle()); // print tile
        System.out.println(driver.getCurrentUrl()); // print current url
        System.out.println(driver.getPageSource()); // print page source

        WebElement signinLink = driver.findElement(By.linkText("Sign In")); // hover to login button
        signinLink.click(); // click on link
        System.out.println(driver.getCurrentUrl()); // print current url

        WebElement email = driver.findElement(By.id("user[email]"));    //find email field and enter email by ID
        email.sendKeys("avi@patel.com");   // type into box, action

        WebElement password = driver.findElement(By.id("user[password]"));       //find password field and enter password by ID
        password.sendKeys("Halllo123");    // type into box, action

      //NOT WORKING -   WebElement loginLink = driver.findElement(By.linkText("Sign in")); // hover to login button
       //NOT WORKING -  loginLink.click(); // click on link

        //NOT WORKING -   WebElement loginLink = driver.findElement(By.className("button button-primary g-recaptcha")); // hover to login button
        //NOT WORKING -   loginLink.click(); // click on link

        //NOT WORKING -     WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"sign_in_894c356c61\"]/div[5]/button")); // hover to login button
        //NOT WORKING -     loginLink.click(); // click on link

       WebElement loginLink = driver.findElement(By.partialLinkText("Sign")); // hover to login button
       loginLink.click(); // click on link


        driver.navigate().to(baseURL); // tell driver to navigate to base url

        driver.navigate().forward();// go forward to homepage
        driver.navigate().back(); // go back a page to base url page
        driver.navigate().refresh(); // refresh url

        driver.quit();  // close browser
    }
}
