package praktikum;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static praktikum.RestSpecBuilderUtils.getBaseSpec;

public class OrderMethods {

    private final static String ORDERS_PATH = "api/orders/";

    @Step("Create order")
    public ValidatableResponse createOrder(Order order,
                                           String accessToken) {
        return given().spec(getBaseSpec())
                .auth().oauth2(accessToken)
                .body(order)
                .when().post(ORDERS_PATH)
                .then().log().all();
    }

    @Step("Get user orders")
    public ValidatableResponse getUserOrders(String accessToken) {
        return given().spec(getBaseSpec())
                .auth().oauth2(accessToken)
                .when().get(ORDERS_PATH)
                .then().log().all();
    }

}