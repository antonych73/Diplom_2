package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.notNullValue;
import static praktikum.User.getCorrectUser;

public class LoginUserTest extends UserAndMethods {

    @Test
    @Description("User login test")
    @Step("User")
    public void testLoginUserPositive() {

        super.createUser(getCorrectUser());

        // Получение ответа + Проверка
        ValidatableResponse response = userMethods.loginUser(new UserCredentials(user.getPassword(), user.getEmail()));
        response.assertThat().statusCode(200).and().body(
                        "success", equalTo(true),
                        "user.name", equalTo(user.getName()),
                        "user.email", equalToIgnoringCase(user.getEmail()),
                        "accessToken", notNullValue(),
                        "refreshToken", notNullValue()
                );
    }
}
