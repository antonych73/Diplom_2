package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static praktikum.User.getCorrectUser;

public class EditUserWithoutTokenTest extends UserAndMethods {

    private final static int ERROR_CODE = 401;
    private final static String ERROR_MESSAGE = "You should be authorised";


    @Test
    @Description("User edit test: " + ERROR_MESSAGE)
    @Step("User")
    public void testEditUserPositive() {

        super.createUser(getCorrectUser());

        User nowUser = getCorrectUser();

        // Получение ответа + Проверка
        super.checkNegativeRespons(
                userMethods.editUser(nowUser, EMPTY),    // response
                ERROR_CODE,
                ERROR_MESSAGE);
    }
}
