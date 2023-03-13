package praktikum;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Ingredients {

    private final List<String> ingredientsRandom;

    public Ingredients() {

        //Извлечение id ингридиентов
        List<String> ingredients = new IngredientsMethods().getIngredients().extract().path("data._id");

        int bound = ingredients.size();
        ingredientsRandom = asList(
                ingredients.get(new Random().nextInt(bound)),
                ingredients.get(new Random().nextInt(bound)),
                ingredients.get(new Random().nextInt(bound))
        );
    }

    public List<String> getIngredientsRandom() {
        return ingredientsRandom;
    }
}