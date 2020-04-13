package be.pelinyvg.recipe.repository;

import be.pelinyvg.recipe.domain.MassUnit;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Set;

import static be.pelinyvg.recipe.util.JsonUtilities.readJson;

public class MassUnitRepository implements AbbreviationRepository<MassUnit> {

    private final Set<MassUnit> massUnits;

    public MassUnitRepository() throws IOException {
        this.massUnits = readJson("mass.json", new TypeReference<Set<MassUnit>>() {
        });
    }

    @Override
    public MassUnit findByAbbreviation(String abbreviation) {
        for (MassUnit massUnit : massUnits) {
            if (massUnit.getAbbreviation().equals(abbreviation)) {
                return massUnit;
            }
        }
        return null;
    }

    @Override
    public MassUnit findByName(String name) {
        for (MassUnit massUnit : massUnits) {
            if (massUnit.getName().equals(name)) {
                return massUnit;
            }
        }
        return null;
    }
}
