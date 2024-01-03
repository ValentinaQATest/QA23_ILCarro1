package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    WebDriver wd;

    HelperUser helperUser;


    public void init(){
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app/");
        helperUser = new HelperUser(wd);

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void stop(){
        wd.quit();

    }

}
