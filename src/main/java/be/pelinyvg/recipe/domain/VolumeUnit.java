package be.pelinyvg.recipe.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class VolumeUnit implements Unit {

    public static final VolumeUnit LITER = new VolumeUnit("liter", "l", 1);

    private final String name;
    private final String abbreviation;
    private final double liter;

    @JsonCreator
    public VolumeUnit(@JsonProperty("name") String name,
                      @JsonProperty("abbreviation") String abbreviation,
                      @JsonProperty("liter") double liter) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.liter = liter;
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
        return UnitType.VOLUME;
    }

    @Override
    public double getBaseValue() {
        return liter;
    }

    @Override
    public Unit getDefaultUnit() {
        return LITER;
    }

    public double getLiter() {
        return liter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VolumeUnit)) return false;
        VolumeUnit that = (VolumeUnit) o;
        return Double.compare(that.getLiter(), getLiter()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAbbreviation(), that.getAbbreviation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAbbreviation(), getLiter());
    }

    @Override
    public String toString() {
        return "VolumeUnit{" +
                "name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", liter=" + liter +
                '}';
    }
}
