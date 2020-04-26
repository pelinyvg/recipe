package be.pelinyvg.recipe.domain;

public interface Unit {
    String getName();
    String getAbbreviation();
    UnitType getType();
    double getBaseValue();
    Unit getDefaultUnit();
}
