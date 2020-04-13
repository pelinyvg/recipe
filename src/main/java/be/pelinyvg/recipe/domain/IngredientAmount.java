package be.pelinyvg.recipe.domain;

import java.util.Objects;

public class IngredientAmount {
    private final Ingredient ingredient;
    private final double amount;
    private final Unit unit;

    public IngredientAmount(Ingredient ingredient, double amount, Unit unit) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientAmount)) return false;
        IngredientAmount that = (IngredientAmount) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 &&
                ingredient.equals(that.ingredient) &&
                unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, getAmount(), unit);
    }

    @Override
    public String toString() {
        return "IngredientAmount{" +
                "ingredient=" + ingredient +
                ", amount=" + amount +
                ", unit=" + unit +
                '}';
    }
}
