package be.pelinyvg.recipe.domain;

import be.pelinyvg.recipe.repository.IngredientRepository;
import be.pelinyvg.recipe.repository.MassUnitRepository;
import be.pelinyvg.recipe.repository.VolumeUnitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientAmountTest {

    public static final String WATER = "water";
    private static final String FLOUR = "flour";
    private static final String KILOGRAM_ABBREVIATION = "kg";
    private static final String POUND = "pound";
    private static final String TABLESPOON = "tablespoon";
    private IngredientAmount flourAmount;
    private IngredientRepository ingredientRepository;
    private MassUnitRepository massUnitRepository;
    private VolumeUnitRepository volumeUnitRepository;

    @BeforeEach
    void setUp() throws IOException {
        ingredientRepository = new IngredientRepository();
        massUnitRepository = new MassUnitRepository();
        volumeUnitRepository = new VolumeUnitRepository();

        Ingredient foundIngredient = ingredientRepository.findByName(FLOUR);
        MassUnit foundUnit = massUnitRepository.findByAbbreviation(KILOGRAM_ABBREVIATION);

        flourAmount = new IngredientAmount(foundIngredient, 1, foundUnit);
    }

    @Test
    void shouldConvertMass() {
        MassUnit toConvertUnit = massUnitRepository.findByName(POUND);
        IngredientAmount convertedAmount = flourAmount.convert(toConvertUnit);

        assertEquals(flourAmount.getIngredient(), convertedAmount.getIngredient());
        assertEquals(toConvertUnit, convertedAmount.getUnit());
        assertEquals(2.2046244201837775, convertedAmount.getAmount());
    }

    @Test
    void shouldReturnSameObjectWhenConvertingSameUnit() {
        IngredientAmount convertedAmount = flourAmount.convert(flourAmount.getUnit());

        assertSame(flourAmount, convertedAmount);

    }

    @Test
    void shouldConvertVolume() {
        VolumeUnit toConvertUnit = volumeUnitRepository.findByName(TABLESPOON);
        IngredientAmount convertedAmount = flourAmount.convert(toConvertUnit);

        assertEquals(flourAmount.getIngredient(), convertedAmount.getIngredient());
        assertEquals(toConvertUnit, convertedAmount.getUnit());
        assertEquals(127.81682919914316, convertedAmount.getAmount());
    }

    @Test
    void shouldScaleWithRatio() {
        IngredientAmount scaled = flourAmount.scale(2);

        assertEquals(flourAmount.getIngredient(), scaled.getIngredient());
        assertEquals(flourAmount.getUnit(), scaled.getUnit());
        assertEquals(2, scaled.getAmount());
    }

    @Test
    void shouldReturnRatio() {
        VolumeUnit tablespoon = volumeUnitRepository.findByName(TABLESPOON);
        IngredientAmount amountAvailable = new IngredientAmount(flourAmount.getIngredient(), 50, tablespoon);

        assertEquals(0.391184794, flourAmount.getRatio(amountAvailable));
    }

    @Test
    void shouldThrowExceptionIfIngredientNotSame() {
        Ingredient water = ingredientRepository.findByName(WATER);
        VolumeUnit tablespoon = volumeUnitRepository.findByName(TABLESPOON);
        IngredientAmount amountAvailable = new IngredientAmount(water, 50, tablespoon);

        assertThrows(IllegalArgumentException.class,
                () -> flourAmount.getRatio(amountAvailable),
                "Can't find the ratio between different ingredients flour and water");
    }
}
