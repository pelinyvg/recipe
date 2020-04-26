package be.pelinyvg.recipe.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        return Collections.unmodifiableList(ingredients);
    }

    public void addIngredient(IngredientAmount ingredientAmount) {
        if (ingredientAmount.getAmount() == 0) {
            throw new IllegalArgumentException("The ingredient amount must be more than 0");
        } else if(ingredientAmount.getAmount() < 0) {
            throw new IllegalArgumentException("The ingredient amount cannot be a negative number");
        }
        ingredients.add(ingredientAmount);
    }

    public boolean contains(IngredientAmount ingredientAmount) {
        if (ingredientAmount == null) {
            return false;
        }
        return this.ingredients.contains(ingredientAmount);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients.stream().map(IngredientAmount::toString).collect(Collectors.joining(", ")) +
                '}';
    }
}
