package praktikum;

import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import static praktikum.User.getCorrectUser;

public class CreateOrderWithoutIngredientsTest extends UserAndMethods {

    private final static int ERROR_CODE = 400;
    private final static String ERROR_MESSAGE = "Ingredient ids must be provided";


    private OrderMethods orderMethods;

    @Before
    public void setup() {
        orderMethods = new OrderMethods();
        super.setup();
    }


    @Test
    @Description("Order creation test: " + ERROR_MESSAGE)
    public void testCreateOrderWithoutIngredientsNegative() {

        super.createUser(getCorrectUser());

        Order order = new Order();

        // Получение ответа + Проверка
        super.checkNegativeRespons(
                orderMethods.createOrder(order, accessToken.substring(7)), // response
                ERROR_CODE,
                ERROR_MESSAGE);
    }
}
