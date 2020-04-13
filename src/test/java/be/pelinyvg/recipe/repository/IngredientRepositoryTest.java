package be.pelinyvg.recipe.repository;

import be.pelinyvg.recipe.domain.Ingredient;
import be.pelinyvg.recipe.domain.MaterialType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientRepositoryTest {

    public static final String NAME = "flour";
    public static final Ingredient FLOUR = new Ingredient("flour", 0.59, MaterialType.SOLID);

    @Test
    void shouldFindByName() throws Exception {
        IngredientRepository ingredientRepository = new IngredientRepository();
        Ingredient found = ingredientRepository.findByName(NAME);
        assertEquals(found, FLOUR);
    }

}
