package org.wcci.apimastery.Storages.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.Artist;

import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Optional<Artist> findByName(String name);
}
