package be.pelinyvg.recipe.domain;

import java.util.ArrayList;
import java.util.List;

public class RecipeBook {
    private String name;
    private List<Recipe> recipesMainCourse;

    public RecipeBook(String name) {
        this.name = name;
        this.recipesMainCourse = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipesMainCourse() {
        return recipesMainCourse;
    }

    public void setRecipesMainCourse(List<Recipe> recipesMainCourse) {
        this.recipesMainCourse = recipesMainCourse;
    }

    public Recipe addRecipe(String name, String description) {
        Recipe recipe = new Recipe();
        recipesMainCourse.add(new Recipe(recipe.getName(), recipe.getDescription()));
        return recipe;
    }
}
