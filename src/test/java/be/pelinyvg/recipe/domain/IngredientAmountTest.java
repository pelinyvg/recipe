package be.pelinyvg.recipe.domain;

import be.pelinyvg.recipe.repository.IngredientRepository;
import be.pelinyvg.recipe.repository.MassUnitRepository;
import org.junit.jupiter.api.Test;

public class IngredientAmountTest {

    private static final String NAME = "flour";
    private static final String ABBREVIATION = "kg";

    @Test
    void name() throws Exception{

        IngredientRepository ingredientRepository = new IngredientRepository();
        Ingredient foundIngredient = ingredientRepository.findByName(NAME);
        MassUnitRepository massUnitRepository = new MassUnitRepository();
        MassUnit foundUnit = massUnitRepository.findByAbbreviation(ABBREVIATION);

        IngredientAmount ingredientAmount = new IngredientAmount(foundIngredient, 1, foundUnit);

        System.out.println(ingredientAmount);
    }


}
