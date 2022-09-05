package robins.galenskaper.main.problem2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class Problem2 {

    public static void getAllLinks(String url){
        try{
            //Telling the program where the geckodriver is located
            System.setProperty("webdriver.gecko.driver", "classes/geckodriver.exe");

            //Setting headless options, so that a browser window does not pop up
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(firefoxBinary);
            options.setHeadless(true);

            //Starting the driver
            WebDriver driver = new FirefoxDriver(options);

            //Going to the given website
            driver.get(url);

            //Geting a list web elements(specifically links) by looking for the "a" tag
            List<WebElement> links = driver.findElements(By.tagName("a"));

            //For every link in the list, print the link itself, and the text its disguised as
            for(WebElement link:links){
                System.out.println(link.getAttribute("href") + " " + link.getText());
            }

            //After finding and printing all the links, we are finished
            driver.quit();
        }
        //When firefox has not been installed, this error pops up
        catch (org.openqa.selenium.SessionNotCreatedException e){
            e.printStackTrace();
            System.out.println("Firefox not installed");
            System.out.println("I'm new to Selenium so I'm sorry if it was expected to do this without Mozilla installed\n");
        }
        //When entering an incorrect link, this is the error that pops up
        catch (org.openqa.selenium.InvalidArgumentException e){
            e.printStackTrace();
            System.out.println("Please only enter a valid URL\n");
        }
        //If this happens, I'm in pain
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Something sure went wrong");
        }
    }

}
