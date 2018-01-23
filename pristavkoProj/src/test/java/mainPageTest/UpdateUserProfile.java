package mainPageTest;
/**
 * Test Case 3 - Обновление данных в профиле пользователя
 * <p>
 * Steps to reproduce:
 * 1) Открыть ссылку http://v3.test.itpmgroup.com/
 * 2) В форме авторизации в поле пароль ввести Student
 * 3) В поле пароль ввести 909090
 * 4) Кликнуть на кнопку "Вход"
 * 5) Кликнуть на аватарку пользователя в правом верхнем углу страницы
 * 6) Кликнуть на кнопку "Профиль"
 * 7) В поле "Адрес email" ввести значение alex@bigmir.net
 * в поле "Пользователь" ввести значение StudentAlex
 * 8) Кликнуть на кнопку "Сохранить"
 * 9) Кликнуть на аватарку профиля пользователя
 * 10) Кликнуть на кнопку Выйти
 * 11) В поле пароль ввести 909090
 * 12) Кликнуть на кнопку "Вход"
 * 13) Кликнуть на аватарку пользователя в правом верхнем углу страницы
 * 14) Кликнуть на кнопку "Профиль"
 * <p>
 * Expected result:
 * 1) В левом верхнем углу страницы обновилось название пользователя на StudentAlex.
 * 2) В профиле обновилось значения для поля "Адрес email" на alex@bigmir.net
 * 3) В профиле обновилось значения для поля "Пользователь" на StudentAlex
 */

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

public class UpdateUserProfile extends ParentTest {

    final String userEmail = "alex@bigmir.net";
    final String userName = "StudentAlex";

    @Test
    public void updateUserProfile() {

        loginPage.loginUser(configProperties.user_login(), configProperties.user_password());
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
        Assert.assertTrue("Menu is not present", mainPage.isMenuItemsPresent());
        userProfile.openUserProfile();
        userProfile.updateUserProfile(userEmail, userName);
        mainPage.userLogOut();
        loginPage.loginUser(configProperties.user_login(), configProperties.user_password());
        userProfile.openUserProfile();
        waitTimeWhenLoadingPage.WaitTimeWhenLoadingPage();
        userProfile.checkUpdateUserInfo(userEmail, userName);
    }
}