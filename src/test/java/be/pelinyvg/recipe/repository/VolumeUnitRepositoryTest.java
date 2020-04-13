package be.pelinyvg.recipe.repository;

import be.pelinyvg.recipe.domain.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolumeUnitRepositoryTest {

    public static final String NAME = "tablespoon";
    public static final String ABBREVIATION = "tbsp";
    public static final VolumeUnit TABLESPOON = new VolumeUnit("tablespoon", "tbsp", 0.0147868);

    @Test
    void shouldFindByName() throws Exception {
        VolumeUnitRepository volumeUnitRepository = new VolumeUnitRepository();
        VolumeUnit found = volumeUnitRepository.findByName(NAME);
        assertEquals(found, TABLESPOON);
    }

    @Test
    void shouldFindByAbbreviation() throws Exception {
        VolumeUnitRepository volumeUnitRepository = new VolumeUnitRepository();
        VolumeUnit found = volumeUnitRepository.findByAbbreviation(ABBREVIATION);
        assertEquals(found, TABLESPOON);
    }

}
