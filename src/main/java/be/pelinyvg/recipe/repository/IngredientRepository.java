package be.pelinyvg.recipe.repository;

import be.pelinyvg.recipe.domain.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Set;

import static be.pelinyvg.recipe.util.JsonUtilities.readJson;

public class IngredientRepository implements Repository<Ingredient> {

    private final Set<Ingredient> ingredients;

    public IngredientRepository() throws IOException {
        this.ingredients = readJson("ingredient.json", new TypeReference<Set<Ingredient>>() {
        });
    }

    @Override
    public Ingredient findByName(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return null;
    }
}



