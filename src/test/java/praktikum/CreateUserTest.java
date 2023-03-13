package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.out;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.notNullValue;
import static praktikum.User.getCorrectUser;


public class CreateUserTest {

    protected UserMethods userMethods;
    protected String accessToken;

    @Before
    public void setup() {
        userMethods = new UserMethods();
    }

    @After
    @Step("After test: to delete user")
    public void tearDownUser() {
        if (accessToken != null) {
            ValidatableResponse response = userMethods.deleteUser(accessToken.substring(7));
            out.println(response.extract().statusCode() == 200
                    ? "\nUser is deleted\n"
                    : "\nUser was not deleted\n"
            );
        }
    }

    @Test
    @Description("User creation test")
    @DisplayName("Check user: user has successfully created")
    @Step("User")
    public void testCreateUserPositive() {

        User user = getCorrectUser();

        // Получение ответа + Проверка
        ValidatableResponse response = userMethods.createUser(user);
        response.assertThat().statusCode(200).and().body(
                "success", equalTo(true),
                "user.name", equalTo(user.getName()),
                "user.email", equalToIgnoringCase(user.getEmail()),
                "accessToken", notNullValue(),
                "refreshToken", notNullValue()
        );


        accessToken = response.extract().path("accessToken");
    }
}
