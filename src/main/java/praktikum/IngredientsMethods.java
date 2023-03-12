package praktikum;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static praktikum.RestSpecBuilderUtils.getBaseSpec;

public class IngredientsMethods {

    public final static String INGREDIENTS_PATH = "api/ingredients";

    @Step("Get ingredients")
    public ValidatableResponse getIngredients() {
        return given().spec(getBaseSpec())
                .when().get(INGREDIENTS_PATH)
                .then().log().all();
    }
}