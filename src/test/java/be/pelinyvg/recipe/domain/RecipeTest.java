package be.pelinyvg.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeTest extends DomainTest {
    private static final String NAME = "Lasagne";
    private static final String DESCRIPTION = "An Italian dish with pasta";

    private Recipe lasagne;

    @Override
    @BeforeEach
    void setUp() throws IOException {
        super.setUp();
        lasagne = new Recipe(NAME, DESCRIPTION);
    }

    @Test
    void shouldAddIngredients() {
        //given an ingredient amount
        IngredientAmount ingredientAmount = new IngredientAmount(new Ingredient("water", 1, MaterialType.LIQUID), 0.5, new VolumeUnit("tablespoon", "tbsp", 0.0147868));
        //when i add it to recipe
        lasagne.addIngredient(ingredientAmount);
        //it should store
        assertTrue(lasagne.getIngredients().contains(ingredientAmount));
    }

    @Test
    void shouldContainIngredient() {
        //given an ingredient amount
        IngredientAmount ingredientAmount = new IngredientAmount(new Ingredient("water", 1, MaterialType.LIQUID), 0.5, new VolumeUnit("tablespoon", "tbsp", 0.0147868));
        //when i add it to recipe
        lasagne.addIngredient(ingredientAmount);
        //it should store
        assertTrue(lasagne.contains(ingredientAmount));
        assertTrue(lasagne.contains(new IngredientAmount(new Ingredient("water", 1, MaterialType.LIQUID), 0.5, new VolumeUnit("tablespoon", "tbsp", 0.0147868))));
    }

    @Test
    void shouldThrowWhenAddingZero() {
        //given
        IngredientAmount ingredientAmount = new IngredientAmount(new Ingredient("water", 1, MaterialType.LIQUID), 0, new VolumeUnit("tablespoon", "tbsp", 0.0147868));
        //it should throw exception
        assertThrows(IllegalArgumentException.class, () -> lasagne.addIngredient(ingredientAmount), "The ingredient amount must be more than 0");
    }

    @Test
    void shouldThrowWhenAddingNegative() {
        //given
        IngredientAmount ingredientAmount = new IngredientAmount(new Ingredient("water", 1, MaterialType.LIQUID), -1, new VolumeUnit("tablespoon", "tbsp", 0.0147868));
        //it should throw exception
        assertThrows(IllegalArgumentException.class, () -> lasagne.addIngredient(ingredientAmount), "The ingredient amount cannot be a negative number");
    }
}
