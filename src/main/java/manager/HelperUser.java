package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){
      //  WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login?url=%2Fsearch']"));
      //  loginTab.click();
        click(By.xpath("//a[@href='/login?url=%2Fsearch']"));

    }

    public void fillLoginRegistrationForm(String email, String password){
        //WebElement emailInput = wd.findElement(By.xpath("//input[@id='email']"));
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys(email);

        type(By.xpath("//input[@id='email']"),email);

        //WebElement passwordInput = wd.findElement(By.xpath("//input[@id='password']"));
        //passwordInput.click();
        //passwordInput.clear();
        //passwordInput.sendKeys(password);
        type(By.xpath("//input[@id='password']"),password);

    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Y’alla!']"));
        click(By.xpath("//*[text()='Ok']"));

    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()='Logout']"));

    }


    public void logout() {
        click(By.xpath("//*[text()='Logout']"));
    }
}
