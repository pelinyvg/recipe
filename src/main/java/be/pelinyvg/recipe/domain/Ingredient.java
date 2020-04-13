package be.pelinyvg.recipe.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Ingredient {
    private final String name;
    private final double density;
    private final MaterialType type;

    @JsonCreator
    public Ingredient(@JsonProperty("name") String name,
                      @JsonProperty("density") double density,
                      @JsonProperty("type") MaterialType type) {
        this.name = name;
        this.density = density;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    public MaterialType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.getDensity(), getDensity()) == 0 &&
                getName().equals(that.getName()) &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDensity(), getType());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", density=" + density +
                ", type=" + type +
                '}';
    }
}
