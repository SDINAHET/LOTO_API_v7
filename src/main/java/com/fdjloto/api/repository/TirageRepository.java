package com.fdjloto.api.repository;

import com.fdjloto.api.model.Tirage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import java.util.Optional;
import java.util.Date;

/**
 * Repository interface for managing **Tirage (Lottery Draws)** in MongoDB.
 * This interface extends **MongoRepository**, providing built-in CRUD operations.
 */
@Repository
public interface TirageRepository extends MongoRepository<Tirage, String> {

    /**
     * 🔥 OG dynamique → recherche par date
     */
    // Optional<Tirage> findByDateDeTirageStartingWith(String date);
    // Optional<Tirage> findByDateDeTirage(String dateDeTirage);
    // Optional<Tirage> findByDateDeTirageBetween(Date start, Date end);
    // Optional<Tirage> findByDateDeTirageStartingWith(String dateDeTirage);
    // @Query("{ 'dateDeTirage': { $regex: ?0 } }")
    // Optional<Tirage> findByDatePrefix(String regex);

    @Query("{ 'dateDeTirage': { $gte: ?0, $lt: ?1 } }")
    Optional<Tirage> findByDateBetween(Date start, Date end);
    /**
     * 🔥 Dernier tirage (SEO homepage / OG fallback)
     */
    Optional<Tirage> findFirstByOrderByDateDeTirageDesc();

    /**
     * Retrieves the **last 20 lottery draws**, sorted in descending order (most recent first).
     *
     * @param sort The sorting parameter (typically by `dateTirage` in descending order).
     * @return A **list of the latest 20 Tirage entries**, ordered by draw date.
     */
    // @Query("{}")
    // List<Tirage> findTop20ByOrderByDateTirageDesc(Sort sort);
    List<Tirage> findTop20ByOrderByDateDeTirageDesc();
}

/**
 * 💡 Explanation:
 * - `TirageRepository` is a **MongoDB repository** that manages lottery draw records.
 * - It **extends MongoRepository<Tirage, String>**, where:
 *   - `Tirage` is the entity.
 *   - `String` is the primary key type.
 * - **Custom query methods**:
 *   - `findTop20ByOrderByDateTirageDesc(Sort sort)`: Retrieves the **latest 20 draws**, sorted by date.
 * - Uses **MongoDB's `@Query` annotation** to define custom queries.
 * - The **sorting parameter** (`Sort sort`) ensures that results are ordered from most recent to oldest.
 */
