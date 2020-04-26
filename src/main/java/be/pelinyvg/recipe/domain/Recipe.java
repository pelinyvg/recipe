package be.pelinyvg.recipe.domain;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private String description;
    private List<IngredientAmount> ingredients;

    public Recipe() {
    }

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<IngredientAmount> getIngredients() {
        return ingredients;
    }
}
