package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {


    @BeforeMethod
    public void preConditions() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(System.currentTimeMillis());
        int z = (int)System.currentTimeMillis()/1000%3600;
        User user = new User()
                .withFirstName("Lora")
                .withLastName("Snow")
                .withEmail("snow"+z+"@gmail.com")
                .withPassword("Ssnow9876542$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }

    @Test
    public void registrationEmptyName(){
        User user = new User()
                .withFirstName("")
                .withLastName("Simpson")
                .withEmail("simpson@gmail.com")
                .withPassword("Simp562671$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }
    @Test
    public void registrationWrongEmail() {
        User user = new User()
                .withFirstName("Gomer")
                .withLastName("Simpson")
                .withEmail("simpsongmail.com")
                .withPassword("Simp562671$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        @Test
        public void registrationWrongPassword () {
            User user = new User()
                    .withFirstName("Gomer")
                    .withLastName("Simpson")
                    .withEmail("simpson@gmail.com")
                    .withPassword("Simp562");
            app.getHelperUser().openRegistrationForm();
            app.getHelperUser().fillRegistrationForm(user);
            app.getHelperUser().checkPolicyXY();
            app.getHelperUser().submit();
            Assert.assertTrue(app.getHelperUser().getErrorText().contains("Password wrong "));
            Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());


        }


        @AfterMethod
        public void postConditions() {
            app.getHelperUser().clickOkButton();
        }


    }