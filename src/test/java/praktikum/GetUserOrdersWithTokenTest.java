package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static praktikum.User.getCorrectUser;

public class GetUserOrdersWithTokenTest extends UserAndMethods{

    private OrderMethods orderMethods;
    private Ingredients ingredients;

    @Before
    public void setup() {
        orderMethods = new OrderMethods();
        ingredients = new Ingredients();
        super.setup();
    }

    @Test
    @Description("Order list test")
    public void testCreateOrderPositive() {

        super.createUser(getCorrectUser());

        orderMethods.createOrder(
                new Order(ingredients.getIngredientsRandom()),
                accessToken.substring(7)).assertThat().statusCode(200);

        // Получение ответа + Проверка
        ValidatableResponse response = orderMethods.getUserOrders(accessToken.substring(7));

        response.assertThat().statusCode(200).and().body(
                "success", equalTo(true),
                "orders", notNullValue(),
                "orders._id", notNullValue(),
                "orders.ingredients", notNullValue(),
                "orders.status", notNullValue(),
                "orders.name", notNullValue(),
                "orders.createdAt", notNullValue(),
                "orders.updatedAt", notNullValue(),
                "orders.number", notNullValue(),
                "total", notNullValue(),
                "totalToday", notNullValue());
    }
}
