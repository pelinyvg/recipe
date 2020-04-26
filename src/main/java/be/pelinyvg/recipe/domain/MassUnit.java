package be.pelinyvg.recipe.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MassUnit implements Unit {

    public static final MassUnit KILOGRAM = new MassUnit("kilogram", "kg", 1);

    private final String name;
    private final String abbreviation;
    private final double kilogram;

    @JsonCreator
    public MassUnit(@JsonProperty("name") String name,
                    @JsonProperty("abbreviation") String abbreviation,
                    @JsonProperty("kilogram") double kilogram) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.kilogram = kilogram;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public UnitType getType() {
        return UnitType.MASS;
    }

    @Override
    public double getBaseValue() {
        return kilogram;
    }

    @Override
    public Unit getDefaultUnit() {
        return KILOGRAM;
    }

    public double getKilogram() {
        return kilogram;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MassUnit)) return false;
        MassUnit that = (MassUnit) o;
        return Double.compare(that.getKilogram(), getKilogram()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAbbreviation(), that.getAbbreviation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAbbreviation(), getKilogram());
    }

    @Override
    public String toString() {
        return "MassUnit{" +
                "name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", kilogram=" + kilogram +
                '}';
    }
}
