package be.pelinyvg.recipe.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.Set;

public interface JsonUtilities {

    static <T> Set<T> readJson(String fileName, TypeReference<Set<T>> typeReference) throws java.io.IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException(String.format("Could not find resource with filename %s", fileName));
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource, typeReference);
    }

}
