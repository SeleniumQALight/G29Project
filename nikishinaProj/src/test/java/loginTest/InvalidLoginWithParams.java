package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


//укажем, что этот тест должен быть запущен с  - для этого перед тестом указываем аннотацию:
@RunWith(value = Parameterized.class)
public class InvalidLoginWithParams extends ParentTest {
    //теперь в самом классе указываем параметры, которые будем использовать в тесте (создаем переменные):
    String login, pass;

    // настраиваем эти переменные в конструкторе (для этого на имени класса клик, потом Alt+Insert -> constructor -> выбрать обе переменные -> Enter - конструктор готов
    public InvalidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

//    этот блок будет давать (возвращать) нам параметры в конструктор, который в свою очередь будет выполнять тест с каждым набором данных:
//    (name = "login ={0} pass = {1}") - это имя рана для параметрайз
    @Parameterized.Parameters (name = "login = {0}, pass = {1}")
    public static Collection testData () {
        return Arrays.asList(new Object[][]{
                {"Student", "11111"},
                {"", "11111"},
                {"11111", "909090"}
        });
    }

//    !!!!Обрати внимание: в данном тесте, если мы не

    @Test
    public void invalidLoginWithParams (){
        loginPage.loginUser(login, pass);
        Assert.assertFalse("User shouldn't be logged in", mainPage.isAvatarPresent());
    }
}
