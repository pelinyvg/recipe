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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Unit getUnit() {
        return unit;
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

    public IngredientAmount normalize() {
        return new IngredientAmount(
                ingredient,
                amount * this.unit.getBaseValue(),
                this.unit.getDefaultUnit()
        );
    }

    public IngredientAmount convert(Unit toConvertUnit) {
        IngredientAmount normalized = this.normalize();
        if (toConvertUnit.getType().equals(normalized.getUnit().getType())){
            return new IngredientAmount(
                    ingredient,
                    normalized.getAmount() / toConvertUnit.getBaseValue(),
                    toConvertUnit
            );
        } else {
            if(normalized.getUnit().getType().equals(UnitType.MASS) && toConvertUnit.getType().equals(UnitType.VOLUME)){
                return new IngredientAmount(
                        ingredient,
                        (normalized.getAmount() / ingredient.getDensity()) / toConvertUnit.getBaseValue() ,
                        toConvertUnit
                );
            }
            if(normalized.getUnit().getType().equals(UnitType.VOLUME) && toConvertUnit.getType().equals(UnitType.MASS)){
                return new IngredientAmount(
                        ingredient,
                        (normalized.getAmount() * ingredient.getDensity()) / toConvertUnit.getBaseValue() ,
                        toConvertUnit
                );
            }
        }
        throw new IllegalArgumentException("Can't convert ingredient amount");
    }
}
