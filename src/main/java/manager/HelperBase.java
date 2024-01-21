package manager;

import org.openqa.selenium.*;




public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        if (text != null) {
            element.sendKeys(text);
        }

    }

    public void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void submit() {
        wd.findElement(By.xpath("//button[@type='submit']"))
                .click();
    }

    public String getMessage() {

//        WebElement el = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = el.getText();
//        return text;
        //pause(5000);

        return
                wd.findElement(By.cssSelector(".dialog-container>h2"))
                        .getText();

    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }







}