package be.pelinyvg.recipe.repository;

import be.pelinyvg.recipe.domain.VolumeUnit;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Set;

import static be.pelinyvg.recipe.util.JsonUtilities.readJson;

public class VolumeUnitRepository implements AbbreviationRepository<VolumeUnit> {

    private final Set<VolumeUnit> volumeUnits;

    public VolumeUnitRepository() throws IOException {
        this.volumeUnits = readJson("volume.json", new TypeReference<Set<VolumeUnit>>() {
        });
    }

    @Override
    public VolumeUnit findByAbbreviation(String abbreviation) {
        for (VolumeUnit volumeUnit : volumeUnits) {
            if (volumeUnit.getAbbreviation().equals(abbreviation)) {
                return volumeUnit;
            }
        }
        return null;
    }

    @Override
    public VolumeUnit findByName(String name) {
        for (VolumeUnit volumeUnit : volumeUnits) {
            if (volumeUnit.getName().equals(name)) {
                return volumeUnit;
            }
        }
        return null;
    }
}
