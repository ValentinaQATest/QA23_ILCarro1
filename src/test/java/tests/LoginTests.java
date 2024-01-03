package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginSuccess(){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm("vlnt@gmail.com", "Vt1,f3_Ah$");
       app.getHelperUser().submitLogin();

       //Aseert


    }

}
