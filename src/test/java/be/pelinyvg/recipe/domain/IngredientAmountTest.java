package be.pelinyvg.recipe.domain;

import be.pelinyvg.recipe.repository.IngredientRepository;
import be.pelinyvg.recipe.repository.MassUnitRepository;
import be.pelinyvg.recipe.repository.VolumeUnitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientAmountTest {

    private static final String INGREDIENT = "flour";
    private static final String ABBREVIATION = "kg";

    private static final String MASS_CONVERTED_UNIT = "pound";
    private static final String VOLUME_CONVERTED_UNIT = "tablespoon";

    private IngredientAmount flourAmount;
    private IngredientRepository ingredientRepository;
    private MassUnitRepository massUnitRepository;
    private VolumeUnitRepository volumeUnitRepository;

    @BeforeEach
    void setUp() throws IOException {
        ingredientRepository = new IngredientRepository();
        massUnitRepository = new MassUnitRepository();
        volumeUnitRepository = new VolumeUnitRepository();

        Ingredient foundIngredient = ingredientRepository.findByName(INGREDIENT);
        MassUnit foundUnit = massUnitRepository.findByAbbreviation(ABBREVIATION);

        flourAmount = new IngredientAmount(foundIngredient, 1, foundUnit);
    }

    @Test
    void shouldConvertMass() throws Exception {
        MassUnit toConvertUnit = massUnitRepository.findByName(MASS_CONVERTED_UNIT);
        IngredientAmount convertedAmount = flourAmount.convert(toConvertUnit);

        assertEquals(flourAmount.getIngredient(), convertedAmount.getIngredient());
        assertEquals(toConvertUnit, convertedAmount.getUnit());
        assertEquals(2.2046244201837775, convertedAmount.getAmount());
    }

    @Test
    void shouldConvertVolume() throws Exception {
        VolumeUnit toConvertUnit = volumeUnitRepository.findByName(VOLUME_CONVERTED_UNIT);
        IngredientAmount convertedAmount = flourAmount.convert(toConvertUnit);

        assertEquals(flourAmount.getIngredient(), convertedAmount.getIngredient());
        assertEquals(toConvertUnit, convertedAmount.getUnit());
        assertEquals(127.81682919914316, convertedAmount.getAmount());
    }


}
