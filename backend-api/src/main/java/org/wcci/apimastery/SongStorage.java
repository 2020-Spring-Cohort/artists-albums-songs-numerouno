package org.wcci.apimastery;

import java.util.Collection;

public interface SongStorage {

    Collection<Song> getAll();
    void store(Song song);
    Song findSongByName(String name);
    Song findASongById(long id);


    Song findSongById(long id);
}
