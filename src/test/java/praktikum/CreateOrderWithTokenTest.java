package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static praktikum.User.getCorrectUser;

public class CreateOrderWithTokenTest extends UserAndMethods {

    private OrderMethods orderMethods;
    private Ingredients ingredients;


    @Before
    public void setup() {
        orderMethods = new OrderMethods();
        ingredients = new Ingredients();
        super.setup();
    }

    @Test
    @Description("Order creation test")
    public void testCreateOrderPositive() {

        super.createUser(getCorrectUser());

        Order order = new Order(ingredients.getIngredientsRandom());

        // Получение ответа + Проверка
        ValidatableResponse response = orderMethods.createOrder(order, accessToken.substring(7));
        response.assertThat().statusCode(200).and().body(
                "success", equalTo(true),
                "name", notNullValue(),
                "order.number", notNullValue(),
                "order.ingredients", notNullValue(),
                "order.ingredients._id", notNullValue(),
                "order.ingredients.name", notNullValue(),
                "order.ingredients.type", notNullValue(),
                "order.ingredients.proteins", notNullValue(),
                "order.ingredients.fat", notNullValue(),
                "order.ingredients.carbohydrates", notNullValue(),
                "order.ingredients.calories", notNullValue(),
                "order.ingredients.price", notNullValue(),
                "order.ingredients.image", notNullValue(),
                "order.ingredients.image_mobile", notNullValue(),
                "order.ingredients.image_large", notNullValue(),
                "order.ingredients.__v", notNullValue(),
                "order._id", notNullValue(),
                "order.owner", notNullValue(),
                "order.owner.name", notNullValue(),
                "order.owner.email", notNullValue(),
                "order.owner.createdAt", notNullValue(),
                "order.owner.updatedAt", notNullValue(),
                "order.status", notNullValue(),
                "order.name", notNullValue(),
                "order.createdAt", notNullValue(),
                "order.updatedAt", notNullValue(),
                "order.price", notNullValue()
        );
    }
}
