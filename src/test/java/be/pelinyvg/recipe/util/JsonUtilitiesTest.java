package be.pelinyvg.recipe.util;

import be.pelinyvg.recipe.domain.Ingredient;
import be.pelinyvg.recipe.domain.MassUnit;
import be.pelinyvg.recipe.domain.MaterialType;
import be.pelinyvg.recipe.domain.VolumeUnit;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static be.pelinyvg.recipe.util.JsonUtilities.readJson;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonUtilitiesTest {
    @Test
    void shouldReadIngredientsJson() throws Exception {
        Set<Ingredient> ingredients = readJson("ingredient.json", new TypeReference<Set<Ingredient>>() {
        });
        
        // Then the example is contained in the result
        Ingredient example = new Ingredient("water", 1, MaterialType.LIQUID);
        assertTrue(ingredients.contains(example));
    }

    @Test
    void shouldReadMassJson() throws Exception {
        Set<MassUnit> massUnits = readJson("mass.json", new TypeReference<Set<MassUnit>>() {
        });

        // Then the example is contained in the result
        MassUnit example = new MassUnit("pound", "lb", 0.453592);
        assertTrue(massUnits.contains(example));
    }

    @Test
    void shouldReadVolumeJson() throws Exception {
        Set<VolumeUnit> volumeUnits = readJson("volume.json", new TypeReference<Set<VolumeUnit>>() {
        });

        // Then the example is contained in the result
        VolumeUnit example = new VolumeUnit("tablespoon", "tbsp", 0.0147868);
        assertTrue(volumeUnits.contains(example));
    }
}
