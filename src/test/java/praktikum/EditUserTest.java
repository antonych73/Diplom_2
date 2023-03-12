package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static praktikum.User.getCorrectUser;

public class EditUserTest extends UserAndMethods {

    @Test
    @Description("User edit test")
    @DisplayName("Check user: user has successfully edited")
    @Step("User")
    public void testEditUserPositive() {

        super.createUser(getCorrectUser());

        User nowUser = getCorrectUser();

        // Получение ответа + Проверка
        ValidatableResponse response = userMethods.editUser(nowUser, accessToken.substring(7));
        response.assertThat().statusCode(200).and().body(
                "success", equalTo(true),
                "user.name", equalTo(nowUser.getName()),
                "user.email", equalToIgnoringCase(nowUser.getEmail())
        );
    }
}

