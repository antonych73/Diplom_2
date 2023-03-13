package praktikum;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static praktikum.UserCredentials.getUserCredentials;

@RunWith(Parameterized.class)
public class LoginUserParameterizedTest extends UserAndMethods {

    private final static int ERROR_CODE = 401;
    private final static String ERROR_MESSAGE = "email or password are incorrect";

    private final UserCredentials userCredentials;

    public LoginUserParameterizedTest(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {getUserCredentials(EMPTY, "test@yandex.ru")},
                {getUserCredentials("1234567890", EMPTY)},
                {getUserCredentials("1234567890", "test@yandex.ru")}
        };
    }

    @Test
    @DisplayName("Check login of user: " + ERROR_MESSAGE)
    @Description("It is impossible to user login without email/password")
    public void testGetResponse() {

        // Получение ответа + Проверка
        super.checkNegativeRespons(
                userMethods.loginUser(userCredentials),  // response
                ERROR_CODE,
                ERROR_MESSAGE);
    }
}
