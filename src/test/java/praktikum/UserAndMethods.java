package praktikum;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;

import static java.lang.System.out;
import static org.hamcrest.CoreMatchers.equalTo;

/*
Выделение общих методов в отдельный наследуемый класс
 */
public class UserAndMethods {

    User user;

    UserMethods userMethods;
    String accessToken;

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

    void createUser(User user) {
        this.user = user;
        this.accessToken = userMethods.createUser(user).assertThat().statusCode(200).and().extract().path("accessToken");
    }

    void checkNegativeRespons(ValidatableResponse response,
                              int error_code,
                              String error_message) {
        response.assertThat().statusCode(error_code).and().body(
                "success", equalTo(false),
                "message", equalTo(error_message)
        );
    }

}
