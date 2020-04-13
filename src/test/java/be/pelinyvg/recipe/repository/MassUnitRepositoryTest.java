package be.pelinyvg.recipe.repository;

import be.pelinyvg.recipe.domain.MassUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MassUnitRepositoryTest {

    public static final String NAME = "kilogram";
    public static final String ABBREVIATION = "kg";
    public static final MassUnit KILOGRAM = new MassUnit("kilogram", "kg", 1);

    @Test
    void shouldFindByName() throws Exception {
        MassUnitRepository massUnitRepository = new MassUnitRepository();
        MassUnit found = massUnitRepository.findByName(NAME);
        assertEquals(found, KILOGRAM);
    }

    @Test
    void shouldFindByAbbreviation() throws Exception {
        MassUnitRepository massUnitRepository = new MassUnitRepository();
        MassUnit found = massUnitRepository.findByAbbreviation(ABBREVIATION);
        assertEquals(found, KILOGRAM);
    }

}
