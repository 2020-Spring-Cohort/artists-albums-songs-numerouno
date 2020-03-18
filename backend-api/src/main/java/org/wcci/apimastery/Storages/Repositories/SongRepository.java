package org.wcci.apimastery.Storages.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.Song;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
//    Optional<Song> findSongByName(String name);
}
