package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import static praktikum.User.*;

@RunWith(Parameterized.class)
public class CreateUserParameterizedTest extends UserAndMethods {

    private final static int ERROR_CODE = 403;
    private final static String ERROR_MESSAGE = "Email, password and name are required fields";

    private final User user;

    public CreateUserParameterizedTest(User user) {
        this.user = user;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {getWithoutName(EMPTY)},
                {getWithoutPassword(EMPTY)},
                {getWithoutEmail(EMPTY)}
        };
    }

    @Test
    @DisplayName("Check creation of user: " + ERROR_MESSAGE)
    @Description("It is impossible to create a user without login/password/email")
    public void testGetResponse() {

        // Получение ответа + Проверка
        super.checkNegativeRespons(
                userMethods.createUser(user),  // response
                ERROR_CODE,
                ERROR_MESSAGE);
     }
}
