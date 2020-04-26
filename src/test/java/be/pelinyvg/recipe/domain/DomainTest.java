package be.pelinyvg.recipe.domain;

import be.pelinyvg.recipe.repository.IngredientRepository;
import be.pelinyvg.recipe.repository.MassUnitRepository;
import be.pelinyvg.recipe.repository.VolumeUnitRepository;

import java.io.IOException;

public class DomainTest {
    protected IngredientRepository ingredientRepository;
    protected MassUnitRepository massUnitRepository;
    protected VolumeUnitRepository volumeUnitRepository;


    void setUp() throws IOException {
        ingredientRepository = new IngredientRepository();
        massUnitRepository = new MassUnitRepository();
        volumeUnitRepository = new VolumeUnitRepository();
    }
}
