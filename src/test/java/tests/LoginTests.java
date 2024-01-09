package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess1(){
        User user = new User().setEmail("vlnt@gmail.com").setPassword("Vt1,f3_Ah$");
        //=User user = new User().withEmail("vlnt@gmail.com").withPassword("Vt1,f3_Ah$");
       // user.setEmail("vlnt@gmail.com");
        //user.setPassword("Vt1,f3_Ah$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }


    @Test
    public void loginSuccess(){
       app.getHelperUser().openLoginForm();
       app.getHelperUser().fillLoginForm("vlnt@gmail.com", "Vt1,f3_Ah$");
       app.getHelperUser().submit();
       Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
       app.getHelperUser().clickOkButton();
    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vlnt@gmail.com", "Vt1,f3_Ah$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }

    public void loginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("vlnt@gmail.com", "Vt1,f3_Ah$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }








    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }
}
