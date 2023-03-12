package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static praktikum.User.getCorrectUser;

public class CreateOrderWithWrongIngredientsTest extends UserAndMethods {

    private final static int ERROR_CODE = 500;

    private OrderMethods orderMethods;

    @Before
    public void setup() {
        orderMethods = new OrderMethods();
        super.setup();
    }


    @Test
    @Description("Order creation with wrong ingredients test: error " + ERROR_CODE)
    public void testCreateOrderWithWrongIngredients() {

        super.createUser(getCorrectUser());

        // Формирование заказа c заведомо некорректными инградиентами
        Order order = new Order(asList("1x", "2y", "3z"));

        // Получение ответа + Проверка
        ValidatableResponse response = orderMethods.createOrder(order, accessToken.substring(7));
        response.assertThat().statusCode(ERROR_CODE);
    }
}
