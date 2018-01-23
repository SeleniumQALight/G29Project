package mainPageTest;

import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

/**
 * Test Case 4 - Создание Аппарата
 * Preoconditions:
 * 1) Открыть ссылку http://v3.test.itpmgroup.com/
 * 2) В форме авторизации в поле пароль ввести Student
 * 3) В поле пароль ввести 909090
 * 4) Кликнуть на кнопку "Вход"
 * 5) Кликнуть на пункт меню "Словари"
 * 6) Кликнуть на пункт меню "Аппарат"
 * 7) Проверить, что в списке аппаратов нету аппарата с такими характеристиками:
 * Номер: АА6541PI
 * Комментарий: Не трогать этот аппарат
 * 8) Если есть, то удалить аппарат
 * <p>
 * Steps to reproduce:
 * 1) Открыть ссылку http://v3.test.itpmgroup.com/
 * 2) В форме авторизации в поле пароль ввести Student
 * 3) В поле пароль ввести 909090
 * 4) Кликнуть на кнопку "Вход"
 * 5) Кликнуть на пункт меню "Словари"
 * 6) Кликнуть на пункт меню "Аппарат"
 * 7) Кликнуть на кнопку добавления +
 * 8) В поле Apparat number ввести данные - АА6541PI
 * 9) В поле Apparat comment ввести данные - Не трогать этот аппарат
 * 10) Кликнуть на кнопку Создать
 * <p>
 * Expected result:
 * 1) В списке аппаратов должен быть аппарат с такими характеристиками:
 * Номер: АА6541PI
 * Комментарий: Не трогать этот аппарат
 */

public class CreateNewApparat extends ParentTest {

    final String apparatNumber = "АА6541PI";
    final String apparatComment = "Не трогать этот аппарат";

    @Test
    public void createNewApparat() {
        loginPage.validUserLogin(configProperties.user_login(), configProperties.user_password());
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnsubMenuApparat();
        mainPage.deleteAllApparatWhenTheyArePresent(apparatComment);
        mainPage.createNewApparat(apparatNumber, apparatComment);
        mainPage.checkNewApparatCreation(apparatComment);
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnsubMenuApparat();
        mainPage.deleteApparat(apparatComment);
    }
}