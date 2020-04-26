package be.pelinyvg.recipe.repository;

/**
 * Repository in order to access data in our domain.
 *
 * @param <T> The type of data.
 */
public interface Repository<T> {

    T findByName(String name);

}
