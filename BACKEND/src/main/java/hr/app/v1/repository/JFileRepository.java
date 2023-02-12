package hr.app.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.app.v1.model.JFileEntity;

/**
 * JFileRepository interface extends JPA's JpaRepository interface.
 * It is used to interact with JFileEntity objects in the database.
 * 
 */
@Repository
public interface JFileRepository extends JpaRepository<JFileEntity, Long> {

    /**
     * This method is used to find a JFileEntity object in the database by its name.
     * 
     * @param name The name of the JFileEntity to be found.
     * @return The JFileEntity object with the specified name.
     */
    JFileEntity findByName(String name);
    
}
