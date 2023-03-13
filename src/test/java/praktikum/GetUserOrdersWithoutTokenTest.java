package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetUserOrdersWithoutTokenTest {

    private final static int ERROR_CODE = 401;
    private final static String ERROR_MESSAGE = "You should be authorised";
    private OrderMethods orderMethods;

    @Before
    public void setup() {
        orderMethods = new OrderMethods();
    }

    @Test
    @Description("Order list test")
    public void testCreateOrderPositive() {

        // Получение ответа + Проверка
        ValidatableResponse response = orderMethods.getUserOrders(EMPTY);

        response.assertThat().statusCode(ERROR_CODE).and().body(
                "success", equalTo(false),
                "message", equalTo(ERROR_MESSAGE)
        );

    }
}