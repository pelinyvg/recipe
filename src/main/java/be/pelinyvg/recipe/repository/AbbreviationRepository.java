package be.pelinyvg.recipe.repository;

public interface AbbreviationRepository<T> extends Repository<T> {

    T findByAbbreviation(String abbreviation);

}
