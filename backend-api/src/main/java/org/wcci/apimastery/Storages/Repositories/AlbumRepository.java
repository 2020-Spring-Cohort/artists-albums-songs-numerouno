package org.wcci.apimastery.Storages.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Artist;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {
//    Optional<Album> findByName(String name);
}
