package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("margo@gmail.com").withPassword("Mmar123456$"));

        }

    }

    @Test
    public void addNewCarSuccessfulAll(){
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-" +i)
                .price(50)
                .about("Very nice car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),
                car.getManufacture()+" "+car.getModel()+" added successful");

    }

@Test
    public void addNewCarSuccessfull(){
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-9ft0-" +i)
                .price(50)
                .about("Very nice car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),
                car.getManufacture()+" "+car.getModel()+" added successful");

    }

    public void addNewCarSuccess(){
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-" +i)
                .price(50)
                .about("Very nice car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto
                ("D:\\QA\\Automation\\My Projects (Git)\\QA23_ILCarro1\\02-bugatti-cd-nardo-testing.jpg");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),
                car.getManufacture()+" "+car.getModel()+" added successful");

    }

    @AfterMethod
    public void postConditions(){


    }
}