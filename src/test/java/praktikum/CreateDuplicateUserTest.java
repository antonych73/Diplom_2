package praktikum;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static praktikum.User.getCorrectUser;

public class CreateDuplicateUserTest extends UserAndMethods {

    private final static int ERROR_CODE = 403;
    private final static String ERROR_MESSAGE = "User already exists";


    @Test
    @DisplayName("Check user creation test: " + ERROR_MESSAGE)
    @Step("User")
    public void testUserDuplicateNegative() {

        super.createUser(getCorrectUser());

        // Получение ответа + Проверка
        super.checkNegativeRespons(
                userMethods.createUser(user), // response
                ERROR_CODE,
                ERROR_MESSAGE);
    }
}
